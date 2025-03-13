/*
 * Authzed API examples for RetryableClient
 */
package v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.authzed.api.v1.ConflictStrategy;
import com.authzed.api.v1.Core;
import com.authzed.api.v1.Core.ObjectReference;
import com.authzed.api.v1.Core.Relationship;
import com.authzed.api.v1.Core.SubjectReference;
import com.authzed.api.v1.RetryableClient;
import com.authzed.api.v1.SchemaServiceOuterClass;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.ReadSchemaResponse;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaRequest;
import com.authzed.api.v1.SchemaServiceOuterClass.WriteSchemaResponse;
import com.authzed.grpcutil.BearerToken;

/**
 * RetryClientDemo demonstrates using RetryableClient with different conflict strategies.
 * 
 * This program connects to a local SpiceDB instance and imports relationships
 * using each of the available conflict strategies:
 * - FAIL: Returns an error if duplicate relationships are found
 * - SKIP: Ignores duplicates and continues with import
 * - TOUCH: Retries the import with TOUCH semantics for duplicates
 */
public class RetryClientDemo {
    // SpiceDB connection details
    private static final String SPICEDB_ADDRESS = "localhost:50051";
    private static final String PRESHARED_KEY = "foobar";
    
    // Number of relationships to create in each test
    private static final int RELATIONSHIPS_COUNT = 1000;
    
