import static com.authzed.api.v1.CheckDebugTrace.Permissionship.PERMISSIONSHIP_HAS_PERMISSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.authzed.api.v1.*;
import com.authzed.grpcutil.BearerToken;

import org.junit.Test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class V1ClientTest {
	private static final String target = "localhost:50051";
	private static final String tokenPrefix = "tc_test_token";

	// Write schema
	private static final String schema = "definition test/article {\n" +
			"  relation author: test/user\n" +
			"  relation commenter: test/user\n" +
			"  permission can_comment = commenter + author\n" +
			"}\n" +
			"definition test/user {}";

	public static String generateToken() {
		Random random = new Random();
		return tokenPrefix + random.nextInt(1000);
	}

	@Test
	public void testSchemaService() {
		// Initialize services
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
		String token = generateToken();
		SchemaServiceGrpc.SchemaServiceBlockingStub schemaService  = writeTestSchema(token, channel);

		// Read schema
		ReadSchemaRequest readRequest = ReadSchemaRequest.newBuilder().build();
		ReadSchemaResponse readResponse = schemaService.readSchema(readRequest);
		assertTrue(readResponse.getSchemaText().indexOf("test/article") > 0);
	}

	// For an example with flow control, see
	// https://github.com/grpc/grpc-java/blob/9071c1ad7c842f4e73b6ae95b71f11c517b177a4/examples/src/main/java/io/grpc/examples/manualflowcontrol/ManualFlowControlClient.java
	@Test
	public void testCheckPermission() {
		// Initialize services
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
		String token = generateToken();

		PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService = PermissionsServiceGrpc
				.newBlockingStub(channel)
				.withCallCredentials(new BearerToken(token));

		writeTestSchema(token, channel);

		// Write relationship
		String tokenVal = writeRelationship(permissionsService,
				"test/article", "java_test", "author", "test/user", "george");
		assertNotNull(tokenVal);

		// Check permission
		ZedToken zedToken = ZedToken.newBuilder()
				.setToken(tokenVal)
				.build();
		CheckPermissionRequest checkRequest = CheckPermissionRequest.newBuilder()
				.setConsistency(
						Consistency.newBuilder()
								.setAtLeastAsFresh(zedToken)
								.build())
				.setResource(
						ObjectReference.newBuilder()
								.setObjectType("test/article")
								.setObjectId("java_test")
								.build())
				.setSubject(
						SubjectReference.newBuilder()
								.setObject(
										ObjectReference.newBuilder()
												.setObjectType("test/user")
												.setObjectId("george")
												.build())
								.build())
				.setPermission("can_comment")
				.build();

		CheckPermissionResponse checkResponse = permissionsService.checkPermission(checkRequest);
		assertEquals(CheckPermissionResponse.Permissionship.PERMISSIONSHIP_HAS_PERMISSION, checkResponse.getPermissionship());
	}

	@Test
	public void testLookupResources() {
		// Initialize services
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
		String token = generateToken();
		PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService = PermissionsServiceGrpc
				.newBlockingStub(channel)
				.withCallCredentials(new BearerToken(token));

		writeTestSchema(token, channel);

		// Write relationship
		writeRelationship(permissionsService,
				"test/article", "java_test", "author", "test/user", "george");
		String tokenVal = writeRelationship(permissionsService,
				"test/article", "go_test", "author", "test/user", "george");

		// lookup resources
		ZedToken zedToken = ZedToken.newBuilder()
				.setToken(tokenVal)
				.build();
		LookupResourcesRequest lookupResourcesRequest = LookupResourcesRequest.newBuilder()
				.setConsistency(
						Consistency.newBuilder()
								.setAtLeastAsFresh(zedToken)
								.build())
				.setResourceObjectType("test/article")
				.setSubject(
						SubjectReference.newBuilder()
								.setObject(
										ObjectReference.newBuilder()
												.setObjectType("test/user")
												.setObjectId("george")
												.build())
								.build())
				.setPermission("can_comment")
				.build();

		Iterator<LookupResourcesResponse> resp = permissionsService.lookupResources(lookupResourcesRequest);
		Set<String> resources = new HashSet<>();
		resp.forEachRemaining(lookupResourcesResponse -> {
			resources.add(lookupResourcesResponse.getResourceObjectId());
		});

		assertTrue(resources.contains("java_test"));
		assertTrue(resources.contains("go_test"));
	}

	private static String writeRelationship(PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService,
											String resourceType, String resourceID, String relation, String subjectType,
											String subjectID) {
		WriteRelationshipsRequest relRequest = WriteRelationshipsRequest
				.newBuilder()
				.addUpdates(
						RelationshipUpdate.newBuilder()
								.setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
								.setRelationship(
										Relationship.newBuilder()
												.setResource(
														ObjectReference.newBuilder()
																.setObjectType(resourceType)
																.setObjectId(resourceID)
																.build())
												.setRelation(relation)
												.setSubject(
														SubjectReference.newBuilder()
																.setObject(
																		ObjectReference.newBuilder()
																				.setObjectType(subjectType)
																				.setObjectId(subjectID)
																				.build())
																.build())
												.build())
								.build())
				.build();

		WriteRelationshipsResponse relResponse = permissionsService.writeRelationships(relRequest);
		return relResponse.getWrittenAt().getToken();
	}

	private static SchemaServiceGrpc.SchemaServiceBlockingStub writeTestSchema(String token, ManagedChannel channel) {
		SchemaServiceGrpc.SchemaServiceBlockingStub schemaService = SchemaServiceGrpc.newBlockingStub(channel)
				.withCallCredentials(new BearerToken(token));
		WriteSchemaRequest writeRequest = WriteSchemaRequest
				.newBuilder()
				.setSchema(schema)
				.build();
		schemaService.writeSchema(writeRequest);

		return schemaService;
	}
}
