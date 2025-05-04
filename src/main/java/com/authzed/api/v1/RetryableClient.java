package com.authzed.api.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.authzed.api.v1.ExperimentalServiceGrpc.ExperimentalServiceBlockingStub;
import com.authzed.api.v1.ExperimentalServiceGrpc.ExperimentalServiceStub;
import com.authzed.api.v1.PermissionsServiceGrpc.PermissionsServiceBlockingStub;
import com.authzed.api.v1.PermissionsServiceGrpc.PermissionsServiceStub;
import com.authzed.api.v1.SchemaServiceGrpc.SchemaServiceBlockingStub;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.stub.StreamObserver;

/**
 * RetryableClient represents an open connection to SpiceDB with
 * experimental services available. It also adds methods for
 * retrying bulk imports with different conflict strategies.
 * 
 * Clients are backed by a gRPC client and as such are thread-safe.
 */
public class RetryableClient {
    private static final Logger logger = Logger.getLogger(RetryableClient.class.getName());
    
    // Default configuration
    private static final long DEFAULT_BACKOFF_MS = 50;
    private static final long DEFAULT_MAX_RETRIES = 10;
    private static final long DEFAULT_MAX_BACKOFF_MS = 2000;
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;
    
    // Fallback for datastore implementations on SpiceDB < 1.29.0 not returning proper gRPC codes
    private static final List<String> TX_CONFLICT_STRINGS = Arrays.asList(
        "SQLSTATE 23505",      // CockroachDB
        "Error 1062 (23000)"   // MySQL
    );
    
    private static final List<String> RETRYABLE_ERROR_STRINGS = Arrays.asList(
        "retryable error",                            // CockroachDB, PostgreSQL
        "try restarting transaction", "Error 1205"    // MySQL
    );
    
    private final SchemaServiceGrpc.SchemaServiceBlockingStub schemaService;
    private final PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService;
    private final PermissionsServiceGrpc.PermissionsServiceStub asyncPermissionsService;
    private final ExperimentalServiceBlockingStub experimentalService;
    private final ExperimentalServiceStub asyncExperimentalService;
    private final ManagedChannel channel;
    
    /**
     * Create a new RetryableClient with the specified endpoint and credentials.
     * 
     * @param target The endpoint to connect to
     * @param credentials Call credentials for authentication
     * @return A new RetryableClient instance
     */
    public static RetryableClient newClient(String target, CallCredentials credentials) {
        return newClient(target, credentials, false);
    }
    
    /**
     * Create a new RetryableClient with the specified endpoint, credentials and TLS settings.
     * 
     * @param target The endpoint to connect to
     * @param credentials Call credentials for authentication
     * @param usePlaintext If true, use plaintext connection (no TLS)
     * @return A new RetryableClient instance
     */
    public static RetryableClient newClient(String target, CallCredentials credentials, boolean usePlaintext) {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forTarget(target);
        if (usePlaintext) {
            builder.usePlaintext();
        } else {
            builder.useTransportSecurity();
        }
        
        ManagedChannel channel = builder.build();
        return new RetryableClient(channel, credentials);
    }
    
    /**
     * Create a new RetryableClient with the specified channel and credentials.
     * 
     * @param channel The gRPC channel to use
     * @param credentials Call credentials for authentication
     */
    public RetryableClient(Channel channel, CallCredentials credentials) {
        if (channel instanceof ManagedChannel) {
            this.channel = (ManagedChannel) channel;
        } else {
            this.channel = null;
        }
        
        this.schemaService = SchemaServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(credentials);
        this.permissionsService = PermissionsServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(credentials);
        this.asyncPermissionsService = PermissionsServiceGrpc.newStub(channel)
                .withCallCredentials(credentials);
        this.experimentalService = ExperimentalServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(credentials);
        this.asyncExperimentalService = ExperimentalServiceGrpc.newStub(channel)
                .withCallCredentials(credentials);
    }
    
    /**
     * Get the schema service client.
     * 
     * @return The schema service client
     */
    public SchemaServiceGrpc.SchemaServiceBlockingStub schemaService() {
        return schemaService;
    }
    
    /**
     * Get the permissions service client.
     * 
     * @return The permissions service client
     */
    public PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService() {
        return permissionsService;
    }
    
    /**
     * Get the async permissions service client.
     * 
     * @return The async permissions service client
     */
    public PermissionsServiceGrpc.PermissionsServiceStub asyncPermissionsService() {
        return asyncPermissionsService;
    }
    
    /**
     * Get the experimental service client.
     * 
     * @return The experimental service client
     */
    public ExperimentalServiceBlockingStub experimentalService() {
        return experimentalService;
    }
    
    /**
     * Get the async experimental service client.
     * 
     * @return The async experimental service client
     */
    public ExperimentalServiceStub asyncExperimentalService() {
        return asyncExperimentalService;
    }
    
