import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import com.authzed.api.v1.*;

import io.grpc.stub.StreamObserver;
import jdk.dynalink.linker.support.Lookup;
import org.junit.Test;

import javax.security.auth.Subject;

import static org.assertj.core.api.Assertions.assertThat;

/*
NOTE: this file has some un-ergonomic code because we test against Java 8
and therefore need to conform to Java 8 syntax. When we get to where we can
drop support, we can update this code.
 */
public class V1ClientTest {
    private static final Consistency fullyConsistent = Consistency.newBuilder().setFullyConsistent(true).build();

    @Test
    public void testBasicSchema() {
        // Initialize services
        TestClient client = new TestClient();
        String schema = "definition document {\n"
                + "relation reader: user\n"
                + "}\n"
                + "definition user {}";
        // Write schema
        writeSchema(client, schema);

        // Read schema
        ReadSchemaRequest readRequest = ReadSchemaRequest.newBuilder().build();
        ReadSchemaResponse readResponse = client.schemaService.readSchema(readRequest);
        assertThat(readResponse.getSchemaText()).contains("definition document");
        assertThat(readResponse.getSchemaText()).contains("definition user");
    }

    @Test
    public void testSchemaWithCaveats() {
        TestClient client = new TestClient();
        writeTestSchema(client);
    }

