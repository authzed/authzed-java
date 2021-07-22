/*
 * Authzed API examples
 */
package demo;

import com.authzed.grpcutil.ClientToken;
import com.authzed.api.v0.ACLServiceGrpc;
import com.authzed.api.v0.AclService;
import com.authzed.api.v0.Core;
import com.authzed.api.v1alpha1.Schema;
import com.authzed.api.v1alpha1.SchemaServiceGrpc;
import io.grpc.*;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

// Installation
// https://search.maven.org/artifact/com.authzed.api/authzed

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final String target = "grpc.authzed.com:443";
    private static final String token = "tc_test_def_token";

    private final SchemaServiceGrpc.SchemaServiceBlockingStub blockingStub;
    private final ACLServiceGrpc.ACLServiceBlockingStub v0blockingStub;

    public App(Channel channel) {
        blockingStub = SchemaServiceGrpc.newBlockingStub(channel);
        v0blockingStub = ACLServiceGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(target)
                .useTransportSecurity()
                .build();
        try {
            App client = new App(channel);
//            client.write();
//            client.read();
//            client.relationship();
            client.check();
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // Uh oh!
            }
        }
    }

    public String read() {
        logger.info("Reading schema...");
        Schema.ReadSchemaRequest request = Schema.ReadSchemaRequest
                .newBuilder()
                .addObjectDefinitionsNames("thelargeapp/article")
                .build();
        Schema.ReadSchemaResponse response;
        try {
            response = blockingStub
                    .withCallCredentials(new ClientToken(token))
                    .readSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Greeting: " + response.toString());
        return response.toString();
    }

    public String write() {
        logger.info("Writing schema...");
        String schema = """
                definition thelargeapp/article {
                	relation author: thelargeapp/user
                	relation commenter: thelargeapp/user
                	
                	permission can_comment = commenter + author
                }
                                
                definition thelargeapp/user {}
                """;
        Schema.WriteSchemaRequest request = Schema.WriteSchemaRequest
                .newBuilder()
                .setSchema(schema)
                .build();
        Schema.WriteSchemaResponse response;
        try {
            response = blockingStub
                    .withCallCredentials(new ClientToken(token))
                    .writeSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.toString();
    }

    public String relationship() {
        logger.info("Write relationship...");
        AclService.WriteRequest request = AclService.WriteRequest
                .newBuilder()
                .addUpdates(
                        Core.RelationTupleUpdate
                                .newBuilder()
                                .setOperationValue(Core.RelationTupleUpdate.Operation.CREATE_VALUE)
                                .setTuple(
                                        Core.RelationTuple
                                                .newBuilder()
                                                .setUser(createUser("thelargeapp/user", "emilia", "..."))
                                                .setObjectAndRelation(createONR("thelargeapp/article", "java_test", "author"))
                                )
                                .build())
                .build();

        AclService.WriteResponse response;
        try {
            response = v0blockingStub
                    .withCallCredentials(new ClientToken(token))
                    .write(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.toString();
    }

    public String check() {
        logger.info("Checking...");
        Core.User emilia = createUser("thelargeapp/user", "emilia", "...");
        Core.ObjectAndRelation reader = createONR("thelargeapp/article", "java_test", "can_comment");
        AclService.CheckRequest request = AclService.CheckRequest
                .newBuilder()
                .setUser(emilia)
                .setTestUserset(reader)
                .build();
        AclService.CheckResponse response;
        try {
            response = v0blockingStub
                    .withCallCredentials(new ClientToken(token))
                    .check(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.toString();
    }

    private Core.ObjectAndRelation createONR(String namespace, String objId, String relation) {
        return Core.ObjectAndRelation
                .newBuilder()
                .setNamespace(namespace)
                .setObjectId(objId)
                .setRelation(relation)
                .build();
    }

    private Core.User createUser(String namespace, String objId, String relation) {
        return Core.User
                .newBuilder()
                .setUserset(
                        Core.ObjectAndRelation
                                .newBuilder()
                                .setNamespace(namespace)
                                .setObjectId(objId)
                                .setRelation(relation)
                                .build()
                )
                .build();
    }
}
