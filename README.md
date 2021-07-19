# Authzed Java Client

This repository houses the Java client library for Authzed.

The library maintains various versions the Authzed gRPC APIs.
You can find more info on each API on the [Authzed API reference documentation].
Additionally, Protobuf API documentation can be found on the [Buf Registry Authzed API repository].

[Authzed API Reference documentation]: https://docs.authzed.com/reference/api
[Buf Registry Authzed API repository]: https://buf.build/authzed/api/docs/main

Supported API versions:
- v1alpha1
- v0

## Installation

If you're using [Gradle], add the following to your `build.gradle`:

[Gradle]: https://gradle.org

```groovy
dependencies {
  implementation "com.authzed.api:authzed:0.0.1"
}
```

## Example Usage

```java
// TODO(jzelinskie): write an example
```

## Building

This project requires [buf] in order to download Protobuf definitions.

[buf]: https://docs.buf.build/installation

Building is the typical [Gradle wrapper] workflow:

[Gradle wrapper]: https://docs.gradle.org/current/userguide/gradle_wrapper.html

```sh
./gradlew build
```

After a successful build, compiled, source, and javadoc jars are located in `build/libs/`.
