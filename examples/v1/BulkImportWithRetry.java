/*
 * Authzed API examples — BulkImportWithRetry
 *
 * Shows how to use RetryableClient to write a batch of relationships via
 * ImportBulkRelationships with automatic fallback to WriteRelationships on failure.
 */
package v1;

import com.authzed.api.v1.*;
import com.authzed.grpcutil.BearerToken;
import com.authzed.grpcutil.RetryableClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BulkImportWithRetry {
    private static final Logger logger = Logger.getLogger(BulkImportWithRetry.class.getName());
    private static final String target = "grpc.authzed.com:443";
    private static final String token  = "tc_your_token_here";

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
            .forTarget(target)
            .useTransportSecurity()
            .build();

        try {
            BearerToken bearerToken = new BearerToken(token);

            // Write the schema first.
            SchemaServiceGrpc.SchemaServiceBlockingStub schemaService =
                SchemaServiceGrpc.newBlockingStub(channel).withCallCredentials(bearerToken);

            schemaService.writeSchema(WriteSchemaRequest.newBuilder()
                .setSchema("""
                    definition document {
                        relation editor: user
                        relation viewer: user
                        permission edit = editor
                        permission view = viewer + editor
                    }
                    definition user {}
                    """)
                .build());

            // Build the relationships to import.
            List<Relationship> relationships = Arrays.asList(
                relationship("document", "readme",   "editor", "user", "alice"),
                relationship("document", "readme",   "viewer", "user", "bob"),
                relationship("document", "handbook", "editor", "user", "alice")
            );

            RetryableClient retryableClient = new RetryableClient(channel, bearerToken);

            // --- Example 1: first import succeeds directly via ImportBulkRelationships ---
            logger.info("Importing relationships (first time)...");
            retryableClient.retryableBulkImportRelationships(relationships, RetryableClient.ConflictStrategy.FAIL);
            logger.info("Import succeeded.");

            // --- Example 2: re-import with SKIP ignores duplicates silently ---
            logger.info("Re-importing with SKIP strategy...");
            retryableClient.retryableBulkImportRelationships(relationships, RetryableClient.ConflictStrategy.SKIP);
            logger.info("SKIP import completed (duplicates ignored).");

            // --- Example 3: re-import with TOUCH overwrites via WriteRelationships ---
            logger.info("Re-importing with TOUCH strategy...");
            retryableClient.retryableBulkImportRelationships(relationships, RetryableClient.ConflictStrategy.TOUCH);
            logger.info("TOUCH import completed (relationships upserted).");

            // --- Example 4: re-import with FAIL raises an error ---
            logger.info("Re-importing with FAIL strategy (expecting error)...");
            try {
                retryableClient.retryableBulkImportRelationships(relationships, RetryableClient.ConflictStrategy.FAIL);
            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "Got expected error: {0}", e.getStatus());
            }

        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    private static Relationship relationship(
            String resourceType, String resourceId,
            String relation,
            String subjectType, String subjectId) {
        return Relationship.newBuilder()
            .setResource(ObjectReference.newBuilder()
                .setObjectType(resourceType)
                .setObjectId(resourceId)
                .build())
            .setRelation(relation)
            .setSubject(SubjectReference.newBuilder()
                .setObject(ObjectReference.newBuilder()
                    .setObjectType(subjectType)
                    .setObjectId(subjectId)
                    .build())
                .build())
            .build();
    }
}
