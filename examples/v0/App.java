/*
 * Authzed API examples
 */
package v0;

import com.authzed.grpcutil.BearerToken;
import com.authzed.api.v0.ACLServiceGrpc;
import com.authzed.api.v0.AclService;
import com.authzed.api.v0.Core;
import io.grpc.*;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final String target = "grpc.authzed.com:443";
    private static final String token = "tc_test_def_token";

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
            client.relationship();
            client.check();
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // Uh oh!
            }
        }
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
                    .withCallCredentials(new BearerToken(token))
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
                    .withCallCredentials(new BearerToken(token))
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