    /**
     * Close the client connection.
     */
    public void close() {
        if (channel != null) {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Error shutting down channel", e);
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * RetryableBulkImportRelationships is a wrapper around BulkImportRelationships.
     * It retries the bulk import with different conflict strategies in case of failure.
     * 
     * The conflict strategy can be one of:
     * - FAIL - will return an error if any duplicate relationships are found.
     * - SKIP - will ignore duplicates and continue with the import.
     * - TOUCH - will retry the import with TOUCH semantics in case of duplicates.
     * 
     * @param relationships The relationships to import
     * @param conflictStrategy The conflict strategy to use
     * @return The number of relationships loaded
     * @throws Exception If there are errors during import
     */
    public long retryableBulkImportRelationships(
            List<Relationship> relationships,
            ConflictStrategy conflictStrategy) throws Exception {
        return retryableBulkImportRelationships(relationships, conflictStrategy, DEFAULT_TIMEOUT_SECONDS);
    }
    
    /**
     * RetryableBulkImportRelationships is a wrapper around BulkImportRelationships.
     * It retries the bulk import with different conflict strategies in case of failure.
     * 
     * The conflict strategy can be one of:
     * - FAIL - will return an error if any duplicate relationships are found.
     * - SKIP - will ignore duplicates and continue with the import.
     * - TOUCH - will retry the import with TOUCH semantics in case of duplicates.
     * 
     * @param relationships The relationships to import
     * @param conflictStrategy The conflict strategy to use
     * @param timeoutSeconds The timeout for the operation in seconds
     * @return The number of relationships loaded
     * @throws Exception If there are errors during import
     */
    public long retryableBulkImportRelationships(
            List<Relationship> relationships,
            ConflictStrategy conflictStrategy,
            int timeoutSeconds) throws Exception {
        
        final BulkImportResponseCollector responseCollector = new BulkImportResponseCollector();
        final StreamObserver<BulkImportRelationshipsResponse> responseObserver = new StreamObserver<BulkImportRelationshipsResponse>() {
            @Override
            public void onNext(BulkImportRelationshipsResponse response) {
                responseCollector.addResponse(response);
            }
            
            @Override
            public void onError(Throwable t) {
                responseCollector.setError(t);
            }
            
            @Override
            public void onCompleted() {
                responseCollector.setCompleted();
            }
        };
        
        // Create initial request
        BulkImportRelationshipsRequest request = BulkImportRelationshipsRequest.newBuilder()
                .addAllRelationships(relationships)
                .build();
        
        // Send the request
        StreamObserver<BulkImportRelationshipsRequest> requestObserver = 
                asyncExperimentalService.bulkImportRelationships(responseObserver);
        
        try {
            requestObserver.onNext(request);
            requestObserver.onCompleted();
            
            // Wait for response to complete
            BulkImportRelationshipsResponse response = responseCollector.await();
            return response.getNumLoaded();
        } catch (Throwable throwable) {
            logger.log(Level.INFO, "Handling error in retryableBulkImportRelationships: " + throwable.getMessage());
            
            // Handle the error based on its type and the chosen conflict strategy
            if (isCanceledError(throwable)) {
                throw new RuntimeException("Request canceled", throwable);
            }
            
            if (isAlreadyExistsError(throwable)) {
                if (conflictStrategy == ConflictStrategy.SKIP) {
                    // Skip conflicts - return success
                    logger.log(Level.INFO, "ALREADY_EXISTS detected with SKIP strategy - returning success");
                    return relationships.size();
                } else if (conflictStrategy == ConflictStrategy.TOUCH) {
                    // Retry with touch semantics
                    logger.log(Level.INFO, "ALREADY_EXISTS detected with TOUCH strategy - retrying with touch semantics");
                    return writeBatchesWithRetry(relationships, timeoutSeconds);
                } else if (conflictStrategy == ConflictStrategy.FAIL) {
                    throw new RuntimeException("Duplicate relationships found", throwable);
                }
            }
            
            if (isRetryableError(throwable)) {
                // Retry with touch semantics for retryable errors regardless of strategy
                logger.log(Level.INFO, "Retryable error detected - retrying with touch semantics");
                return writeBatchesWithRetry(relationships, timeoutSeconds);
            }
            
            throw new RuntimeException(
                    String.format("Error finalizing write of %d relationships", relationships.size()), 
                    throwable);
        }
    }
    
    /**
     * Helper class to collect response from bulk import.
     */
    private static class BulkImportResponseCollector {
        private BulkImportRelationshipsResponse response;
        private Throwable error;
        private boolean completed = false;
        
        synchronized void addResponse(BulkImportRelationshipsResponse resp) {
            response = resp;
        }
        
        synchronized void setError(Throwable t) {
            error = t;
            completed = true;
            notifyAll();
        }
        
        synchronized void setCompleted() {
            completed = true;
            notifyAll();
        }
        
        synchronized BulkImportRelationshipsResponse await() throws Exception {
            while (!completed) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Operation interrupted", e);
                }
            }
            
            if (error != null) {
                throw new RuntimeException("Error in bulk import", error);
            }
            
            return response;
        }
    }
    
