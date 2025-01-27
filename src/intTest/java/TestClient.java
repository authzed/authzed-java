import com.authzed.api.v1.ExperimentalServiceGrpc;
import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.api.v1.SchemaServiceGrpc;
import com.authzed.grpcutil.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Random;

// TestClient
public class TestClient {
    private static final String tokenPrefix = "tc_test_token";

    public SchemaServiceGrpc.SchemaServiceBlockingStub schemaService;
    public PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService;
    public PermissionsServiceGrpc.PermissionsServiceStub asyncPermissionsService;
    public ExperimentalServiceGrpc.ExperimentalServiceBlockingStub experimentalService;
    public TestClient() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50051").usePlaintext().build();
        String token = generateToken();
        schemaService = SchemaServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(new BearerToken(token));
        permissionsService = PermissionsServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(new BearerToken(token));
        asyncPermissionsService = PermissionsServiceGrpc.newStub(channel)
                .withCallCredentials(new BearerToken(token));
        experimentalService = ExperimentalServiceGrpc.newBlockingStub(channel)
                .withCallCredentials(new BearerToken(token));
    }
    public String generateToken() {
        Random random = new Random();
        return tokenPrefix + random.nextInt(1000);
    }
}
