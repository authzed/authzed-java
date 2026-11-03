/*
 * Authzed API examples - Scala
 * 
 * This example demonstrates how to use the Authzed Java client library from Scala.
 * It shows the more idiomatic Scala syntax while using the same Java client library.
 */

import com.authzed.api.v1._
import com.authzed.grpcutil.BearerToken
import io.grpc.{ManagedChannel, ManagedChannelBuilder}
import java.util.concurrent.TimeUnit
import java.util.logging.{Level, Logger}
import scala.util.Try

// Installation
// Add to your build.sbt:
// libraryDependencies ++= Seq(
//   "com.authzed.api" % "authzed" % "1.5.4",
//   "io.grpc" % "grpc-api" % "1.75.0",
//   "io.grpc" % "grpc-stub" % "1.75.0",
//   "io.grpc" % "grpc-netty-shaded" % "1.75.0"
// )

class AuthzedClient(channel: ManagedChannel, token: String) {
  private val logger = Logger.getLogger(classOf[AuthzedClient].getName)
  private val bearerToken = new BearerToken(token)
  
  private val schemaService: SchemaServiceGrpc.SchemaServiceBlockingStub =
    SchemaServiceGrpc.newBlockingStub(channel)
      .withCallCredentials(bearerToken)
  
  private val permissionsService: PermissionsServiceGrpc.PermissionsServiceBlockingStub =
    PermissionsServiceGrpc.newBlockingStub(channel)
      .withCallCredentials(bearerToken)
  
  def writeSchema(): String = {
    logger.info("Writing schema...")
    
    val schema =
      """definition thelargeapp/article {
        |  relation author: thelargeapp/user
        |  relation commenter: thelargeapp/user
        |  
        |  permission can_comment = commenter + author
        |}
        |
        |definition thelargeapp/user {}
        |""".stripMargin
    
    val request = WriteSchemaRequest.newBuilder()
      .setSchema(schema)
      .build()
    
    Try {
      val response = schemaService.writeSchema(request)
      logger.info(s"Response: $response")
      response.toString
    }.recover {
      case e: Exception =>
        logger.log(Level.WARNING, s"RPC failed: ${e.getMessage}")
        ""
    }.get
  }
  
  def readSchema(): String = {
    logger.info("Reading schema...")
    
    val request = ReadSchemaRequest.newBuilder().build()
    
    Try {
      val response = schemaService.readSchema(request)
      logger.info(response.toString)
      response.toString
    }.recover {
      case e: Exception =>
        logger.log(Level.WARNING, s"RPC failed: ${e.getMessage}")
        ""
    }.get
  }
  
  def writeRelationship(): String = {
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
                  .setObjectId("scala_test")
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
    
    Try {
      val response = permissionsService.writeRelationships(request)
      logger.info(s"Response: $response")
      response.getWrittenAt.getToken
    }.recover {
      case e: Exception =>
        logger.log(Level.WARNING, s"RPC failed: ${e.getMessage}")
        ""
    }.get
  }
  
  def check(zedToken: ZedToken): Option[CheckPermissionResponse.Permissionship] = {
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
          .setObjectId("scala_test")
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
    
    Try {
      val response = permissionsService.checkPermission(request)
      logger.info(s"Response: $response")
      Some(response.getPermissionship)
    }.recover {
      case e: Exception =>
        logger.log(Level.WARNING, s"RPC failed: ${e.getMessage}")
        None
    }.get
  }
}

object CallingCheck {
  def main(args: Array[String]): Unit = {
    val target = "grpc.authzed.com:443"
    val token = "tc_test_def_token"
    
    val channel = ManagedChannelBuilder
      .forTarget(target)
      .useTransportSecurity() // for local development without TLS, use .usePlaintext()
      .build()
    
    try {
      val client = new AuthzedClient(channel, token)
      
      client.writeSchema()
      client.readSchema()
      
      val tokenVal = client.writeRelationship()
      
      val result = client.check(
        ZedToken.newBuilder()
          .setToken(tokenVal)
          .build()
      )
      
      println(s"Check result: $result")
    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS)
    }
  }
}
