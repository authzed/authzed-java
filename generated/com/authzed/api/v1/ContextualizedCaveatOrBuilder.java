// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/core.proto

package com.authzed.api.v1;

public interface ContextualizedCaveatOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.ContextualizedCaveat)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * caveat_name is the name of the caveat expression to use, as defined in the schema
   * </pre>
   *
   * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
   * @return The caveatName.
   */
  java.lang.String getCaveatName();
  /**
   * <pre>
   * caveat_name is the name of the caveat expression to use, as defined in the schema
   * </pre>
   *
   * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
   * @return The bytes for caveatName.
   */
  com.google.protobuf.ByteString
      getCaveatNameBytes();

  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   * @return Whether the context field is set.
   */
  boolean hasContext();
  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   * @return The context.
   */
  com.google.protobuf.Struct getContext();
  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   */
  com.google.protobuf.StructOrBuilder getContextOrBuilder();
}
