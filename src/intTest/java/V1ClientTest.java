import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import com.authzed.grpcutil.BearerToken;

import org.junit.Test;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.SchemaServiceGrpc;
import com.authzed.api.v1.Core.ObjectReference;
import com.authzed.api.v1.Core.Relationship;
import com.authzed.api.v1.Core.RelationshipUpdate;
import com.authzed.api.v1.Core.SubjectReference;
import com.authzed.api.v1.Core.ZedToken;
import com.authzed.api.v1.PermissionService;
import com.authzed.api.v1.PermissionService.CheckPermissionRequest;
import com.authzed.api.v1.PermissionService.CheckPermissionResponse;
import com.authzed.api.v1.PermissionService.CheckPermissionResponse.Permissionship;
import com.authzed.api.v1.SchemaServiceGrpc.SchemaServiceBlockingStub;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest;
import com.authzed.api.v1.PermissionService.Consistency;
import com.authzed.api.v1.PermissionService.WriteRelationshipsRequest;
import com.authzed.api.v1.PermissionService.WriteRelationshipsResponse;

public class V1ClientTest {
	private static final String target = "localhost:50051";
	private static final String tokenPrefix = "tc_test_token";

	public static String generateToken() {
		Random random = new Random();
		return tokenPrefix + random.nextInt(1000);
	}

	@Test
	public void testV1Api() {
		// Initialize services
		ManagedChannel channel = ManagedChannelBuilder
				.forTarget(target)
				.usePlaintext()
				.build();
		String token = generateToken();
		BearerToken bearerToken = new BearerToken(token);
		SchemaServiceGrpc.SchemaServiceBlockingStub schemaService = SchemaServiceGrpc.newBlockingStub(channel)
				.withCallCredentials(bearerToken);
		PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService = PermissionsServiceGrpc
				.newBlockingStub(channel)
				.withCallCredentials(bearerToken);

		// Write schema
		String schema = "definition test/article {\n" +
				"  relation author: test/user\n" +
				"  relation commenter: test/user\n" +
				"  permission can_comment = commenter + author\n" +
				"}\n" +
				"definition test/user {}";

		WriteSchemaRequest writeRequest = WriteSchemaRequest
				.newBuilder()
				.setSchema(schema)
				.build();
		schemaService.writeSchema(writeRequest);

		// Read schema
		ReadSchemaRequest readRequest = ReadSchemaRequest
				.newBuilder()
				.build();

		ReadSchemaResponse readResponse = schemaService.readSchema(readRequest);
		assertTrue(readResponse.getSchemaText().indexOf("test/article") > 0);

		// Write relationship
		WriteRelationshipsRequest relRequest = PermissionService.WriteRelationshipsRequest
				.newBuilder()
				.addUpdates(
						RelationshipUpdate.newBuilder()
								.setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
								.setRelationship(
										Relationship.newBuilder()
												.setResource(
														ObjectReference.newBuilder()
																.setObjectType("test/article")
																.setObjectId("java_test")
																.build())
												.setRelation("author")
												.setSubject(
														SubjectReference.newBuilder()
																.setObject(
																		ObjectReference.newBuilder()
																				.setObjectType("test/user")
																				.setObjectId("george")
																				.build())
																.build())
												.build())
								.build())
				.build();

		WriteRelationshipsResponse relResponse = permissionsService.writeRelationships(relRequest);
		String tokenVal = relResponse.getWrittenAt().getToken();
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
		assertEquals(Permissionship.PERMISSIONSHIP_HAS_PERMISSION, checkResponse.getPermissionship());
	}
}
