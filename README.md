# Authzed Java Client

[![Maven Metadata](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fauthzed%2Fapi%2Fauthzed%2Fmaven-metadata.xml)](https://search.maven.org/artifact/com.authzed.api/authzed/0.0.1/jar)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://github.com/authzed/authzed-java/workflows/build/badge.svg)](https://github.com/authzed/authzed-java/actions)
[![Discord Server](https://img.shields.io/discord/844600078504951838?color=7289da&logo=discord "Discord Server")](https://discord.gg/jTysUaxXzM)
[![Twitter](https://img.shields.io/twitter/follow/authzed?color=%23179CF0&logo=twitter&style=flat-square)](https://twitter.com/authzed)

This repository houses the Java client library for Authzed.

[Authzed] is a database and service that stores, computes, and validates your application's permissions.

Developers create a schema that models their permissions requirements and use a client library, such as this one, to apply the schema to the database, insert data into the database, and query the data to efficiently check permissions in their applications.

Supported client API versions:
- [v1alpha1](https://docs.authzed.com/reference/api#authzedapiv1alpha1)
- [v0](https://docs.authzed.com/reference/api#authzedapiv0)

You can find more info on each API on the [Authzed API reference documentation].
Additionally, Protobuf API documentation can be found on the [Buf Registry Authzed API repository].

[Authzed]: https://authzed.com
[Authzed API Reference documentation]: https://docs.authzed.com/reference/api
[Buf Registry Authzed API repository]: https://buf.build/authzed/api/docs/main

## Getting Started

We highly recommend following the **[Protecting Your First App]** guide to learn the latest best practice to integrate an application with Authzed.

If you're interested in examples for a specific version of the API, they can be found in their respective folders in the [examples directory].

[Protecting Your First App]: https://docs.authzed.com/guides/first-app
[examples directory]: /examples

## Basic Usage

### Installation

This project is packaged as the artifact `authzed` under the `com.authzed.api` group on [Maven Central].
You can find the commands for installing the jar for various JVM toolchains on the [Maven Central Artifact Page].

Most commonly, if you are using [Maven] you can add the following to your pom.xml:

```xml
<dependency>
  <groupId>com.authzed.api</groupId>
  <artifactId>authzed</artifactId>
  <version>0.0.1</version>
</dependency>
```

[Maven Central]: https://maven.apache.org/repository/index.html
[Maven Central Artifact Page]: https://search.maven.org/artifact/com.authzed.api/authzed/0.0.1/jar
[Maven]: https://maven.apache.org

### Initializing a client

Because of how [grpc-java] is designed, there is little in terms of abstraction over the gRPC APIs underpinning Authzed.
A `ManagedChannel` will establish a connection to Authzed that can be shared with _stubs_ for each gRPC service.
In order to successfully authenticate with the API, you will have to provide a [Bearer Token] with your own API Token from the [Authzed dashboard] in place of `t_your_token_here_1234567deadbeef` as CallCredentials for each stub: 

```java
import com.authzed.api.v0.ACLServiceGrpc;
import com.authzed.grpcutil.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

...

ManagedChannel channel = ManagedChannelBuilder
      .forTarget("grpc.authzed.com:443")
      .useTransportSecurity()
      .build();
ACLServiceGrpc.ACLServiceBlockingStub aclStub = ACLServiceGrpc.newBlockingStub(channel)
      .withCallCredentials(new BearerToken("t_your_token_here_1234567deadbeef");
```

### Performing an API call

Request and Response types are located in their respective gRPC Service packages and common types can be found in the Core package.
Referring to the [Authzed ProtoBuf Documentation] is useful for discovering these APIs.


Because of the verbosity of these types, we recommend writing your own functions/methods to create these types from your existing application's models.

[Authzed Protobuf Documentation]: https://buf.build/authzed/api/docs/main

```java
import com.authzed.api.v0.Core;
import com.authzed.api.v0.AclService;

...

Core.User emilia = Core.User.newBuilder().setUserset(
      Core.ObjectAndRelation
          .setNamespace("blog/user")
          .setObjectId("emilia")
          .setRelation("...")
          .build();
).build();

Core.ObjectAndRelation post1Reader = Core.ObjectAndRelation
      .newBuilder()
      .setNamespace("blog/post")
      .setObjectId("1")
      .setRelation("read")
      .build();

AclService.CheckRequest request = AclService.CheckRequest
      .newBuilder()
      .setUser(emilia)
      .setTestUserset(post1Reader)
      .build();

// Is Emilia in the set of users that can read post #1?
try {
    AclService.CheckResponse response = aclStub.check(request);
} catch (Exception e) {
    logger.log(Level.WARNING, "RPC failed: {0}", e.getMessage());
}
```
