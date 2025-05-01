/*
 * Authzed API examples
 */
package v1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.authzed.api.v1.CheckPermissionRequest;
import com.authzed.api.v1.CheckPermissionResponse;
import com.authzed.api.v1.CheckPermissionResponse.Permissionship;
import com.authzed.api.v1.Consistency;
import com.authzed.api.v1.ObjectReference;
import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.ReadSchemaRequest;
import com.authzed.api.v1.ReadSchemaResponse;
import com.authzed.api.v1.Relationship;
import com.authzed.api.v1.RelationshipUpdate;
import com.authzed.api.v1.SchemaServiceGrpc;
import com.authzed.api.v1.SubjectReference;
import com.authzed.api.v1.WriteRelationshipsRequest;
import com.authzed.api.v1.WriteRelationshipsResponse;
import com.authzed.api.v1.WriteSchemaRequest;
import com.authzed.api.v1.WriteSchemaResponse;
import com.authzed.api.v1.ZedToken;
import com.authzed.grpcutil.BearerToken;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

// Installation
// https://search.maven.org/artifact/com.authzed.api/authzed

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final String target = "grpc.authzed.com:443";
    private static final String token = "tc_test_def_token";

    private final SchemaServiceGrpc.SchemaServiceBlockingStub schemaService;
    private final PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService;

    public App(Channel channel) {
        BearerToken bearerToken = new BearerToken(token);
        schemaService = SchemaServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(bearerToken);
        permissionsService = PermissionsServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(new BearerToken(token));
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(target)
                .useTransportSecurity() // if not using TLS, replace with .usePlaintext()
                .build();
        try {
            App client = new App(channel);

            client.writeSchema();

            client.readSchema();

            String tokenVal = client.writeRelationship();

            Permissionship result = client.check(
                    ZedToken.newBuilder()
                            .setToken(tokenVal)
                            .build());
            logger.log(Level.INFO, "Check result: {0}", result);
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // Uh oh!
            }
        }
    }

    public String writeSchema() {
        logger.info("Writing schema...");
        String schema = """
                definition thelargeapp/article {
                	relation author: thelargeapp/user
                	relation commenter: thelargeapp/user

                	permission can_comment = commenter + author
                }

                definition thelargeapp/user {}
                """;

        WriteSchemaRequest request = WriteSchemaRequest
                .newBuilder()
                .setSchema(schema)
                .build();

        WriteSchemaResponse response;
        try {
            response = schemaService.writeSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.toString();
    }

    public String readSchema() {
        logger.info("Reading schema...");
        ReadSchemaRequest request = ReadSchemaRequest
                .newBuilder()
                .build();

        ReadSchemaResponse response;
        try {
            response = schemaService.readSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info(response.toString());
        return response.toString();
    }

    public String writeRelationship() {
        logger.info("Write relationship...");

        WriteRelationshipsRequest request = WriteRelationshipsRequest.newBuilder()
                .addUpdates(
                        RelationshipUpdate.newBuilder()
                                .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                                .setRelationship(
                                        Relationship.newBuilder()
                                                .setResource(
                                                        ObjectReference.newBuilder()
                                                                .setObjectType("thelargeapp/article")
                                                                .setObjectId("java_test")
                                                                .build())
                                                .setRelation("author")
                                                .setSubject(
                                                        SubjectReference.newBuilder()
                                                                .setObject(
                                                                        ObjectReference.newBuilder()
                                                                                .setObjectType("thelargeapp/user")
                                                                                .setObjectId("george")
                                                                                .build())
                                                                .build())
                                                .build())
                                .build())
                .build();

        WriteRelationshipsResponse response;
        try {
            response = permissionsService.writeRelationships(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.getWrittenAt().getToken();
    }

    public Permissionship check(ZedToken zedToken) {
        logger.info("Checking...");

        CheckPermissionRequest request = CheckPermissionRequest.newBuilder()
                .setConsistency(
                        Consistency.newBuilder()
                                .setAtLeastAsFresh(zedToken)
                                .build())
                .setResource(
                        ObjectReference.newBuilder()
                                .setObjectType("thelargeapp/article")
                                .setObjectId("java_test")
                                .build())
                .setSubject(
                        SubjectReference.newBuilder()
                                .setObject(
                                        ObjectReference.newBuilder()
                                                .setObjectType("thelargeapp/user")
                                                .setObjectId("george")
                                                .build())
                                .build())
                .setPermission("can_comment")
                .build();

        CheckPermissionResponse response;
        try {
            response = permissionsService.checkPermission(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return null;
        }
        logger.info("Response: " + response.toString());
        return response.getPermissionship();
    }
}
