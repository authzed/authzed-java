// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/materialize/v0/watchpermissions.proto

package com.authzed.api.materialize.v0;

public interface PermissionChangeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.materialize.v0.PermissionChange)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * revision represents the revision at which the change occurred.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken revision = 1 [json_name = "revision"];</code>
   * @return Whether the revision field is set.
   */
  boolean hasRevision();
  /**
   * <pre>
   * revision represents the revision at which the change occurred.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken revision = 1 [json_name = "revision"];</code>
   * @return The revision.
   */
  com.authzed.api.v1.ZedToken getRevision();
  /**
   * <pre>
   * revision represents the revision at which the change occurred.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken revision = 1 [json_name = "revision"];</code>
   */
  com.authzed.api.v1.ZedTokenOrBuilder getRevisionOrBuilder();

  /**
   * <pre>
   * resource is the resource that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.ObjectReference resource = 2 [json_name = "resource"];</code>
   * @return Whether the resource field is set.
   */
  boolean hasResource();
  /**
   * <pre>
   * resource is the resource that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.ObjectReference resource = 2 [json_name = "resource"];</code>
   * @return The resource.
   */
  com.authzed.api.v1.ObjectReference getResource();
  /**
   * <pre>
   * resource is the resource that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.ObjectReference resource = 2 [json_name = "resource"];</code>
   */
  com.authzed.api.v1.ObjectReferenceOrBuilder getResourceOrBuilder();

  /**
   * <pre>
   * permission is the permission that has changed.
   * </pre>
   *
   * <code>string permission = 3 [json_name = "permission"];</code>
   * @return The permission.
   */
  java.lang.String getPermission();
  /**
   * <pre>
   * permission is the permission that has changed.
   * </pre>
   *
   * <code>string permission = 3 [json_name = "permission"];</code>
   * @return The bytes for permission.
   */
  com.google.protobuf.ByteString
      getPermissionBytes();

  /**
   * <pre>
   * subject is the subject that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.SubjectReference subject = 4 [json_name = "subject"];</code>
   * @return Whether the subject field is set.
   */
  boolean hasSubject();
  /**
   * <pre>
   * subject is the subject that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.SubjectReference subject = 4 [json_name = "subject"];</code>
   * @return The subject.
   */
  com.authzed.api.v1.SubjectReference getSubject();
  /**
   * <pre>
   * subject is the subject that the permission change is related to.
   * </pre>
   *
   * <code>.authzed.api.v1.SubjectReference subject = 4 [json_name = "subject"];</code>
   */
  com.authzed.api.v1.SubjectReferenceOrBuilder getSubjectOrBuilder();

  /**
   * <pre>
   * permissionship is the new permissionship of the subject over the resource after the change.
   * </pre>
   *
   * <code>.authzed.api.materialize.v0.PermissionChange.Permissionship permissionship = 5 [json_name = "permissionship"];</code>
   * @return The enum numeric value on the wire for permissionship.
   */
  int getPermissionshipValue();
  /**
   * <pre>
   * permissionship is the new permissionship of the subject over the resource after the change.
   * </pre>
   *
   * <code>.authzed.api.materialize.v0.PermissionChange.Permissionship permissionship = 5 [json_name = "permissionship"];</code>
   * @return The permissionship.
   */
  com.authzed.api.materialize.v0.PermissionChange.Permissionship getPermissionship();
}
