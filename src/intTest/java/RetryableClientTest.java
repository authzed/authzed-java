import com.authzed.api.v1.*;
import com.authzed.grpcutil.BearerToken;
import com.authzed.grpcutil.RetryableClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.authzed.grpcutil.RetryableClient.ConflictStrategy.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RetryableClientTest {

    private ManagedChannel channel;
    private SchemaServiceGrpc.SchemaServiceBlockingStub schemaService;
    private RetryableClient retryableClient;

    @Before
    public void setUp() {
        channel = ManagedChannelBuilder.forTarget("localhost:50051").usePlaintext().build();
        // Each test instance gets its own token so tests use isolated SpiceDB namespaces.
        String token = "tc_test_retryable_" + new Random().nextInt(100_000);
        BearerToken bearerToken = new BearerToken(token);
        schemaService = SchemaServiceGrpc.newBlockingStub(channel).withCallCredentials(bearerToken);
        retryableClient = new RetryableClient(channel, bearerToken);
        writeTestSchema();
    }

    @After
    public void tearDown() throws InterruptedException {
        channel.shutdownNow().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    @Test
    public void testSuccessfulImport() {
        List<Relationship> rels = relationships("post-1", "alice");
        // Should complete without throwing.
        retryableClient.retryableBulkImportRelationships(rels, FAIL);
    }

    @Test
    public void testSkipStrategyIgnoresConflict() {
        List<Relationship> rels = relationships("post-2", "alice");
        retryableClient.retryableBulkImportRelationships(rels, FAIL);
        // Re-importing the same relationships with SKIP should succeed silently.
        retryableClient.retryableBulkImportRelationships(rels, SKIP);
    }

    @Test
    public void testTouchStrategyRetriesOnConflict() {
        List<Relationship> rels = relationships("post-3", "alice");
        retryableClient.retryableBulkImportRelationships(rels, FAIL);
        // Re-importing with TOUCH falls back to WriteRelationships and succeeds.
        retryableClient.retryableBulkImportRelationships(rels, TOUCH);
    }

    @Test
    public void testFailStrategyThrowsOnConflict() {
        List<Relationship> rels = relationships("post-4", "alice");
        retryableClient.retryableBulkImportRelationships(rels, FAIL);

        assertThatThrownBy(() -> retryableClient.retryableBulkImportRelationships(rels, FAIL))
            .isInstanceOf(StatusRuntimeException.class)
            .satisfies(e -> assertThat(((StatusRuntimeException) e).getStatus().getCode())
                .isEqualTo(Status.Code.ALREADY_EXISTS));
    }

    @Test
    public void testMultipleRelationshipsImport() {
        List<Relationship> rels = Arrays.asList(
            relationship("post-multi", "writer", "alice"),
            relationship("post-multi", "reader", "bob")
        );
        retryableClient.retryableBulkImportRelationships(rels, FAIL);
        // Both relationships should be importable with TOUCH on re-import.
        retryableClient.retryableBulkImportRelationships(rels, TOUCH);
    }

    // --- helpers ---

    private List<Relationship> relationships(String postId, String userId) {
        return Arrays.asList(relationship(postId, "writer", userId));
    }

    private Relationship relationship(String postId, String relation, String userId) {
        return Relationship.newBuilder()
            .setResource(ObjectReference.newBuilder()
                .setObjectType("post")
                .setObjectId(postId)
                .build())
            .setRelation(relation)
            .setSubject(SubjectReference.newBuilder()
                .setObject(ObjectReference.newBuilder()
                    .setObjectType("user")
                    .setObjectId(userId)
                    .build())
                .build())
            .build();
    }

    private void writeTestSchema() {
        String schema = "definition post {\n"
            + "  relation writer: user\n"
            + "  relation reader: user\n"
            + "  permission view = reader + writer\n"
            + "}\n"
            + "definition user {}";
        schemaService.writeSchema(WriteSchemaRequest.newBuilder().setSchema(schema).build());
    }
}
