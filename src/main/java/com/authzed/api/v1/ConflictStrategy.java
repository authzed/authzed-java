package com.authzed.api.v1;

/**
 * ConflictStrategy represents the strategy to be used when a conflict occurs
 * during a bulk import of relationships into SpiceDB.
 */
public enum ConflictStrategy {
    /**
     * FAIL - The operation will fail if any duplicate relationships are found.
     */
    FAIL,
    
    /**
     * SKIP - The operation will ignore duplicates and continue with the import.
     */
    SKIP,
    
    /**
     * TOUCH - The operation will retry the import with TOUCH semantics in case of duplicates.
     */
    TOUCH
}