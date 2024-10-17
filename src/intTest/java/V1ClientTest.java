import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import com.authzed.api.v1.*;

import io.grpc.stub.StreamObserver;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class V1ClientTest {
    private static final Consistency fullyConsistent = Consistency.newBuilder().setFullyConsistent(true).build();

    @Test
    public void testBasicSchema() {
        // Initialize services
        var client = new TestClient();
        String schema = """
                definition document {
                    relation reader: user
                }
                definition user {}
                """;
        // Write schema
        writeSchema(client, schema);

        // Read schema
        var readRequest = ReadSchemaRequest.newBuilder().build();
        var readResponse = client.schemaService.readSchema(readRequest);
        assertThat(readResponse.getSchemaText()).contains("definition document");
        assertThat(readResponse.getSchemaText()).contains("definition user");
    }

    @Test
    public void testSchemaWithCaveats() {
        var client = new TestClient();
        writeTestSchema(client);
    }

    // For an example with flow control, see
    // https://github.com/grpc/grpc-java/blob/9071c1ad7c842f4e73b6ae95b71f11c517b177a4/examples/src/main/java/io/grpc/examples/manualflowcontrol/ManualFlowControlClient.java
    @Test
    public void testCheck() {
        var client = new TestClient();
        writeTestSchema(client);
        var testTuples = writeTestTuples(client);

        var firstResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.emilia)
                .setPermission("view")
                .build());
        assertThat(firstResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        var secondResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.emilia)
                .setPermission("write")
                .build());
        assertThat(secondResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        var thirdResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view")
                .build());
        assertThat(thirdResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        var fourthResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("write")
                .build());
        assertThat(fourthResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_NO_PERMISSION);
    }

    @Test
    public void testCaveatedCheck() {
        var client = new TestClient();
        writeTestSchema(client);
        var testTuples = writeTestTuples(client);

        // Likes Harry Potter
        var likesContext = Struct.newBuilder().putFields("likes", Value.newBuilder().setBoolValue(true).build()).build();
        var firstResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view_as_fan")
                .setContext(likesContext)
                .build());
        assertThat(firstResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        // No longer likes Harry Potter
        var dislikesContext = Struct.newBuilder().putFields("likes", Value.newBuilder().setBoolValue(false).build()).build();
        var secondResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view_as_fan")
                .setContext(dislikesContext)
                .build());
        assertThat(secondResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_NO_PERMISSION);

        // No longer likes Harry Potter
        var thirdResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view_as_fan")
                .build());
        assertThat(thirdResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_CONDITIONAL_PERMISSION);
        assertThat(thirdResponse.getPartialCaveatInfo().getMissingRequiredContextList()).contains("likes");
    }

    @Test
    public void testLookupResources() {
        var client = new TestClient();
        writeTestSchema(client);
        var testTuples = writeTestTuples(client);

        var lookupResourcesRequest = LookupResourcesRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResourceObjectType("post")
                .setSubject(testTuples.emilia)
                .setPermission("write")
                .build();

        var resp = client.permissionsService.lookupResources(lookupResourcesRequest);
        var resources = new HashSet<String>();
        resp.forEachRemaining(lookupResourcesResponse -> resources.add(lookupResourcesResponse.getResourceObjectId()));

        assertThat(resources).contains(testTuples.postOne.getObjectId());
        assertThat(resources).contains(testTuples.postTwo.getObjectId());
        assertThat(resources).hasSize(2);
    }

    @Test
    public void testLookupSubjects() {
        var client = new TestClient();
        writeTestSchema(client);
        var testTuples = writeTestTuples(client);

        var lookupSubjectsRequest = LookupSubjectsRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setSubjectObjectType("user")
                .setResource(testTuples.postOne)
                .setPermission("view")
                .build();

        var resp = client.permissionsService.lookupSubjects(lookupSubjectsRequest);
        var users = new HashSet<String>();
        resp.forEachRemaining(response ->
            users.add(response.getSubject().getSubjectObjectId()));

        assertThat(users).contains(testTuples.emilia.getObject().getObjectId());
        assertThat(users).contains(testTuples.beatrice.getObject().getObjectId());
        assertThat(users).hasSize(2);
    }

    @Test
    public void testCheckBulkPermissions() {
        var client = new TestClient();
        writeTestSchema(client);
        var testTuples = writeTestTuples(client);

        var checkBulkPermissionsRequest = CheckBulkPermissionsRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .addItems(CheckBulkPermissionsRequestItem.newBuilder()
                        .setResource(testTuples.postOne)
                        .setPermission("view")
                        .setSubject(testTuples.emilia))
                .addItems(CheckBulkPermissionsRequestItem.newBuilder()
                        .setResource(testTuples.postOne)
                        .setPermission("write")
                        .setSubject(testTuples.emilia))
                .build();

        var response = client.permissionsService.checkBulkPermissions(checkBulkPermissionsRequest);
        assertThat(response.getPairsList()).hasSize(2);
        assertThat(response.getPairs(0).getItem().getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);
        assertThat(response.getPairs(1).getItem().getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);
    }

    @Test
    public void testBulkImport() throws InterruptedException {
        var client = new TestClient();
        writeTestSchema(client);
        writeTestTuples(client);

        // Validate export
        var exportCall = client.permissionsService.exportBulkRelationships(ExportBulkRelationshipsRequest.newBuilder()
                        .setConsistency(fullyConsistent)
                .build());

        var relations = new HashSet<Relationship>();
        exportCall.forEachRemaining(response ->
            relations.addAll(response.getRelationshipsList()));

        assertThat(relations).hasSize(4);

        // Note that this has a different preshared key
        // Validate import
        var emptyClient = new TestClient();
        writeTestSchema(emptyClient);

        final CountDownLatch done = new CountDownLatch(1);

        class ImportBulkObserver implements StreamObserver<ImportBulkRelationshipsResponse> {
            private long loaded;

            @Override
            public void onNext(ImportBulkRelationshipsResponse resp) {
                loaded += resp.getNumLoaded();
            }

            @Override
            public void onError(Throwable throwable) {
                // TODO need to capture error so that blocking callsite is able to access it
                System.out.println("onError");
                done.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
                done.countDown();
            }
        }

        // Do the import
        var importObserver = new ImportBulkObserver();
        var wrappedObserver = client.asyncPermissionsService.importBulkRelationships(importObserver);
        wrappedObserver.onNext(ImportBulkRelationshipsRequest.newBuilder()
                .addAllRelationships(relations).build());
        wrappedObserver.onCompleted();

        done.await();

        // Validate that everything was loaded
        var postImportExportCall = client.permissionsService.exportBulkRelationships(ExportBulkRelationshipsRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .build());

        var importedRelations = new HashSet<Relationship>();
        postImportExportCall.forEachRemaining(response ->
            importedRelations.addAll(response.getRelationshipsList()));

        assertThat(importedRelations).hasSize(4);
    }




    private TestTuples writeTestTuples(TestClient client) {
        var emilia = SubjectReference.newBuilder().setObject(ObjectReference.newBuilder().setObjectId("emilia").setObjectType("user").build()).build();
        var beatrice = SubjectReference.newBuilder().setObject(ObjectReference.newBuilder().setObjectId("beatrice").setObjectType("user").build()).build();
        var postOne = ObjectReference.newBuilder().setObjectId("post-one").setObjectType("post").build();
        var postTwo = ObjectReference.newBuilder().setObjectId("post-two").setObjectType("post").build();
        WriteRelationshipsRequest.Builder builder = WriteRelationshipsRequest.newBuilder()
                .addUpdates(
                        RelationshipUpdate.newBuilder()
                                .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                                .setRelationship(Relationship.newBuilder()
                                        .setRelation("writer")
                                        .setResource(postOne)
                                        .setSubject(emilia)
                                ))
                .addUpdates(
                        RelationshipUpdate.newBuilder()
                                .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                                .setRelationship(Relationship.newBuilder()
                                        .setRelation("writer")
                                        .setResource(postTwo)
                                        .setSubject(emilia)
                                ))
                .addUpdates(
                        RelationshipUpdate.newBuilder()
                                .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                                .setRelationship(Relationship.newBuilder()
                                        .setRelation("reader")
                                        .setResource(postOne)
                                        .setSubject(beatrice)
                                )
                )
                .addUpdates(
                        RelationshipUpdate.newBuilder()
                                .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                                .setRelationship(Relationship.newBuilder()
                                        .setRelation("caveated_reader")
                                        .setResource(postOne)
                                        .setSubject(beatrice)
                                        .setOptionalCaveat(ContextualizedCaveat.newBuilder()
                                                .setCaveatName("likes_harry_potter"))
                                )
                );
        client.permissionsService.writeRelationships(builder.build());
        return new TestTuples(emilia, beatrice, postOne, postTwo);
    }

    private void writeTestSchema(TestClient client) {
        String schema = """
                caveat likes_harry_potter(likes bool) {
                    likes == true
                }
                
                definition post {
                    relation writer: user
                    relation reader: user
                    relation caveated_reader: user with likes_harry_potter
                
                    permission write = writer
                    permission view = reader + writer
                    permission view_as_fan = caveated_reader + writer
                }
                definition user {}
                """;
        writeSchema(client, schema);
    }

    private void writeSchema(TestClient client, String schema) {
        WriteSchemaRequest writeRequest = WriteSchemaRequest
                .newBuilder()
                .setSchema(schema)
                .build();
        client.schemaService.writeSchema(writeRequest);
    }
}

class TestTuples {
    public SubjectReference emilia;
    public SubjectReference beatrice;
    public ObjectReference postOne;
    public ObjectReference postTwo;

    public TestTuples(SubjectReference one, SubjectReference two, ObjectReference three, ObjectReference four) {
        emilia = one;
        beatrice = two;
        postOne = three;
        postTwo = four;
    }
}
