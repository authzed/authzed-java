// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/permission_service.proto

package com.authzed.api.v1;

/**
 * <pre>
 * LookupPermissionship represents whether a Lookup response was partially evaluated or not
 * </pre>
 *
 * Protobuf enum {@code authzed.api.v1.LookupPermissionship}
 */
public enum LookupPermissionship
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>LOOKUP_PERMISSIONSHIP_UNSPECIFIED = 0;</code>
   */
  LOOKUP_PERMISSIONSHIP_UNSPECIFIED(0),
  /**
   * <code>LOOKUP_PERMISSIONSHIP_HAS_PERMISSION = 1;</code>
   */
  LOOKUP_PERMISSIONSHIP_HAS_PERMISSION(1),
  /**
   * <code>LOOKUP_PERMISSIONSHIP_CONDITIONAL_PERMISSION = 2;</code>
   */
  LOOKUP_PERMISSIONSHIP_CONDITIONAL_PERMISSION(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>LOOKUP_PERMISSIONSHIP_UNSPECIFIED = 0;</code>
   */
  public static final int LOOKUP_PERMISSIONSHIP_UNSPECIFIED_VALUE = 0;
  /**
   * <code>LOOKUP_PERMISSIONSHIP_HAS_PERMISSION = 1;</code>
   */
  public static final int LOOKUP_PERMISSIONSHIP_HAS_PERMISSION_VALUE = 1;
  /**
   * <code>LOOKUP_PERMISSIONSHIP_CONDITIONAL_PERMISSION = 2;</code>
   */
  public static final int LOOKUP_PERMISSIONSHIP_CONDITIONAL_PERMISSION_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static LookupPermissionship valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static LookupPermissionship forNumber(int value) {
    switch (value) {
      case 0: return LOOKUP_PERMISSIONSHIP_UNSPECIFIED;
      case 1: return LOOKUP_PERMISSIONSHIP_HAS_PERMISSION;
      case 2: return LOOKUP_PERMISSIONSHIP_CONDITIONAL_PERMISSION;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<LookupPermissionship>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      LookupPermissionship> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<LookupPermissionship>() {
          public LookupPermissionship findValueByNumber(int number) {
            return LookupPermissionship.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.authzed.api.v1.PermissionService.getDescriptor().getEnumTypes().get(0);
  }

  private static final LookupPermissionship[] VALUES = values();

  public static LookupPermissionship valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private LookupPermissionship(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:authzed.api.v1.LookupPermissionship)
}