    public static void main(String[] args) {
        System.out.println("RetryClientDemo: Demonstrating RetryableClient with different conflict strategies");
        
        // Create a RetryableClient connected to SpiceDB
        RetryableClient client = null;
        try {
            client = RetryableClient.newClient(
                SPICEDB_ADDRESS, 
                new BearerToken(PRESHARED_KEY), 
                true);  // Using plaintext connection
            
            // Write schema for document and user types
            writeSchema(client);
            
            // Verify connection and read schema
            verifyConnection(client);
            
            // Demonstrate each conflict strategy
            demonstrateFailStrategy(client);
            demonstrateSkipStrategy(client);
            demonstrateTouchStrategy(client);
            
            System.out.println("\nDemo completed successfully!");
        } catch (Exception e) {
            System.err.println("Error in RetryClientDemo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
    
    /**
     * Write a schema to SpiceDB with document and user types.
     */
    private static void writeSchema(RetryableClient client) {
        System.out.println("Writing schema to SpiceDB...");
        
        // Define a schema with document and user types
        String schema = """
                definition document {
                    relation reader: user
                    relation writer: user
                    
                    permission read = reader + writer
                    permission write = writer
                }
                
                definition user {}
                """;
        
        // Build the write schema request
        WriteSchemaRequest request = WriteSchemaRequest.newBuilder()
                .setSchema(schema)
                .build();
        
        try {
            // Write the schema
            WriteSchemaResponse response = client.schemaService()
                    .withDeadlineAfter(5, TimeUnit.SECONDS)
                    .writeSchema(request);
            
            System.out.println("Schema written successfully!");
        } catch (Exception e) {
            System.err.println("Failed to write schema: " + e.getMessage());
            throw new RuntimeException("Could not write schema to SpiceDB", e);
        }
    }
    
    /**
     * Verify connection to SpiceDB by reading the schema.
     */
    private static void verifyConnection(RetryableClient client) {
        try {
            ReadSchemaResponse response = client.schemaService()
                    .withDeadlineAfter(5, TimeUnit.SECONDS)
                    .readSchema(ReadSchemaRequest.newBuilder().build());
            
            System.out.println("\nSuccessfully connected to SpiceDB!");
            System.out.println("Schema: " + response.getSchemaText());
        } catch (Exception e) {
            System.err.println("Failed to connect to SpiceDB: " + e.getMessage());
            throw new RuntimeException("Could not connect to SpiceDB", e);
        }
    }
    
    /**
     * Demonstrate FAIL conflict strategy.
     * This strategy will fail if duplicate relationships are found.
     */
    private static void demonstrateFailStrategy(RetryableClient client) {
        System.out.println("\n=== Demonstrating FAIL Strategy ===");
        try {
            // Create unique relationships
            List<Relationship> relationships = generateUniqueRelationships(RELATIONSHIPS_COUNT);
            
            System.out.println("Importing " + relationships.size() + " unique relationships with FAIL strategy...");
            long numLoaded = client.retryableBulkImportRelationships(relationships, ConflictStrategy.FAIL);
            System.out.println("Successfully imported " + numLoaded + " relationships!");
            
            // Now try with some duplicate relationships
            try {
                System.out.println("Now attempting to import same relationships again...");
                client.retryableBulkImportRelationships(relationships, ConflictStrategy.FAIL);
                System.out.println("ERROR: Import should have failed but didn't!");
            } catch (Exception e) {
                System.out.println("As expected, import failed with error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error demonstrating FAIL strategy: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrate SKIP conflict strategy.
     * This strategy will ignore duplicates and continue with the import.
     */
    private static void demonstrateSkipStrategy(RetryableClient client) {
        System.out.println("\n=== Demonstrating SKIP Strategy ===");
        try {
            // Create a mix of new and existing relationships
            List<Relationship> mixedRelationships = generateMixedRelationships(RELATIONSHIPS_COUNT / 2);
            
            System.out.println("Importing " + mixedRelationships.size() + " relationships (mix of new and existing) with SKIP strategy...");
            long numLoaded = client.retryableBulkImportRelationships(mixedRelationships, ConflictStrategy.SKIP);
            
            System.out.println("Successfully processed " + numLoaded + " relationships with SKIP strategy!");
            System.out.println("Note: Duplicates were skipped, but operation completed successfully");
        } catch (Exception e) {
            System.err.println("Error demonstrating SKIP strategy: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrate TOUCH conflict strategy.
     * This strategy will retry the import with TOUCH semantics for duplicates.
     */
    private static void demonstrateTouchStrategy(RetryableClient client) {
        System.out.println("\n=== Demonstrating TOUCH Strategy ===");
        try {
            // Create all new relationships to ensure initial write works
            List<Relationship> newRelationships = generateUniqueRelationships(RELATIONSHIPS_COUNT / 2, RELATIONSHIPS_COUNT);
            
            System.out.println("Importing " + newRelationships.size() + " new relationships...");
            long numLoaded = client.retryableBulkImportRelationships(newRelationships, ConflictStrategy.TOUCH);
            System.out.println("Successfully imported " + numLoaded + " relationships!");
            
            // Now use TOUCH on a mix of new and existing
            List<Relationship> mixedRelationships = new ArrayList<>(newRelationships);
            mixedRelationships.addAll(generateUniqueRelationships(RELATIONSHIPS_COUNT / 4, RELATIONSHIPS_COUNT * 2));
            
            System.out.println("Now importing " + mixedRelationships.size() + " relationships with some duplicates using TOUCH strategy...");
            numLoaded = client.retryableBulkImportRelationships(mixedRelationships, ConflictStrategy.TOUCH);
            
            System.out.println("Successfully processed " + numLoaded + " relationships with TOUCH strategy!");
            System.out.println("Note: Duplicates were touched (re-written) rather than causing an error");
        } catch (Exception e) {
            System.err.println("Error demonstrating TOUCH strategy: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Generate a list of unique relationships.
     */
    private static List<Relationship> generateUniqueRelationships(int count) {
        return generateUniqueRelationships(count, 0);
    }
    
    /**
     * Generate a list of unique relationships with IDs starting from offset.
     */
    private static List<Relationship> generateUniqueRelationships(int count, int offset) {
        List<Relationship> relationships = new ArrayList<>(count);
        Random random = new Random();
        
        for (int i = 0; i < count; i++) {
            String docId = "doc" + (i + offset);
            String userId = "user" + (random.nextInt(20) + 1); // 20 possible users
            String relation = random.nextBoolean() ? "reader" : "writer";
            
            relationships.add(createRelationship(docId, relation, userId));
        }
        
        return relationships;
    }
    
    /**
     * Generate a mix of new and potentially duplicate relationships.
     */
    private static List<Relationship> generateMixedRelationships(int count) {
        List<Relationship> relationships = new ArrayList<>(count);
        Random random = new Random();
        
        for (int i = 0; i < count; i++) {
            // Use a lower document ID range to increase chance of duplicates
            String docId = "doc" + (random.nextInt(count / 2) + 1);
            String userId = "user" + (random.nextInt(10) + 1);
            String relation = random.nextBoolean() ? "reader" : "writer";
            
            relationships.add(createRelationship(docId, relation, userId));
        }
        
        return relationships;
    }
    
    /**
     * Create a relationship between a document and user with the specified relation.
     */
    private static Relationship createRelationship(String docId, String relation, String userId) {
        return Relationship.newBuilder()
            .setResource(ObjectReference.newBuilder()
                .setObjectType("document")
                .setObjectId(docId)
                .build())
            .setRelation(relation)
            .setSubject(SubjectReference.newBuilder()
                .setObject(ObjectReference.newBuilder()
                    .setObjectType("user")
                    .setObjectId(userId)
                    .build())
                .build())
            .build();
    }
}