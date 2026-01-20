# Maven Dependency Management Best Practices

This guide helps Maven users resolve dependency convergence issues when using authzed-java alongside other libraries, particularly gRPC.

## Table of Contents
- [Understanding Dependency Convergence](#understanding-dependency-convergence)
- [Recommended Solution: Use dependencyManagement](#recommended-solution-use-dependencymanagement)
- [Option 1: Use gRPC BOM (Recommended)](#option-1-use-grpc-bom-recommended)
- [Option 2: Explicit Version Pinning](#option-2-explicit-version-pinning)
- [Option 3: Exclusions (Last Resort)](#option-3-exclusions-last-resort)
- [Complete Example](#complete-example)
- [References](#references)

---

## Understanding Dependency Convergence

The Maven Enforcer Plugin's `dependencyConvergence` rule ensures that "dependency versions are the same everywhere in the tree" ([Maven Enforcer Documentation](https://maven.apache.org/enforcer/enforcer-rules/dependencyConvergence.html)). This prevents runtime classpath conflicts.

### Common Convergence Errors with authzed-java

When using authzed-java with other gRPC-based libraries, you may encounter version conflicts for:
- `io.grpc:grpc-api`
- `com.google.protobuf:protobuf-java`
- `com.google.j2objc:j2objc-annotations`
- `com.google.api.grpc:proto-google-common-protos`
- `com.google.code.gson:gson`

### Why This Happens

**Gradle vs Maven**: authzed-java is built with Gradle, which automatically resolves conflicts by choosing the newest version. Maven, with the enforcer plugin enabled, requires explicit version alignment.

---

## Recommended Solution: Use dependencyManagement

Maven's `<dependencyManagement>` section "allows project authors to directly specify the versions of artifacts to be used when they are encountered in transitive dependencies" ([Maven Dependency Mechanism Guide](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)).

### Benefits
- ✅ Centralizes version control
- ✅ Prevents version conflicts across your entire dependency tree
- ✅ Works for both compile and runtime scopes
- ✅ No need for exclusions scattered throughout your POM
- ✅ Future-proof as dependencies evolve

---

## Option 1: Use gRPC BOM (Recommended)

The **Bill of Materials (BOM)** pattern provides centralized version management for groups of related dependencies.

### What is the gRPC BOM?

The gRPC project provides `io.grpc:grpc-bom` which manages versions for all gRPC modules (`io.grpc:*` artifacts like grpc-api, grpc-protobuf, grpc-stub, etc.).

**Important**: The gRPC BOM does **not** manage dependencies outside the `io.grpc` group, including:
- `com.google.api.grpc:proto-google-common-protos`
- `com.google.j2objc:j2objc-annotations`
- `com.google.protobuf:protobuf-java`

For more details, see the [gRPC BOM on Maven Central](https://central.sonatype.com/artifact/io.grpc/grpc-bom).

### Implementation

```xml
<project>
    <dependencyManagement>
        <dependencies>
            <!-- Import gRPC BOM to align all gRPC versions -->
            <dependency>
                <groupId>io.grpc</groupId>
                <artifactId>grpc-bom</artifactId>
                <version>1.76.0</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- Your gRPC dependencies (versions managed by BOM) -->
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-api</artifactId>
        </dependency>

        <!-- authzed-java SDK -->
        <dependency>
            <groupId>com.authzed.api</groupId>
            <artifactId>authzed</artifactId>
            <version>1.5.4</version>
        </dependency>
    </dependencies>
</project>
```

### How It Works

1. The `<scope>import</scope>` directive imports the gRPC BOM's dependency management
2. The BOM defines versions for all gRPC modules (grpc-api, grpc-protobuf, etc.)
3. Your gRPC dependencies don't need explicit versions
4. authzed-java's transitive gRPC dependencies align with the BOM's versions

### Version Selection and Trade-offs

**Which gRPC version should you use?**

- authzed-java 1.5.4 uses gRPC **1.75.0**
- You can import the gRPC BOM at 1.75.0 to match authzed's version
- gRPC minor releases are generally source compatible, but always check the [gRPC Release Notes](https://github.com/grpc/grpc-java/releases) before upgrading to 1.76.0+

**Important: What the gRPC BOM Actually Manages**:

The gRPC BOM **only manages `io.grpc:*` artifacts** (grpc-api, grpc-protobuf, grpc-stub, etc.). It does **not** manage:
- `com.google.api.grpc:proto-google-common-protos`
- `com.google.j2objc:j2objc-annotations`
- `com.google.protobuf:protobuf-java`

**Version Sources in Your Build**:
```
Your project
├─ gRPC BOM 1.75.0 (in dependencyManagement)
│  └─ manages io.grpc:* artifacts at 1.75.0
├─ authzed-java 1.5.4
│  ├─ uses gRPC 1.75.0 (aligned with BOM)
│  ├─ explicitly declares proto-google-common-protos 2.61.3 (authzed's choice)
│  └─ explicitly declares protobuf-java 4.32.1
└─ protobuf-java-util 4.32.1 (transitive)
   └─ brings j2objc-annotations 2.8
```

**When using the BOM**: The BOM manages gRPC module versions (1.75.0) only. Other dependencies like proto-google-common-protos:2.61.3 come from authzed-java's own POM, not the BOM.

---

## Option 2: Explicit Version Pinning

If you're not using the gRPC BOM, you can explicitly pin versions in `<dependencyManagement>`. However, **we strongly recommend using the gRPC BOM instead** to ensure compatibility.

**⚠️ Important**: Only pin the versions of direct dependencies or those causing actual conflicts. Let Maven resolve transitive dependencies when possible to avoid forcing incompatible versions.

```xml
<dependencyManagement>
    <dependencies>
        <!-- Pin gRPC modules to align with your stack -->
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-api</artifactId>
            <version>1.75.0</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-protobuf</artifactId>
            <version>1.75.0</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-stub</artifactId>
            <version>1.75.0</version>
        </dependency>

        <!-- Pin protobuf versions if needed -->
        <dependency>
            <groupId>com.google.protobuf</groupId>
            <artifactId>protobuf-java</artifactId>
            <version>4.32.1</version>
        </dependency>

        <!-- Only pin these if you have actual convergence errors -->
        <!-- Let the gRPC/protobuf transitive dependencies handle these otherwise -->
    </dependencies>
</dependencyManagement>

<dependencies>
    <dependency>
        <groupId>com.authzed.api</groupId>
        <artifactId>authzed</artifactId>
        <version>1.5.4</version>
    </dependency>
    <!-- Your other dependencies -->
</dependencies>
```

### Version Compatibility Notes

- **authzed-java 1.5.4** explicitly declares:
  - gRPC modules at **1.75.0**
  - protobuf-java **4.32.1**
  - proto-google-common-protos **2.61.3**

- **gRPC 1.75.0/1.76.0 BOM** manages:
  - Only `io.grpc:*` artifacts (grpc-api, grpc-protobuf, grpc-stub, etc.)
  - Does **not** manage proto-google-common-protos or j2objc-annotations

- **Common dependency versions** in your build:
  - proto-google-common-protos **2.61.3** (from authzed-java)
  - j2objc-annotations **2.8** (from protobuf-java-util:4.32.1)
  - Note: guava brings j2objc-annotations:3.0.0, creating a 2.8 vs 3.0.0 conflict

**When pinning proto-google-common-protos**:
- Pin to **2.61.3** to match authzed's version (recommended)
- This is authzed's tested version and includes the protos needed by the SDK

**For j2objc-annotations**: Pin to **2.8** (from protobuf-java-util) to resolve the 2.8 vs 3.0.0 conflict

---

## Option 3: Exclusions (Last Resort)

If you cannot use `dependencyManagement`, use exclusions. **This approach is NOT recommended** as it requires manual maintenance and doesn't scale well.

```xml
<dependency>
    <groupId>com.authzed.api</groupId>
    <artifactId>authzed</artifactId>
    <version>1.5.4</version>
    <exclusions>
        <!-- Exclude if your gRPC version brings a different version -->
        <exclusion>
            <groupId>com.google.j2objc</groupId>
            <artifactId>j2objc-annotations</artifactId>
        </exclusion>
        <!-- Exclude if conflicting with your gRPC version -->
        <exclusion>
            <groupId>com.google.api.grpc</groupId>
            <artifactId>proto-google-common-protos</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- Explicitly declare the versions you want to use -->
<!-- Use 2.8 from protobuf-java-util, or let guava's 3.0.0 win -->
<dependency>
    <groupId>com.google.j2objc</groupId>
    <artifactId>j2objc-annotations</artifactId>
    <version>2.8</version>
</dependency>
<!-- Use 2.61.3 to match authzed's tested version -->
<dependency>
    <groupId>com.google.api.grpc</groupId>
    <artifactId>proto-google-common-protos</artifactId>
    <version>2.61.3</version>
</dependency>
```

### Why Exclusions Are Problematic
- ❌ Requires you to know all transitive dependencies
- ❌ Breaks when authzed-java updates its dependencies
- ❌ Doesn't prevent other conflicts in your dependency tree
- ❌ Manual maintenance burden

---

## Complete Example

Here's a complete POM demonstrating best practices:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>my-authzed-app</artifactId>
    <version>1.0.0</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <!-- authzed-java 1.5.4 uses gRPC 1.75.0 -->
        <grpc.version>1.75.0</grpc.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!-- Import gRPC BOM for centralized version management -->
            <dependency>
                <groupId>io.grpc</groupId>
                <artifactId>grpc-bom</artifactId>
                <version>${grpc.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- Pin j2objc-annotations to resolve 2.8 vs 3.0.0 conflict -->
            <dependency>
                <groupId>com.google.j2objc</groupId>
                <artifactId>j2objc-annotations</artifactId>
                <version>2.8</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <!-- authzed-java SDK -->
        <dependency>
            <groupId>com.authzed.api</groupId>
            <artifactId>authzed</artifactId>
            <version>1.5.4</version>
        </dependency>

        <!-- Your gRPC dependencies (versions from BOM) -->
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-netty-shaded</artifactId>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-services</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Enforce dependency convergence -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-enforcer-plugin</artifactId>
                <version>3.6.2</version>
                <executions>
                    <execution>
                        <id>enforce-dependency-convergence</id>
                        <goals>
                            <goal>enforce</goal>
                        </goals>
                        <configuration>
                            <rules>
                                <dependencyConvergence/>
                            </rules>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## Troubleshooting

### Viewing Your Dependency Tree

```bash
mvn dependency:tree
```

### Finding Convergence Issues

```bash
mvn enforcer:enforce
```

### Testing Locally

After changes, verify convergence:

```bash
mvn clean verify
```

### Common Issues

#### Issue: "Dependency convergence error for io.grpc:grpc-api"
**Solution**: Use the gRPC BOM or pin the version in `<dependencyManagement>`

#### Issue: "Dependency convergence error for com.google.api.grpc:proto-google-common-protos"
**Cause**: Multiple transitive dependencies may bring different versions; authzed-java declares 2.61.3
**Solution**: Pin to authzed's tested version in `<dependencyManagement>`:
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.google.api.grpc</groupId>
            <artifactId>proto-google-common-protos</artifactId>
            <version>2.61.3</version>  <!-- Match authzed's version -->
        </dependency>
    </dependencies>
</dependencyManagement>
```
Note: The gRPC BOM does not manage this artifact; use authzed's version for best compatibility.

#### Issue: "Dependency convergence error for com.google.j2objc:j2objc-annotations"
**Cause**: guava brings 3.0.0, protobuf-java-util brings 2.8
**Solution**: Add version pinning in `<dependencyManagement>`:
```xml
<dependency>
    <groupId>com.google.j2objc</groupId>
    <artifactId>j2objc-annotations</artifactId>
    <version>2.8</version>  <!-- From protobuf-java-util -->
</dependency>
```
Note: Using 3.0.0 (guava's version) also works but may cause convergence warnings.

#### Issue: Compilation errors after adding exclusions
**Cause**: You excluded a required dependency
**Solution**: Re-add the excluded artifact as an explicit dependency with the correct version

---

## References

### Official Documentation

1. **Maven Dependency Mechanism**
   https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html
   Official Apache Maven guide on dependency management, transitive dependencies, and the `<dependencyManagement>` section.

2. **Maven Enforcer Plugin - Dependency Convergence Rule**
   https://maven.apache.org/enforcer/enforcer-rules/dependencyConvergence.html
   Official documentation for the dependency convergence rule, including configuration options and resolution strategies.

3. **gRPC BOM (Bill of Materials)**
   https://central.sonatype.com/artifact/io.grpc/grpc-bom
   Maven Central repository page for the gRPC BOM artifact with version history and usage examples.

4. **gRPC Java Examples**
   https://github.com/grpc/grpc-java/blob/master/examples/pom.xml
   Official gRPC Java examples demonstrating BOM usage in Maven projects.

### Additional Resources

5. **Maven BOM Pattern**
   https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#bill-of-materials-bom-poms
   Explanation of the Bill of Materials pattern and the `import` scope.

6. **Dependency Convergence Best Practices**
   https://rieckpil.de/avoid-runtime-errors-with-maven-dependency-convergence/
   Community guide on avoiding runtime errors through proper dependency convergence.

7. **Stack Overflow: Solving Maven Dependency Convergence Issues**
   https://stackoverflow.com/questions/16100315/solving-maven-dependency-convergence-issues
   Community-contributed strategies for resolving convergence problems.

---

## Support

If you encounter dependency convergence issues not covered by this guide:

1. Check your dependency tree: `mvn dependency:tree`
2. Review the [authzed-java releases](https://github.com/authzed/authzed-java/releases) for version compatibility notes
3. Open an issue at https://github.com/authzed/authzed-java/issues with:
   - Your Maven version
   - The complete convergence error output
   - Your `pom.xml` dependencies section
   - Output of `mvn dependency:tree`

---

## Summary

**Best Practice Hierarchy:**

1. ✅ **Use gRPC BOM** - Most reliable, future-proof
2. ✅ **Explicit version pinning in dependencyManagement** - Good for fine-grained control
3. ⚠️ **Exclusions** - Only as a last resort, high maintenance

**Key Takeaways:**

- Maven's `<dependencyManagement>` is the recommended solution for version conflicts
- The gRPC BOM simplifies dependency management significantly **for `io.grpc:*` artifacts only**
- The gRPC BOM does **not** manage proto-google-common-protos, j2objc-annotations, or protobuf-java
- authzed-java declares proto-google-common-protos:2.61.3 - use this tested version
- For j2objc-annotations conflicts, pin to 2.8 (from protobuf-java-util)
- Exclusions should be avoided when possible - use version pinning instead
- Test with `mvn enforcer:enforce` after making changes
- Document your version choices for future maintainers

**What Actually Happens When You Use the gRPC BOM + authzed-java:**

The BOM manages `io.grpc:*` versions only. Other dependencies come from authzed-java's POM and its transitive dependencies:
- ✅ gRPC modules: Controlled by BOM (1.75.0 or your chosen version)
- ✅ proto-google-common-protos: authzed's 2.61.3 (from authzed-java's POM)
- ⚠️ j2objc-annotations: May need manual pinning to resolve 2.8 (protobuf-java-util) vs 3.0.0 (guava) conflict
- ✅ protobuf-java: authzed's 4.32.1 (from authzed-java's POM)

This combination is tested and works correctly.
