# Authzed Java Client

[![Maven Metadata](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fauthzed%2Fapi%2Fauthzed%2Fmaven-metadata.xml)](https://search.maven.org/artifact/com.authzed.api/authzed)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://github.com/authzed/authzed-java/workflows/build/badge.svg)](https://github.com/authzed/authzed-java/actions)
[![Discord Server](https://img.shields.io/discord/844600078504951838?color=7289da&logo=discord "Discord Server")](https://discord.gg/jTysUaxXzM)
[![Twitter](https://img.shields.io/twitter/follow/authzed?color=%23179CF0&logo=twitter&style=flat-square)](https://twitter.com/authzed)

This repository houses the Java client library for [SpiceDB].

[SpiceDB] is a database and service that stores, computes, and validates your application's permissions.

Developers create a schema that models their permissions requirements and use a client library, such as this one, to apply the schema to the database, insert data into the database, and query the data to efficiently check permissions in their applications.

Supported client API versions:
- [v1](https://authzed.com/docs/reference/api#authzedapiv1)

You can find more info on each API on the [SpiceDB API reference documentation].
Additionally, Protobuf API documentation can be found on the [Buf Registry SpiceDB API repository].
Documentation for the latest Java client release is available as [Javadoc].

See [CONTRIBUTING.md] for instructions on contributing and performing common tasks like building the project and running tests.

[Authzed]: https://authzed.com
[SpiceDB]: https://github.com/authzed/spicedb
[SpiceDB API Reference documentation]: https://authzed.com/docs/reference/api
[Buf Registry SpiceDB API repository]: https://buf.build/authzed/api/docs/main
[CONTRIBUTING.md]: CONTRIBUTING.md
[Javadoc]: https://authzed.github.io/authzed-java/index.html

## Getting Started

We highly recommend following the **[Protecting Your First App]** guide to learn the latest best practice to integrate an application with SpiceDB.

If you're interested in examples for a specific API version, they can be found in their respective folders in the [examples directory].

[Protecting Your First App]: https://authzed.com/docs/guides/first-app
[examples directory]: /examples

## Basic Usage

### Installation

This project is packaged as the artifact `authzed` under the `com.authzed.api` group on [Maven Central].
You can find the commands for installing the jar for various JVM toolchains on the [Maven Central Artifact Page].

Most commonly, if you are using [Maven] you can add the following to your pom.xml:

```xml
<dependencies>
    <dependency>
        <groupId>com.authzed.api</groupId>
        <artifactId>authzed</artifactId>
        <version>v1.0.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-protobuf</artifactId>
        <version>1.66.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-stub</artifactId>
        <version>1.66.0</version>
    </dependency>
</dependencies>
```

If you are using [Gradle] then add the following to your `build.gradle` file:

```groovy
dependencies {
    implementation "com.authzed.api:authzed:v1.0.0"
    implementation 'io.grpc:grpc-protobuf:1.66.0'
    implementation 'io.grpc:grpc-stub:1.66.0'
}
```

[Maven Central]: https://maven.apache.org/repository/index.html
[Maven Central Artifact Page]: https://search.maven.org/artifact/com.authzed.api/authzed
[Maven]: https://maven.apache.org
[Gradle]: https://gradle.org/

### Initializing a client

Because of how [grpc-java] is designed, there is little in terms of abstraction over the gRPC APIs underpinning Authzed.
A `ManagedChannel` will establish a connection to Authzed that can be shared with _stubs_ for each gRPC service.
To successfully authenticate with the API, you will have to provide a [Bearer Token] with your own API Token
from the [Authzed dashboard] or your local SpiceDB instance in place of `t_your_token_here_1234567deadbeef` as 
`CallCredentials` for each stub:

```java
package org.example;

import com.authzed.api.v1.PermissionsServiceGrpc;
import com.authzed.grpcutil.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PermissionServiceExample {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("grpc.authzed.com:443")
                .useTransportSecurity()
                .build();

        BearerToken bearerToken = new BearerToken("t_your_token_here_1234567deadbeef");
        PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService = PermissionsServiceGrpc
                .newBlockingStub(channel)
                .withCallCredentials(bearerToken);
    }
}
```

In case of a local development instance of SpiceDB without TLS, configure your `ManagedChannel` as follows:

```java
ManagedChannel channel = ManagedChannelBuilder
    .forTarget("localhost:50051")
    .usePlaintext()
    .build();
```

[grpc-java]: https://github.com/grpc/grpc-java
[Bearer Token]: https://authzed.com/docs/reference/api#authentication
[Authzed dashboard]: https://app.authzed.com/

### Performing an API call

Request and Response types are located in their respective gRPC Service packages and common types can be found in the Core package.
Referring to the [Authzed ProtoBuf Documentation] is useful for discovering these APIs.

Because of the verbosity of these types, we recommend writing your own functions/methods to create these types from your existing application's models.

The following example initializes a permission client, performs a `CheckPermission` call and prints the result

[Authzed Protobuf Documentation]: https://buf.build/authzed/api/docs/main

```java
package org.example;

import com.authzed.api.v1.*;
import com.authzed.grpcutil.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientExample {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget("localhost:50051")
                .usePlaintext()
                .build();

        BearerToken bearerToken = new BearerToken("t_your_token_here_1234567deadbeef");
        PermissionsServiceGrpc.PermissionsServiceBlockingStub permissionsService = PermissionsServiceGrpc
                .newBlockingStub(channel)
                .withCallCredentials(bearerToken);


        CheckPermissionRequest request = CheckPermissionRequest.newBuilder()
                .setConsistency(
                        Consistency.newBuilder()
                                .setMinimizeLatency(true)
                                .build())
                .setResource(
                        ObjectReference.newBuilder()
                                .setObjectType("blog/post")
                                .setObjectId("1")
                                .build())
                .setSubject(
                        SubjectReference.newBuilder()
                                .setObject(
                                        ObjectReference.newBuilder()
                                                .setObjectType("blog/user")
                                                .setObjectId("emilia")
                                                .build())
                                .build())
                .setPermission("read")
                .build();

        // Is Emilia in the set of users that can read post #1?
        try {
            CheckPermissionResponse response = permissionsService.checkPermission(request);
            System.out.println("result: " + response.getPermissionship().getValueDescriptor().getName());
        } catch (Exception e) {
            System.out.println("Failed to check permission: " + e.getMessage());
        }
    }
}
```
