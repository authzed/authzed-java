# Authzed Java Client Examples

This directory contains examples demonstrating how to use the Authzed Java client library from various JVM languages.

## Available Examples

### Java Examples (`v1/`)
- `CallingCheck.java` - Demonstrates basic permission checking with schema writing, relationship creation, and permission checks
- `CallingWatch.java` - Demonstrates watching for changes in SpiceDB with automatic reconnection

### Kotlin Examples (`kotlin/`)
- `CallingCheck.kt` - Same functionality as the Java example, but using idiomatic Kotlin syntax

### Scala Examples (`scala/`)
- `CallingCheck.scala` - Same functionality as the Java example, but using idiomatic Scala syntax

## Installation

The Authzed Java client library works seamlessly with all JVM languages. Choose your build tool and language:

**Note:** You need to include a gRPC transport implementation like `grpc-netty-shaded` to run these examples. The `authzed` library doesn't include a transport by default to give you flexibility in choosing one.

### Maven (Java)

```xml
<dependencies>
    <dependency>
        <groupId>com.authzed.api</groupId>
        <artifactId>authzed</artifactId>
        <version>1.5.4</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-api</artifactId>
        <version>1.75.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-stub</artifactId>
        <version>1.75.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-netty-shaded</artifactId>
        <version>1.75.0</version>
    </dependency>
</dependencies>
```

### Gradle (Java/Kotlin)

For `build.gradle`:
```groovy
dependencies {
    implementation "com.authzed.api:authzed:1.5.4"
    implementation 'io.grpc:grpc-api:1.75.0'
    implementation 'io.grpc:grpc-stub:1.75.0'
    implementation 'io.grpc:grpc-netty-shaded:1.75.0'
}
```

For `build.gradle.kts` (Kotlin DSL):
```kotlin
dependencies {
    implementation("com.authzed.api:authzed:1.5.4")
    implementation("io.grpc:grpc-api:1.75.0")
    implementation("io.grpc:grpc-stub:1.75.0")
    implementation("io.grpc:grpc-netty-shaded:1.75.0")
}
```

### SBT (Scala)

```scala
libraryDependencies ++= Seq(
  "com.authzed.api" % "authzed" % "1.5.4",
  "io.grpc" % "grpc-api" % "1.75.0",
  "io.grpc" % "grpc-stub" % "1.75.0",
  "io.grpc" % "grpc-netty-shaded" % "1.75.0"
)
```

## Usage

All examples follow the same pattern:

1. **Create a channel** - Connect to SpiceDB using gRPC
2. **Authenticate** - Use a bearer token for authentication
3. **Create service stubs** - Initialize the schema and permissions services
4. **Write a schema** - Define your permission model
5. **Write relationships** - Create relationships between objects
6. **Check permissions** - Verify if a subject has permission on a resource

### Key Differences Between Languages

#### Java
- Uses verbose builder pattern
- Requires explicit exception handling with try-catch
- Traditional class structure

#### Kotlin
- More concise syntax with named parameters and string interpolation
- Better null safety with nullable types (`?`)
- Can use `try-catch` as expressions
- Cleaner lambda syntax

#### Scala
- Functional programming style with `Try` and `Option` monads
- Pattern matching with `recover`
- For-comprehensions for sequential operations (not shown in basic example)
- Immutable by default

## Running the Examples

These examples are meant to be copied into your own project. They demonstrate the API usage patterns but are not standalone runnable programs without:

1. A valid SpiceDB instance (local or cloud)
2. A valid authentication token
3. Proper build configuration for your language

## Getting Started

For a complete guide on integrating SpiceDB with your application, see the [Protecting Your First App](https://authzed.com/docs/guides/first-app) guide.

## Additional Resources

- [Authzed Java Client Documentation](https://authzed.github.io/authzed-java/index.html)
- [SpiceDB API Reference](https://authzed.com/docs/spicedb/api/http-api)
- [Buf Registry SpiceDB API](https://buf.build/authzed/api/docs/main)
- [SpiceDB Documentation](https://authzed.com/docs)
