package com.authzed.grpcutil;

import com.authzed.api.v1.ImportBulkRelationshipsRequest;
import com.authzed.api.v1.ImportBulkRelationshipsResponse;
import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.Relationship;
import com.authzed.api.v1.RelationshipUpdate;
import com.authzed.api.v1.WriteRelationshipsRequest;
import io.grpc.CallCredentials;
import io.grpc.Channel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * RetryableClient wraps the SpiceDB PermissionsService to provide a retryable
 * ImportBulkRelationships operation. On failure it falls back to WriteRelationships
 * with configurable conflict resolution behavior.
 *
 * <p>Instances are thread-safe; the underlying gRPC stubs are stateless.
 */
public class RetryableClient {

    /**
     * Determines how duplicate relationships are handled when ImportBulkRelationships fails
     * with a conflict error.
     */
    public enum ConflictStrategy {
        /** Throw an ALREADY_EXISTS error if any duplicate relationships are found. */
        FAIL,
        /** Silently ignore duplicates and treat the operation as successful. */
        SKIP,
        /** Retry with TOUCH semantics (WriteRelationships), overwriting existing relationships. */
        TOUCH,
    }

    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);
    private static final long INITIAL_BACKOFF_MS = 50;
    private static final long MAX_BACKOFF_MS = 2_000;
    private static final int MAX_RETRIES = 10;

    // Legacy string-matching fallbacks for SpiceDB < 1.29.0 that did not yet return proper gRPC codes.
    // See https://github.com/authzed/spicedb/pull/1688
    private static final String[] TX_CONFLICT_STRINGS = {
        "SQLSTATE 23505",     // CockroachDB
        "Error 1062 (23000)", // MySQL
    };
    private static final String[] RETRYABLE_STRINGS = {
        "retryable error",            // CockroachDB, PostgreSQL
        "try restarting transaction", // MySQL
        "Error 1205",                 // MySQL deadlock
    };

    private final PermissionsServiceGrpc.PermissionsServiceStub asyncStub;
    private final PermissionsServiceGrpc.PermissionsServiceBlockingStub blockingStub;

    /**
     * Creates a RetryableClient from a channel and call credentials.
     */
    public RetryableClient(Channel channel, CallCredentials credentials) {
        this.asyncStub = PermissionsServiceGrpc.newStub(channel).withCallCredentials(credentials);
        this.blockingStub = PermissionsServiceGrpc.newBlockingStub(channel).withCallCredentials(credentials);
    }

    /**
     * Creates a RetryableClient from pre-built stubs. Primarily useful for testing.
     */
    public RetryableClient(
            PermissionsServiceGrpc.PermissionsServiceStub asyncStub,
            PermissionsServiceGrpc.PermissionsServiceBlockingStub blockingStub) {
        this.asyncStub = asyncStub;
        this.blockingStub = blockingStub;
    }

    /**
     * Equivalent to {@link #retryableBulkImportRelationships(List, ConflictStrategy, Duration)}
     * with a 30-second per-call timeout.
     */
    public void retryableBulkImportRelationships(
            List<Relationship> relationships, ConflictStrategy conflictStrategy) {
        retryableBulkImportRelationships(relationships, conflictStrategy, DEFAULT_TIMEOUT);
    }

    /**
     * Attempts to write {@code relationships} via ImportBulkRelationships. If the bulk
     * import fails, falls back to WriteRelationships using the given conflict strategy.
     *
     * <p>On a retryable transient failure the fallback itself is retried up to
     * {@value MAX_RETRIES} times with exponential backoff.
     *
     * @param relationships    the relationships to write
     * @param conflictStrategy what to do when a conflict (duplicate) is detected
     * @param callTimeout      deadline applied to both the bulk import and each individual write attempt
     * @throws StatusRuntimeException with ALREADY_EXISTS when conflictStrategy is FAIL and
     *                                duplicates are found; with CANCELLED when interrupted;
     *                                with DEADLINE_EXCEEDED when the call timeout expires;
     *                                with the original status on other gRPC errors
     */
    public void retryableBulkImportRelationships(
            List<Relationship> relationships,
            ConflictStrategy conflictStrategy,
            Duration callTimeout) {

        CompletableFuture<Void> importFuture = new CompletableFuture<>();

        StreamObserver<ImportBulkRelationshipsRequest> requestStream =
            asyncStub
                .withDeadlineAfter(callTimeout.toMillis(), TimeUnit.MILLISECONDS)
                .importBulkRelationships(new StreamObserver<ImportBulkRelationshipsResponse>() {
                    @Override public void onNext(ImportBulkRelationshipsResponse r) {}
                    @Override public void onError(Throwable t) { importFuture.completeExceptionally(t); }
                    @Override public void onCompleted() { importFuture.complete(null); }
                });

        requestStream.onNext(ImportBulkRelationshipsRequest.newBuilder()
            .addAllRelationships(relationships)
            .build());
        requestStream.onCompleted();

        Throwable importError;
        try {
            // The gRPC deadline fires onError before this safety net triggers under normal conditions.
            importFuture.get(callTimeout.toMillis() + 5_000, TimeUnit.MILLISECONDS);
            return;
        } catch (ExecutionException e) {
            importError = e.getCause();
        } catch (TimeoutException e) {
            throw Status.DEADLINE_EXCEEDED
                .withDescription("timed out awaiting bulk import")
                .withCause(e).asRuntimeException();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED
                .withDescription("interrupted while awaiting bulk import")
                .withCause(e).asRuntimeException();
        }

        // Bulk import failed — decide how to respond based on error type and strategy.
        // The stream cannot be reused after failure, so we fall back to WriteRelationships.
        boolean retryable = isRetryableError(importError);
        boolean conflict  = isAlreadyExistsError(importError);

        if (isCanceledError(importError)) {
            throw Status.CANCELLED.withCause(importError).asRuntimeException();
        }
        if (conflict && conflictStrategy == ConflictStrategy.SKIP) {
            return;
        }
        if (retryable || (conflict && conflictStrategy == ConflictStrategy.TOUCH)) {
            writeBatchesWithRetry(relationships, callTimeout);
            return;
        }
        if (conflict && conflictStrategy == ConflictStrategy.FAIL) {
            throw Status.ALREADY_EXISTS
                .withDescription("duplicate relationships found")
                .withCause(importError).asRuntimeException();
        }
        if (importError instanceof StatusRuntimeException) {
            throw (StatusRuntimeException) importError;
        }
        throw Status.INTERNAL
            .withDescription("error finalizing write of " + relationships.size() + " relationships")
            .withCause(importError).asRuntimeException();
    }

    private void writeBatchesWithRetry(List<Relationship> relationships, Duration callTimeout) {
        List<RelationshipUpdate> updates = new ArrayList<>(relationships.size());
        for (Relationship rel : relationships) {
            updates.add(RelationshipUpdate.newBuilder()
                .setRelationship(rel)
                .setOperation(RelationshipUpdate.Operation.OPERATION_TOUCH)
                .build());
        }

        long backoffMs = INITIAL_BACKOFF_MS;
        int retries = 0;

        while (true) {
            try {
                blockingStub
                    .withDeadlineAfter(callTimeout.toMillis(), TimeUnit.MILLISECONDS)
                    .writeRelationships(WriteRelationshipsRequest.newBuilder()
                        .addAllUpdates(updates)
                        .build());
                return;
            } catch (StatusRuntimeException e) {
                if (!isRetryableError(e) || retries >= MAX_RETRIES) {
                    throw e;
                }
                long jittered = (long) (ThreadLocalRandom.current().nextDouble() * backoffMs);
                try {
                    Thread.sleep(jittered);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw Status.CANCELLED
                        .withDescription("interrupted during retry backoff")
                        .withCause(ie).asRuntimeException();
                }
                backoffMs = Math.min(backoffMs * 2, MAX_BACKOFF_MS);
                retries++;
            }
        }
    }

    private static boolean isAlreadyExistsError(Throwable t) {
        if (t == null) return false;
        if (Status.fromThrowable(t).getCode() == Status.Code.ALREADY_EXISTS) return true;
        return containsAny(t, TX_CONFLICT_STRINGS);
    }

    private static boolean isRetryableError(Throwable t) {
        if (t == null) return false;
        Status.Code code = Status.fromThrowable(t).getCode();
        if (code == Status.Code.UNAVAILABLE || code == Status.Code.DEADLINE_EXCEEDED) return true;
        return containsAny(t, RETRYABLE_STRINGS);
    }

    private static boolean isCanceledError(Throwable t) {
        if (t == null) return false;
        return Status.fromThrowable(t).getCode() == Status.Code.CANCELLED;
    }

    private static boolean containsAny(Throwable t, String[] patterns) {
        for (Throwable cause = t; cause != null; cause = cause.getCause()) {
            String msg = cause.getMessage();
            if (msg == null) continue;
            for (String pattern : patterns) {
                if (msg.contains(pattern)) return true;
            }
        }
        return false;
    }
}
