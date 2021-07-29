# Authzed Java Client

[![Maven Metadata](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fcom%2Fauthzed%2Fapi%2Fauthzed%2Fmaven-metadata.xml)](https://search.maven.org/artifact/com.authzed.api/authzed/0.0.1/jar)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://github.com/authzed/authzed-go/workflows/build/badge.svg)](https://github.com/authzed/authzed-go/actions)
[![Discord Server](https://img.shields.io/discord/844600078504951838?color=7289da&logo=discord "Discord Server")](https://discord.gg/jTysUaxXzM)
[![Twitter](https://img.shields.io/twitter/follow/authzed?color=%23179CF0&logo=twitter&style=flat-square)](https://twitter.com/authzed)

This repository houses the Java client library for Authzed.

The library maintains various versions the Authzed gRPC APIs.
You can find more info on each API on the [Authzed API reference documentation].
Additionally, Protobuf API documentation can be found on the [Buf Registry Authzed API repository].

Supported API versions:
- v1alpha1
- v0

[Authzed API Reference documentation]: https://docs.authzed.com/reference/api
[Buf Registry Authzed API repository]: https://buf.build/authzed/api/docs/main

## Installation

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

## Examples

You can follow the [Protecting Your First App] guide to see the latest best practice for using Authzed client libraries.

If you're interested in examples of a specific version of the API, they can be found in their respective folders in the [examples directory].

[Protecting Your First App]: https://docs.authzed.com/guides/first-app
[examples directory]: /examples

## Building

In order to build this library yourself it requires the following:

- The latest or an LTS version of [Java] (8, 11, 16)
- [buf] in order to download Protobuf definitions

Building is the typical [Gradle wrapper] workflow:

```sh
./gradlew build
```

After a successful build, compiled, source, and javadoc jars are located in `build/libs/`.

[Gradle wrapper]: https://docs.gradle.org/current/userguide/gradle_wrapper.html
[Java]: https://adoptopenjdk.net
[buf]: https://docs.buf.build/installation
