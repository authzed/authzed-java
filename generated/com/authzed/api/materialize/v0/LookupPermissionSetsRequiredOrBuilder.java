// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/materialize/v0/watchpermissionsets.proto

package com.authzed.api.materialize.v0;

public interface LookupPermissionSetsRequiredOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.materialize.v0.LookupPermissionSetsRequired)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * required_lookup_at is the snapshot revision at which the permission set needs to be rebuilt to.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken required_lookup_at = 1 [json_name = "requiredLookupAt"];</code>
   * @return Whether the requiredLookupAt field is set.
   */
  boolean hasRequiredLookupAt();
  /**
   * <pre>
   * required_lookup_at is the snapshot revision at which the permission set needs to be rebuilt to.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken required_lookup_at = 1 [json_name = "requiredLookupAt"];</code>
   * @return The requiredLookupAt.
   */
  com.authzed.api.v1.ZedToken getRequiredLookupAt();
  /**
   * <pre>
   * required_lookup_at is the snapshot revision at which the permission set needs to be rebuilt to.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken required_lookup_at = 1 [json_name = "requiredLookupAt"];</code>
   */
  com.authzed.api.v1.ZedTokenOrBuilder getRequiredLookupAtOrBuilder();
}
