// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/permission_service.proto

package com.authzed.api.v1;

public interface CheckBulkPermissionsPairOrBuilder extends
    // @@protoc_insertion_point(interface_extends:authzed.api.v1.CheckBulkPermissionsPair)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsRequestItem request = 1 [json_name = "request"];</code>
   * @return Whether the request field is set.
   */
  boolean hasRequest();
  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsRequestItem request = 1 [json_name = "request"];</code>
   * @return The request.
   */
  com.authzed.api.v1.CheckBulkPermissionsRequestItem getRequest();
  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsRequestItem request = 1 [json_name = "request"];</code>
   */
  com.authzed.api.v1.CheckBulkPermissionsRequestItemOrBuilder getRequestOrBuilder();

  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsResponseItem item = 2 [json_name = "item"];</code>
   * @return Whether the item field is set.
   */
  boolean hasItem();
  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsResponseItem item = 2 [json_name = "item"];</code>
   * @return The item.
   */
  com.authzed.api.v1.CheckBulkPermissionsResponseItem getItem();
  /**
   * <code>.authzed.api.v1.CheckBulkPermissionsResponseItem item = 2 [json_name = "item"];</code>
   */
  com.authzed.api.v1.CheckBulkPermissionsResponseItemOrBuilder getItemOrBuilder();

  /**
   * <code>.google.rpc.Status error = 3 [json_name = "error"];</code>
   * @return Whether the error field is set.
   */
  boolean hasError();
  /**
   * <code>.google.rpc.Status error = 3 [json_name = "error"];</code>
   * @return The error.
   */
  com.google.rpc.Status getError();
  /**
   * <code>.google.rpc.Status error = 3 [json_name = "error"];</code>
   */
  com.google.rpc.StatusOrBuilder getErrorOrBuilder();

  public com.authzed.api.v1.CheckBulkPermissionsPair.ResponseCase getResponseCase();
}
