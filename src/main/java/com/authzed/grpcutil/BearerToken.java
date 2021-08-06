package com.authzed.grpcutil;

import io.grpc.*;

import java.util.concurrent.Executor;

/**
 * Bearer token implementation that can be used with GRPC stubs.
 */
public class BearerToken extends CallCredentials {
    public static final String AUTHORIZATION = "authorization";
    private static final Metadata.Key<String> META_DATA_KEY =
        Metadata.Key.of(AUTHORIZATION, Metadata.ASCII_STRING_MARSHALLER);

    private final String token;
    private final String header;

    public BearerToken(String value) {
        this.token = value;
        this.header = "Bearer " + token;
    }

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier applier) {
        executor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(META_DATA_KEY, header);
                applier.apply(headers);
            } catch (Throwable e) {
                applier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }

    @Override
    public void thisUsesUnstableApi() {
        // Intentionally empty
    }
}
