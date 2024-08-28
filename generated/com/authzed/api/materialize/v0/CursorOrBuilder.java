// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/materialize/v0/watchpermissionsets.proto

package com.authzed.api.materialize.v0;

public interface CursorOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.materialize.v0.Cursor)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * limit is the number of permission sets to stream over a single LookupPermissionSets call that was requested.
   * </pre>
   *
   * <code>uint32 limit = 1 [json_name = "limit"];</code>
   * @return The limit.
   */
  int getLimit();

  /**
   * <pre>
   * token is the snapshot revision at which the cursor was computed.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken token = 4 [json_name = "token"];</code>
   * @return Whether the token field is set.
   */
  boolean hasToken();
  /**
   * <pre>
   * token is the snapshot revision at which the cursor was computed.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken token = 4 [json_name = "token"];</code>
   * @return The token.
   */
  com.authzed.api.v1.ZedToken getToken();
  /**
   * <pre>
   * token is the snapshot revision at which the cursor was computed.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken token = 4 [json_name = "token"];</code>
   */
  com.authzed.api.v1.ZedTokenOrBuilder getTokenOrBuilder();

  /**
   * <pre>
   * starting_index is an offset of the permission set represented by this cursor
   * </pre>
   *
   * <code>uint32 starting_index = 5 [json_name = "startingIndex"];</code>
   * @return The startingIndex.
   */
  int getStartingIndex();

  /**
   * <pre>
   * completed_members is a boolean flag that indicates that the cursor has reached the end of the permission sets
   * </pre>
   *
   * <code>bool completed_members = 6 [json_name = "completedMembers"];</code>
   * @return The completedMembers.
   */
  boolean getCompletedMembers();

  /**
   * <pre>
   * starting_key is a string cursor used by some backends to resume the stream from a specific point.
   * </pre>
   *
   * <code>string starting_key = 7 [json_name = "startingKey"];</code>
   * @return The startingKey.
   */
  java.lang.String getStartingKey();
  /**
   * <pre>
   * starting_key is a string cursor used by some backends to resume the stream from a specific point.
   * </pre>
   *
   * <code>string starting_key = 7 [json_name = "startingKey"];</code>
   * @return The bytes for startingKey.
   */
  com.google.protobuf.ByteString
      getStartingKeyBytes();
}
