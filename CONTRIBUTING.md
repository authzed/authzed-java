# How to contribute

## Legal requirements

In order to protect both you and ourselves, all commits will require an explicit sign-off that acknowledges the [DCO].

[DCO]: /DCO

## Building & Running tests

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
