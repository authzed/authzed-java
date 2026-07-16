package com.authzed.grpcutil;

import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BearerTokenTest {
    private static final Metadata.Key<String> AUTHORIZATION_KEY =
        Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Test
    public void appliesBearerHeader() {
        BearerToken credentials = new BearerToken("sometoken");
        RecordingApplier applier = new RecordingApplier();

        credentials.applyRequestMetadata(null, Runnable::run, applier);

        assertThat(applier.failure).isNull();
        assertThat(applier.headers).isNotNull();
        assertThat(applier.headers.get(AUTHORIZATION_KEY)).isEqualTo("Bearer sometoken");
    }

    @Test
    public void doesNotCallFailAfterApplyThrows() {
        BearerToken credentials = new BearerToken("sometoken");
        RuntimeException applyError = new RuntimeException("apply failed");
        RecordingApplier applier = new RecordingApplier() {
            @Override
            public void apply(Metadata headers) {
                throw applyError;
            }
        };

        // If apply() itself throws, calling fail() afterwards is illegal and would
        // mask the original exception, so the exception should propagate as-is.
        assertThatThrownBy(() -> credentials.applyRequestMetadata(null, Runnable::run, applier))
            .isSameAs(applyError);
        assertThat(applier.failure).isNull();
    }

    private static class RecordingApplier extends CallCredentials.MetadataApplier {
        Metadata headers;
        Status failure;

        @Override
        public void apply(Metadata headers) {
            this.headers = headers;
        }

        @Override
        public void fail(Status status) {
            this.failure = status;
        }
    }
}
