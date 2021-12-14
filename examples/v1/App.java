/*
 * Authzed API examples
 */
package v1;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.authzed.api.v1.Core;
import com.authzed.api.v1.Core.ObjectReference;
import com.authzed.api.v1.Core.Relationship;
import com.authzed.api.v1.Core.SubjectReference;
import com.authzed.api.v1.Core.ZedToken;
import com.authzed.api.v1.PermissionService;
import com.authzed.api.v1.PermissionService.CheckPermissionRequest;
import com.authzed.api.v1.PermissionService.Consistency;
import com.authzed.api.v1.PermissionService.CheckPermissionResponse.Permissionship;
import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.SchemaServiceGrpc;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse;
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
                .useTransportSecurity()
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

        PermissionService.WriteRelationshipsRequest request = PermissionService.WriteRelationshipsRequest.newBuilder()
                .addUpdates(
                        com.authzed.api.v1.Core.RelationshipUpdate.newBuilder()
                                .setOperation(Core.RelationshipUpdate.Operation.OPERATION_CREATE)
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

        PermissionService.WriteRelationshipsResponse response;
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

        PermissionService.CheckPermissionRequest request = CheckPermissionRequest.newBuilder()
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

        PermissionService.CheckPermissionResponse response;
        try {
            response = permissionsService.checkPermission(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.getPermissionship();
    }
}