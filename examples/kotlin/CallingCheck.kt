/*
 * Authzed API examples - Kotlin
 * 
 * This example demonstrates how to use the Authzed Java client library from Kotlin.
 * It shows the more idiomatic Kotlin syntax while using the same Java client library.
 */

import com.authzed.api.v1.*
import com.authzed.grpcutil.BearerToken
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import java.util.logging.Logger

// Installation
// Add to your build.gradle.kts:
// dependencies {
//     implementation("com.authzed.api:authzed:1.5.4")
//     implementation("io.grpc:grpc-api:1.75.0")
//     implementation("io.grpc:grpc-stub:1.75.0")
//     implementation("io.grpc:grpc-netty-shaded:1.75.0")
// }

class AuthzedClient(channel: ManagedChannel, token: String) {
    private val logger = Logger.getLogger(AuthzedClient::class.java.name)
    private val bearerToken = BearerToken(token)
    
    private val schemaService: SchemaServiceGrpc.SchemaServiceBlockingStub =
        SchemaServiceGrpc.newBlockingStub(channel)
            .withCallCredentials(bearerToken)
    
    private val permissionsService: PermissionsServiceGrpc.PermissionsServiceBlockingStub =
        PermissionsServiceGrpc.newBlockingStub(channel)
            .withCallCredentials(bearerToken)
    
    fun writeSchema(): String {
        logger.info("Writing schema...")
        
        val schema = """
            definition thelargeapp/article {
                relation author: thelargeapp/user
                relation commenter: thelargeapp/user
                
                permission can_comment = commenter + author
            }
            
            definition thelargeapp/user {}
        """.trimIndent()
        
        val request = WriteSchemaRequest.newBuilder()
            .setSchema(schema)
            .build()
        
        return try {
            val response = schemaService.writeSchema(request)
            logger.info("Response: $response")
            response.toString()
        } catch (e: Exception) {
            logger.log(Level.WARNING, "RPC failed: ${e.message}")
            ""
        }
    }
    
    fun readSchema(): String {
        logger.info("Reading schema...")
        
        val request = ReadSchemaRequest.newBuilder().build()
        
        return try {
            val response = schemaService.readSchema(request)
            logger.info(response.toString())
            response.toString()
        } catch (e: Exception) {
            logger.log(Level.WARNING, "RPC failed: ${e.message}")
            ""
        }
    }
    
    fun writeRelationship(): String {
        logger.info("Write relationship...")
        
        val request = WriteRelationshipsRequest.newBuilder()
            .addUpdates(
                RelationshipUpdate.newBuilder()
                    .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
                    .setRelationship(
                        Relationship.newBuilder()
                            .setResource(
                                ObjectReference.newBuilder()
                                    .setObjectType("thelargeapp/article")
                                    .setObjectId("kotlin_test")
                                    .build()
                            )
                            .setRelation("author")
                            .setSubject(
                                SubjectReference.newBuilder()
                                    .setObject(
                                        ObjectReference.newBuilder()
                                            .setObjectType("thelargeapp/user")
                                            .setObjectId("george")
                                            .build()
                                    )
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build()
        
        return try {
            val response = permissionsService.writeRelationships(request)
            logger.info("Response: $response")
            response.writtenAt.token
        } catch (e: Exception) {
            logger.log(Level.WARNING, "RPC failed: ${e.message}")
            ""
        }
    }
    
    fun check(zedToken: ZedToken): CheckPermissionResponse.Permissionship? {
        logger.info("Checking...")
        
        val request = CheckPermissionRequest.newBuilder()
            .setConsistency(
                Consistency.newBuilder()
                    .setAtLeastAsFresh(zedToken)
                    .build()
            )
            .setResource(
                ObjectReference.newBuilder()
                    .setObjectType("thelargeapp/article")
                    .setObjectId("kotlin_test")
                    .build()
            )
            .setSubject(
                SubjectReference.newBuilder()
                    .setObject(
                        ObjectReference.newBuilder()
                            .setObjectType("thelargeapp/user")
                            .setObjectId("george")
                            .build()
                    )
                    .build()
            )
            .setPermission("can_comment")
            .build()
        
        return try {
            val response = permissionsService.checkPermission(request)
            logger.info("Response: $response")
            response.permissionship
        } catch (e: Exception) {
            logger.log(Level.WARNING, "RPC failed: ${e.message}")
            null
        }
    }
}

fun main() {
    val target = "grpc.authzed.com:443"
    val token = "tc_test_def_token"
    
    val channel = ManagedChannelBuilder
        .forTarget(target)
        .useTransportSecurity() // for local development without TLS, use .usePlaintext()
        .build()
    
    try {
        val client = AuthzedClient(channel, token)
        
        client.writeSchema()
        client.readSchema()
        
        val tokenVal = client.writeRelationship()
        
        val result = client.check(
            ZedToken.newBuilder()
                .setToken(tokenVal)
                .build()
        )
        
        println("Check result: $result")
    } finally {
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS)
    }
}
