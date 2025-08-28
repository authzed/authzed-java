/*
 * Authzed API examples
 */
package v1;

import com.authzed.api.v1.*;
import com.authzed.grpcutil.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;

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
        WatchServiceGrpc.WatchServiceBlockingStub watchClient = WatchServiceGrpc
                .newBlockingStub(channel)
                .withCallCredentials(bearerToken);
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(target)
                .useTransportSecurity() // if not using TLS, replace with .usePlaintext()
                .build();

        ZedToken lastZedToken = ZedToken.newBuilder().setToken("").build();

        while(true) {
            try {
                WatchRequest.Builder builder = WatchRequest.newBuilder()
                        .addOptionalUpdateKinds(com.authzed.api.v1.WatchKind.WATCH_KIND_INCLUDE_CHECKPOINTS);

                if (!lastZedToken.getToken().isEmpty()) {
                    System.out.println("Resuming watch from token: " + lastZedToken.getToken());
                    builder.setOptionalStartCursor(lastZedToken);
                }

                WatchRequest request = builder.build();

                Iterator<WatchResponse> watchStream = watchClient.watch(request);

                while (watchStream.hasNext()) {
                    WatchResponse msg = watchStream.next();

                    if (msg.getUpdatesCount() > 0) {
                        for (var update : msg.getUpdatesList()) {
                            System.out.println("Received update: " + update);
                        }
                    } else {
                        System.out.println("No changes made in SpiceDB");
                    }

                    if (!msg.getChangesThrough().getToken().isEmpty()) {
                        lastZedToken = msg.getChangesThrough();
                    }
                }

            } catch (Exception e) {
                if (e instanceof StatusRuntimeException sre && (sre.getStatus().getCode().equals(Status.UNAVAILABLE.getCode()) ||
                        (sre.getStatus().getCode().equals(Status.INTERNAL.getCode())) && sre.getMessage().contains("stream timeout"))) {
                    // Probably a server restart. Retry.
                } else {
                    System.out.println("Error calling watch: " + e.getMessage());
                    return;
                }
            }
        }
    }
}
