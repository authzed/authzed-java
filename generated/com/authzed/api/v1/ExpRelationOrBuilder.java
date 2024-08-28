// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/experimental_service.proto

package com.authzed.api.v1;

public interface ExpRelationOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.ExpRelation)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1 [json_name = "name"];</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1 [json_name = "name"];</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string comment = 2 [json_name = "comment"];</code>
   * @return The comment.
   */
  java.lang.String getComment();
  /**
   * <code>string comment = 2 [json_name = "comment"];</code>
   * @return The bytes for comment.
   */
  com.google.protobuf.ByteString
      getCommentBytes();

  /**
   * <code>string parent_definition_name = 3 [json_name = "parentDefinitionName"];</code>
   * @return The parentDefinitionName.
   */
  java.lang.String getParentDefinitionName();
  /**
   * <code>string parent_definition_name = 3 [json_name = "parentDefinitionName"];</code>
   * @return The bytes for parentDefinitionName.
   */
  com.google.protobuf.ByteString
      getParentDefinitionNameBytes();

  /**
   * <code>repeated .authzed.api.v1.ExpTypeReference subject_types = 4 [json_name = "subjectTypes"];</code>
   */
  java.util.List<com.authzed.api.v1.ExpTypeReference> 
      getSubjectTypesList();
  /**
   * <code>repeated .authzed.api.v1.ExpTypeReference subject_types = 4 [json_name = "subjectTypes"];</code>
   */
  com.authzed.api.v1.ExpTypeReference getSubjectTypes(int index);
  /**
   * <code>repeated .authzed.api.v1.ExpTypeReference subject_types = 4 [json_name = "subjectTypes"];</code>
   */
  int getSubjectTypesCount();
  /**
   * <code>repeated .authzed.api.v1.ExpTypeReference subject_types = 4 [json_name = "subjectTypes"];</code>
   */
  java.util.List<? extends com.authzed.api.v1.ExpTypeReferenceOrBuilder> 
      getSubjectTypesOrBuilderList();
  /**
   * <code>repeated .authzed.api.v1.ExpTypeReference subject_types = 4 [json_name = "subjectTypes"];</code>
   */
  com.authzed.api.v1.ExpTypeReferenceOrBuilder getSubjectTypesOrBuilder(
      int index);
}
