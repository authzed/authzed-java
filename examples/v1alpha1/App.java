/*
 * Authzed API examples
 */
package v1alpha1;

import com.authzed.grpcutil.BearerToken;
import com.authzed.api.v1alpha1.Schema;
import com.authzed.api.v1alpha1.SchemaServiceGrpc;
import io.grpc.*;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final String target = "grpc.authzed.com:443";
    private static final String token = "tc_test_def_token";

    private final SchemaServiceGrpc.SchemaServiceBlockingStub blockingStub;

    public App(Channel channel) {
        blockingStub = SchemaServiceGrpc.newBlockingStub(channel)
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
        } finally {
            try {
                channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // Uh oh!
            }
        }
    }

    public String readSchema() {
        logger.info("Reading schema...");
        Schema.ReadSchemaRequest request = Schema.ReadSchemaRequest
                .newBuilder()
                .addObjectDefinitionsNames("thelargeapp/article")
                .build();
        Schema.ReadSchemaResponse response;
        try {
            response = blockingStub.readSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Greeting: " + response.toString());
        return response.toString();
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
        Schema.WriteSchemaRequest request = Schema.WriteSchemaRequest
                .newBuilder()
                .setSchema(schema)
                .build();
        Schema.WriteSchemaResponse response;
        try {
            response = blockingStub.writeSchema(request);
        } catch (Exception e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
            return "";
        }
        logger.info("Response: " + response.toString());
        return response.toString();
    }
}
