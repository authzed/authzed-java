// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/experimental_service.proto

package com.authzed.api.v1;

public interface ExperimentalRegisterRelationshipCounterRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * name is the name of the counter being registered.
   * </pre>
   *
   * <code>string name = 1 [json_name = "name", (.validate.rules) = { ... }</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <pre>
   * name is the name of the counter being registered.
   * </pre>
   *
   * <code>string name = 1 [json_name = "name", (.validate.rules) = { ... }</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * relationship_filter defines the filter to be applied to the relationships
   * to be counted.
   * </pre>
   *
   * <code>.authzed.api.v1.RelationshipFilter relationship_filter = 2 [json_name = "relationshipFilter", (.validate.rules) = { ... }</code>
   * @return Whether the relationshipFilter field is set.
   */
  boolean hasRelationshipFilter();
  /**
   * <pre>
   * relationship_filter defines the filter to be applied to the relationships
   * to be counted.
   * </pre>
   *
   * <code>.authzed.api.v1.RelationshipFilter relationship_filter = 2 [json_name = "relationshipFilter", (.validate.rules) = { ... }</code>
   * @return The relationshipFilter.
   */
  com.authzed.api.v1.RelationshipFilter getRelationshipFilter();
  /**
   * <pre>
   * relationship_filter defines the filter to be applied to the relationships
   * to be counted.
   * </pre>
   *
   * <code>.authzed.api.v1.RelationshipFilter relationship_filter = 2 [json_name = "relationshipFilter", (.validate.rules) = { ... }</code>
   */
  com.authzed.api.v1.RelationshipFilterOrBuilder getRelationshipFilterOrBuilder();
}
