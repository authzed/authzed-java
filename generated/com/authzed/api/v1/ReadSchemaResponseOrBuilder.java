// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/schema_service.proto

package com.authzed.api.v1;

public interface ReadSchemaResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.ReadSchemaResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * schema_text is the textual form of the current schema in the system
   * </pre>
   *
   * <code>string schema_text = 1 [json_name = "schemaText"];</code>
   * @return The schemaText.
   */
  java.lang.String getSchemaText();
  /**
   * <pre>
   * schema_text is the textual form of the current schema in the system
   * </pre>
   *
   * <code>string schema_text = 1 [json_name = "schemaText"];</code>
   * @return The bytes for schemaText.
   */
  com.google.protobuf.ByteString
      getSchemaTextBytes();

  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt", (.validate.rules) = { ... }</code>
   * @return Whether the readAt field is set.
   */
  boolean hasReadAt();
  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt", (.validate.rules) = { ... }</code>
   * @return The readAt.
   */
  com.authzed.api.v1.ZedToken getReadAt();
  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt", (.validate.rules) = { ... }</code>
   */
  com.authzed.api.v1.ZedTokenOrBuilder getReadAtOrBuilder();
}
