// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/permission_service.proto

package com.authzed.api.v1;

public interface ExpandPermissionTreeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.ExpandPermissionTreeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.authzed.api.v1.ZedToken expanded_at = 1 [json_name = "expandedAt"];</code>
   * @return Whether the expandedAt field is set.
   */
  boolean hasExpandedAt();
  /**
   * <code>.authzed.api.v1.ZedToken expanded_at = 1 [json_name = "expandedAt"];</code>
   * @return The expandedAt.
   */
  com.authzed.api.v1.ZedToken getExpandedAt();
  /**
   * <code>.authzed.api.v1.ZedToken expanded_at = 1 [json_name = "expandedAt"];</code>
   */
  com.authzed.api.v1.ZedTokenOrBuilder getExpandedAtOrBuilder();

  /**
   * <pre>
   * tree_root is a tree structure whose leaf nodes are subjects, and
   * intermediate nodes represent the various operations (union, intersection,
   * exclusion) to reach those subjects.
   * </pre>
   *
   * <code>.authzed.api.v1.PermissionRelationshipTree tree_root = 2 [json_name = "treeRoot"];</code>
   * @return Whether the treeRoot field is set.
   */
  boolean hasTreeRoot();
  /**
   * <pre>
   * tree_root is a tree structure whose leaf nodes are subjects, and
   * intermediate nodes represent the various operations (union, intersection,
   * exclusion) to reach those subjects.
   * </pre>
   *
   * <code>.authzed.api.v1.PermissionRelationshipTree tree_root = 2 [json_name = "treeRoot"];</code>
   * @return The treeRoot.
   */
  com.authzed.api.v1.PermissionRelationshipTree getTreeRoot();
  /**
   * <pre>
   * tree_root is a tree structure whose leaf nodes are subjects, and
   * intermediate nodes represent the various operations (union, intersection,
   * exclusion) to reach those subjects.
   * </pre>
   *
   * <code>.authzed.api.v1.PermissionRelationshipTree tree_root = 2 [json_name = "treeRoot"];</code>
   */
  com.authzed.api.v1.PermissionRelationshipTreeOrBuilder getTreeRootOrBuilder();
}