    /**
     * Retry writing relationships in batches with exponential backoff.
     */
    private long writeBatchesWithRetry(List<Relationship> relationships, int timeoutSeconds) throws Exception {
        long backoffMs = DEFAULT_BACKOFF_MS;
        long currentRetries = 0;
        
        // Convert relationships to updates with TOUCH operation
        List<RelationshipUpdate> updates = new ArrayList<>(relationships.size());
        for (Relationship relationship : relationships) {
            updates.add(RelationshipUpdate.newBuilder()
                    .setRelationship(relationship)
                    .setOperation(RelationshipUpdate.Operation.OPERATION_TOUCH)
                    .build());
        }
        
        while (true) {
            try {
                WriteRelationshipsRequest request = WriteRelationshipsRequest.newBuilder()
                        .addAllUpdates(updates)
                        .build();
                
                WriteRelationshipsResponse response = permissionsService.withDeadlineAfter(
                        timeoutSeconds, TimeUnit.SECONDS).writeRelationships(request);
                
                return updates.size(); // Success
            } catch (Exception e) {
                if (isRetryableError(e) && currentRetries < DEFAULT_MAX_RETRIES) {
                    // Throttle the writes with exponential backoff
                    Thread.sleep(backoffMs);
                    backoffMs = Math.min(backoffMs * 2, DEFAULT_MAX_BACKOFF_MS);
                    currentRetries++;
                    continue;
                }
                
                throw new RuntimeException("Failed to write relationships after retry", e);
            }
        }
    }
    
    /**
     * Check if an error indicates that a relationship already exists.
     */
    private boolean isAlreadyExistsError(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        
        // Check direct gRPC status
        if (isGrpcStatusCode(throwable, Status.Code.ALREADY_EXISTS)) {
            return true;
        }
        
        // Check error message for "ALREADY_EXISTS" string
        if (throwable.getMessage() != null && 
            throwable.getMessage().contains("ALREADY_EXISTS")) {
            return true;
        }
        
        // Check for transaction conflict strings
        if (containsErrorString(throwable, TX_CONFLICT_STRINGS)) {
            return true;
        }
        
        // Check for a wrapped cause
        Throwable cause = throwable.getCause();
        if (cause != null && cause != throwable) {
            return isAlreadyExistsError(cause);
        }
        
        return false;
    }
    
    /**
     * Check if an error is retryable.
     */
    private boolean isRetryableError(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        
        // Check direct gRPC status
        if (isGrpcStatusCode(throwable, Status.Code.UNAVAILABLE, Status.Code.DEADLINE_EXCEEDED)) {
            return true;
        }
        
        // Check for retryable error strings
        if (containsErrorString(throwable, RETRYABLE_ERROR_STRINGS)) {
            return true;
        }
        
        // Check for timeout exceptions
        if (throwable instanceof java.util.concurrent.TimeoutException) {
            return true;
        }
        
        // Check for a wrapped cause
        Throwable cause = throwable.getCause();
        if (cause != null && cause != throwable) {
            return isRetryableError(cause);
        }
        
        return false;
    }
    
    /**
     * Check if an error indicates that the request was canceled.
     */
    private boolean isCanceledError(Throwable throwable) {
        if (throwable == null) {
            return false;
        }
        
        // Check for cancellation exceptions
        if (throwable instanceof java.util.concurrent.CancellationException ||
                throwable instanceof InterruptedException) {
            return true;
        }
        
        // Check direct gRPC status
        if (isGrpcStatusCode(throwable, Status.Code.CANCELLED)) {
            return true;
        }
        
        // Check for a wrapped cause
        Throwable cause = throwable.getCause();
        if (cause != null && cause != throwable) {
            return isCanceledError(cause);
        }
        
        return false;
    }
    
    /**
     * Check if the throwable's message contains any of the given error strings.
     */
    private boolean containsErrorString(Throwable throwable, List<String> errorStrings) {
        if (throwable == null) {
            return false;
        }
        
        String message = throwable.getMessage();
        if (message == null) {
            return false;
        }
        
        for (String errorString : errorStrings) {
            if (message.contains(errorString)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Check if the throwable is a gRPC error with one of the given status codes.
     */
    private boolean isGrpcStatusCode(Throwable throwable, Status.Code... codes) {
        if (throwable == null) {
            return false;
        }
        
        if (throwable instanceof StatusRuntimeException) {
            StatusRuntimeException statusException = (StatusRuntimeException) throwable;
            Status.Code throwableCode = statusException.getStatus().getCode();
            
            for (Status.Code code : codes) {
                if (code == throwableCode) {
                    return true;
                }
            }
        }
        
        return false;
    }
}