    // For an example with flow control, see
    // https://github.com/grpc/grpc-java/blob/9071c1ad7c842f4e73b6ae95b71f11c517b177a4/examples/src/main/java/io/grpc/examples/manualflowcontrol/ManualFlowControlClient.java
    @Test
    public void testCheck() {
        TestClient client = new TestClient();
        writeTestSchema(client);
        TestTuples testTuples = writeTestTuples(client);

        CheckPermissionResponse firstResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.emilia)
                .setPermission("view")
                .build());
        assertThat(firstResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        CheckPermissionResponse secondResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.emilia)
                .setPermission("write")
                .build());
        assertThat(secondResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        CheckPermissionResponse thirdResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view")
                .build());
        assertThat(thirdResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        CheckPermissionResponse fourthResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("write")
                .build());
        assertThat(fourthResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_NO_PERMISSION);
    }

    @Test
    public void testCaveatedCheck() {
        TestClient client = new TestClient();
        writeTestSchema(client);
        TestTuples testTuples = writeTestTuples(client);

        // Likes Harry Potter
        Struct likesContext = Struct.newBuilder().putFields("likes", Value.newBuilder().setBoolValue(true).build()).build();
        CheckPermissionResponse firstResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view_as_fan")
                .setContext(likesContext)
                .build());
        assertThat(firstResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);

        // No longer likes Harry Potter
        Struct dislikesContext = Struct.newBuilder().putFields("likes", Value.newBuilder().setBoolValue(false).build()).build();
        CheckPermissionResponse secondResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResource(testTuples.postOne)
                .setSubject(testTuples.beatrice)
                .setPermission("view_as_fan")
                .setContext(dislikesContext)
                .build());
        assertThat(secondResponse.getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_NO_PERMISSION);

        // No longer likes Harry Potter
        CheckPermissionResponse thirdResponse = client.permissionsService.checkPermission(CheckPermissionRequest.newBuilder()
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
        TestClient client = new TestClient();
        writeTestSchema(client);
        TestTuples testTuples = writeTestTuples(client);

        LookupResourcesRequest lookupResourcesRequest = LookupResourcesRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setResourceObjectType("post")
                .setSubject(testTuples.emilia)
                .setPermission("write")
                .build();

        Iterator<LookupResourcesResponse> resp = client.permissionsService.lookupResources(lookupResourcesRequest);
        HashSet<String> resources = new HashSet<String>();
        resp.forEachRemaining(lookupResourcesResponse -> resources.add(lookupResourcesResponse.getResourceObjectId()));

        assertThat(resources).contains(testTuples.postOne.getObjectId());
        assertThat(resources).contains(testTuples.postTwo.getObjectId());
        assertThat(resources).hasSize(2);
    }

    @Test
    public void testLookupSubjects() {
        TestClient client = new TestClient();
        writeTestSchema(client);
        TestTuples testTuples = writeTestTuples(client);

        LookupSubjectsRequest lookupSubjectsRequest = LookupSubjectsRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .setSubjectObjectType("user")
                .setResource(testTuples.postOne)
                .setPermission("view")
                .build();

        Iterator<LookupSubjectsResponse> resp = client.permissionsService.lookupSubjects(lookupSubjectsRequest);
        HashSet<String> users = new HashSet<String>();
        resp.forEachRemaining(response ->
            users.add(response.getSubject().getSubjectObjectId()));

        assertThat(users).contains(testTuples.emilia.getObject().getObjectId());
        assertThat(users).contains(testTuples.beatrice.getObject().getObjectId());
        assertThat(users).hasSize(2);
    }

    @Test
    public void testCheckBulkPermissions() {
        TestClient client = new TestClient();
        writeTestSchema(client);
        TestTuples testTuples = writeTestTuples(client);

        CheckBulkPermissionsRequest checkBulkPermissionsRequest = CheckBulkPermissionsRequest.newBuilder()
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

        CheckBulkPermissionsResponse response = client.permissionsService.checkBulkPermissions(checkBulkPermissionsRequest);
        assertThat(response.getPairsList()).hasSize(2);
        assertThat(response.getPairs(0).getItem().getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);
        assertThat(response.getPairs(1).getItem().getPermissionship()).isEqualTo(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION);
    }

    @Test
    public void testBulkImport() throws InterruptedException {
        TestClient client = new TestClient();
        writeTestSchema(client);
        writeTestTuples(client);

        // Validate export
        Iterator<ExportBulkRelationshipsResponse> exportCall = client.permissionsService.exportBulkRelationships(ExportBulkRelationshipsRequest.newBuilder()
                        .setConsistency(fullyConsistent)
                .build());

        HashSet<Relationship> relations = new HashSet<Relationship>();
        exportCall.forEachRemaining(response ->
            relations.addAll(response.getRelationshipsList()));

        assertThat(relations).hasSize(4);

        // Note that this has a different preshared key
        // Validate import
        TestClient emptyClient = new TestClient();
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
        ImportBulkObserver importObserver = new ImportBulkObserver();
        StreamObserver<ImportBulkRelationshipsRequest> wrappedObserver = client.asyncPermissionsService.importBulkRelationships(importObserver);
        wrappedObserver.onNext(ImportBulkRelationshipsRequest.newBuilder()
                .addAllRelationships(relations).build());
        wrappedObserver.onCompleted();

        done.await();

        // Validate that everything was loaded
        Iterator<ExportBulkRelationshipsResponse> postImportExportCall = client.permissionsService.exportBulkRelationships(ExportBulkRelationshipsRequest.newBuilder()
                .setConsistency(fullyConsistent)
                .build());

        HashSet<Relationship> importedRelations = new HashSet<Relationship>();
        postImportExportCall.forEachRemaining(response ->
            importedRelations.addAll(response.getRelationshipsList()));

        assertThat(importedRelations).hasSize(4);
    }




    private TestTuples writeTestTuples(TestClient client) {
        SubjectReference emilia = SubjectReference.newBuilder().setObject(ObjectReference.newBuilder().setObjectId("emilia").setObjectType("user").build()).build();
        SubjectReference beatrice = SubjectReference.newBuilder().setObject(ObjectReference.newBuilder().setObjectId("beatrice").setObjectType("user").build()).build();
        ObjectReference postOne = ObjectReference.newBuilder().setObjectId("post-one").setObjectType("post").build();
        ObjectReference postTwo = ObjectReference.newBuilder().setObjectId("post-two").setObjectType("post").build();
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
        String schema = "caveat likes_harry_potter(likes bool) {\n"
                + "likes == true\n"
                + "}\n"
                + "definition post {\n"
                + "relation writer: user\n"
                + "relation reader: user\n"
                + "relation caveated_reader: user with likes_harry_potter\n"
                + "permission write = writer\n"
                + "permission view = reader + writer\n"
                + "permission view_as_fan = caveated_reader + writer\n"
                + "}\n"
                + "definition user {}";
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
