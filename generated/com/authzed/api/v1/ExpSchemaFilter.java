// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/experimental_service.proto

package com.authzed.api.v1;

/**
 * <pre>
 * ExpSchemaFilter is a filter that can be applied to the schema on reflection.
 * </pre>
 *
 * Protobuf type {@code authzed.api.v1.ExpSchemaFilter}
 */
public final class ExpSchemaFilter extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:authzed.api.v1.ExpSchemaFilter)
    ExpSchemaFilterOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExpSchemaFilter.newBuilder() to construct.
  private ExpSchemaFilter(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExpSchemaFilter() {
    optionalDefinitionNameFilter_ = "";
    optionalCaveatNameFilter_ = "";
    optionalRelationNameFilter_ = "";
    optionalPermissionNameFilter_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExpSchemaFilter();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpSchemaFilter_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpSchemaFilter_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.authzed.api.v1.ExpSchemaFilter.class, com.authzed.api.v1.ExpSchemaFilter.Builder.class);
  }

  public static final int OPTIONAL_DEFINITION_NAME_FILTER_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object optionalDefinitionNameFilter_ = "";
  /**
   * <pre>
   * optional_definition_name_filter is a prefix that is matched against the definition name.
   * </pre>
   *
   * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
   * @return The optionalDefinitionNameFilter.
   */
  @java.lang.Override
  public java.lang.String getOptionalDefinitionNameFilter() {
    java.lang.Object ref = optionalDefinitionNameFilter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      optionalDefinitionNameFilter_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * optional_definition_name_filter is a prefix that is matched against the definition name.
   * </pre>
   *
   * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
   * @return The bytes for optionalDefinitionNameFilter.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOptionalDefinitionNameFilterBytes() {
    java.lang.Object ref = optionalDefinitionNameFilter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      optionalDefinitionNameFilter_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPTIONAL_CAVEAT_NAME_FILTER_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object optionalCaveatNameFilter_ = "";
  /**
   * <pre>
   * optional_caveat_name_filter is a prefix that is matched against the caveat name.
   * </pre>
   *
   * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
   * @return The optionalCaveatNameFilter.
   */
  @java.lang.Override
  public java.lang.String getOptionalCaveatNameFilter() {
    java.lang.Object ref = optionalCaveatNameFilter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      optionalCaveatNameFilter_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * optional_caveat_name_filter is a prefix that is matched against the caveat name.
   * </pre>
   *
   * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
   * @return The bytes for optionalCaveatNameFilter.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOptionalCaveatNameFilterBytes() {
    java.lang.Object ref = optionalCaveatNameFilter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      optionalCaveatNameFilter_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPTIONAL_RELATION_NAME_FILTER_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object optionalRelationNameFilter_ = "";
  /**
   * <pre>
   * optional_relation_name_filter is a prefix that is matched against the relation name.
   * </pre>
   *
   * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
   * @return The optionalRelationNameFilter.
   */
  @java.lang.Override
  public java.lang.String getOptionalRelationNameFilter() {
    java.lang.Object ref = optionalRelationNameFilter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      optionalRelationNameFilter_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * optional_relation_name_filter is a prefix that is matched against the relation name.
   * </pre>
   *
   * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
   * @return The bytes for optionalRelationNameFilter.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOptionalRelationNameFilterBytes() {
    java.lang.Object ref = optionalRelationNameFilter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      optionalRelationNameFilter_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OPTIONAL_PERMISSION_NAME_FILTER_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object optionalPermissionNameFilter_ = "";
  /**
   * <pre>
   * optional_permission_name_filter is a prefix that is matched against the permission name.
   * </pre>
   *
   * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
   * @return The optionalPermissionNameFilter.
   */
  @java.lang.Override
  public java.lang.String getOptionalPermissionNameFilter() {
    java.lang.Object ref = optionalPermissionNameFilter_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      optionalPermissionNameFilter_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * optional_permission_name_filter is a prefix that is matched against the permission name.
   * </pre>
   *
   * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
   * @return The bytes for optionalPermissionNameFilter.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOptionalPermissionNameFilterBytes() {
    java.lang.Object ref = optionalPermissionNameFilter_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      optionalPermissionNameFilter_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalDefinitionNameFilter_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, optionalDefinitionNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalCaveatNameFilter_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, optionalCaveatNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalRelationNameFilter_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, optionalRelationNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalPermissionNameFilter_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, optionalPermissionNameFilter_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalDefinitionNameFilter_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, optionalDefinitionNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalCaveatNameFilter_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, optionalCaveatNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalRelationNameFilter_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, optionalRelationNameFilter_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(optionalPermissionNameFilter_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, optionalPermissionNameFilter_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.authzed.api.v1.ExpSchemaFilter)) {
      return super.equals(obj);
    }
    com.authzed.api.v1.ExpSchemaFilter other = (com.authzed.api.v1.ExpSchemaFilter) obj;

    if (!getOptionalDefinitionNameFilter()
        .equals(other.getOptionalDefinitionNameFilter())) return false;
    if (!getOptionalCaveatNameFilter()
        .equals(other.getOptionalCaveatNameFilter())) return false;
    if (!getOptionalRelationNameFilter()
        .equals(other.getOptionalRelationNameFilter())) return false;
    if (!getOptionalPermissionNameFilter()
        .equals(other.getOptionalPermissionNameFilter())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + OPTIONAL_DEFINITION_NAME_FILTER_FIELD_NUMBER;
    hash = (53 * hash) + getOptionalDefinitionNameFilter().hashCode();
    hash = (37 * hash) + OPTIONAL_CAVEAT_NAME_FILTER_FIELD_NUMBER;
    hash = (53 * hash) + getOptionalCaveatNameFilter().hashCode();
    hash = (37 * hash) + OPTIONAL_RELATION_NAME_FILTER_FIELD_NUMBER;
    hash = (53 * hash) + getOptionalRelationNameFilter().hashCode();
    hash = (37 * hash) + OPTIONAL_PERMISSION_NAME_FILTER_FIELD_NUMBER;
    hash = (53 * hash) + getOptionalPermissionNameFilter().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpSchemaFilter parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.authzed.api.v1.ExpSchemaFilter prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * ExpSchemaFilter is a filter that can be applied to the schema on reflection.
   * </pre>
   *
   * Protobuf type {@code authzed.api.v1.ExpSchemaFilter}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:authzed.api.v1.ExpSchemaFilter)
      com.authzed.api.v1.ExpSchemaFilterOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpSchemaFilter_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpSchemaFilter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.authzed.api.v1.ExpSchemaFilter.class, com.authzed.api.v1.ExpSchemaFilter.Builder.class);
    }

    // Construct using com.authzed.api.v1.ExpSchemaFilter.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      optionalDefinitionNameFilter_ = "";
      optionalCaveatNameFilter_ = "";
      optionalRelationNameFilter_ = "";
      optionalPermissionNameFilter_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpSchemaFilter_descriptor;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpSchemaFilter getDefaultInstanceForType() {
      return com.authzed.api.v1.ExpSchemaFilter.getDefaultInstance();
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpSchemaFilter build() {
      com.authzed.api.v1.ExpSchemaFilter result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpSchemaFilter buildPartial() {
      com.authzed.api.v1.ExpSchemaFilter result = new com.authzed.api.v1.ExpSchemaFilter(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.authzed.api.v1.ExpSchemaFilter result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.optionalDefinitionNameFilter_ = optionalDefinitionNameFilter_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.optionalCaveatNameFilter_ = optionalCaveatNameFilter_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.optionalRelationNameFilter_ = optionalRelationNameFilter_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.optionalPermissionNameFilter_ = optionalPermissionNameFilter_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.authzed.api.v1.ExpSchemaFilter) {
        return mergeFrom((com.authzed.api.v1.ExpSchemaFilter)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.authzed.api.v1.ExpSchemaFilter other) {
      if (other == com.authzed.api.v1.ExpSchemaFilter.getDefaultInstance()) return this;
      if (!other.getOptionalDefinitionNameFilter().isEmpty()) {
        optionalDefinitionNameFilter_ = other.optionalDefinitionNameFilter_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getOptionalCaveatNameFilter().isEmpty()) {
        optionalCaveatNameFilter_ = other.optionalCaveatNameFilter_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getOptionalRelationNameFilter().isEmpty()) {
        optionalRelationNameFilter_ = other.optionalRelationNameFilter_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getOptionalPermissionNameFilter().isEmpty()) {
        optionalPermissionNameFilter_ = other.optionalPermissionNameFilter_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              optionalDefinitionNameFilter_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              optionalCaveatNameFilter_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              optionalRelationNameFilter_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              optionalPermissionNameFilter_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object optionalDefinitionNameFilter_ = "";
    /**
     * <pre>
     * optional_definition_name_filter is a prefix that is matched against the definition name.
     * </pre>
     *
     * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
     * @return The optionalDefinitionNameFilter.
     */
    public java.lang.String getOptionalDefinitionNameFilter() {
      java.lang.Object ref = optionalDefinitionNameFilter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        optionalDefinitionNameFilter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * optional_definition_name_filter is a prefix that is matched against the definition name.
     * </pre>
     *
     * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
     * @return The bytes for optionalDefinitionNameFilter.
     */
    public com.google.protobuf.ByteString
        getOptionalDefinitionNameFilterBytes() {
      java.lang.Object ref = optionalDefinitionNameFilter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        optionalDefinitionNameFilter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * optional_definition_name_filter is a prefix that is matched against the definition name.
     * </pre>
     *
     * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
     * @param value The optionalDefinitionNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalDefinitionNameFilter(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      optionalDefinitionNameFilter_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_definition_name_filter is a prefix that is matched against the definition name.
     * </pre>
     *
     * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
     * @return This builder for chaining.
     */
    public Builder clearOptionalDefinitionNameFilter() {
      optionalDefinitionNameFilter_ = getDefaultInstance().getOptionalDefinitionNameFilter();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_definition_name_filter is a prefix that is matched against the definition name.
     * </pre>
     *
     * <code>string optional_definition_name_filter = 1 [json_name = "optionalDefinitionNameFilter"];</code>
     * @param value The bytes for optionalDefinitionNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalDefinitionNameFilterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      optionalDefinitionNameFilter_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object optionalCaveatNameFilter_ = "";
    /**
     * <pre>
     * optional_caveat_name_filter is a prefix that is matched against the caveat name.
     * </pre>
     *
     * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
     * @return The optionalCaveatNameFilter.
     */
    public java.lang.String getOptionalCaveatNameFilter() {
      java.lang.Object ref = optionalCaveatNameFilter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        optionalCaveatNameFilter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * optional_caveat_name_filter is a prefix that is matched against the caveat name.
     * </pre>
     *
     * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
     * @return The bytes for optionalCaveatNameFilter.
     */
    public com.google.protobuf.ByteString
        getOptionalCaveatNameFilterBytes() {
      java.lang.Object ref = optionalCaveatNameFilter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        optionalCaveatNameFilter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * optional_caveat_name_filter is a prefix that is matched against the caveat name.
     * </pre>
     *
     * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
     * @param value The optionalCaveatNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalCaveatNameFilter(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      optionalCaveatNameFilter_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_caveat_name_filter is a prefix that is matched against the caveat name.
     * </pre>
     *
     * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
     * @return This builder for chaining.
     */
    public Builder clearOptionalCaveatNameFilter() {
      optionalCaveatNameFilter_ = getDefaultInstance().getOptionalCaveatNameFilter();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_caveat_name_filter is a prefix that is matched against the caveat name.
     * </pre>
     *
     * <code>string optional_caveat_name_filter = 2 [json_name = "optionalCaveatNameFilter"];</code>
     * @param value The bytes for optionalCaveatNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalCaveatNameFilterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      optionalCaveatNameFilter_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object optionalRelationNameFilter_ = "";
    /**
     * <pre>
     * optional_relation_name_filter is a prefix that is matched against the relation name.
     * </pre>
     *
     * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
     * @return The optionalRelationNameFilter.
     */
    public java.lang.String getOptionalRelationNameFilter() {
      java.lang.Object ref = optionalRelationNameFilter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        optionalRelationNameFilter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * optional_relation_name_filter is a prefix that is matched against the relation name.
     * </pre>
     *
     * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
     * @return The bytes for optionalRelationNameFilter.
     */
    public com.google.protobuf.ByteString
        getOptionalRelationNameFilterBytes() {
      java.lang.Object ref = optionalRelationNameFilter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        optionalRelationNameFilter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * optional_relation_name_filter is a prefix that is matched against the relation name.
     * </pre>
     *
     * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
     * @param value The optionalRelationNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalRelationNameFilter(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      optionalRelationNameFilter_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_relation_name_filter is a prefix that is matched against the relation name.
     * </pre>
     *
     * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
     * @return This builder for chaining.
     */
    public Builder clearOptionalRelationNameFilter() {
      optionalRelationNameFilter_ = getDefaultInstance().getOptionalRelationNameFilter();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_relation_name_filter is a prefix that is matched against the relation name.
     * </pre>
     *
     * <code>string optional_relation_name_filter = 3 [json_name = "optionalRelationNameFilter"];</code>
     * @param value The bytes for optionalRelationNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalRelationNameFilterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      optionalRelationNameFilter_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object optionalPermissionNameFilter_ = "";
    /**
     * <pre>
     * optional_permission_name_filter is a prefix that is matched against the permission name.
     * </pre>
     *
     * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
     * @return The optionalPermissionNameFilter.
     */
    public java.lang.String getOptionalPermissionNameFilter() {
      java.lang.Object ref = optionalPermissionNameFilter_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        optionalPermissionNameFilter_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * optional_permission_name_filter is a prefix that is matched against the permission name.
     * </pre>
     *
     * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
     * @return The bytes for optionalPermissionNameFilter.
     */
    public com.google.protobuf.ByteString
        getOptionalPermissionNameFilterBytes() {
      java.lang.Object ref = optionalPermissionNameFilter_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        optionalPermissionNameFilter_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * optional_permission_name_filter is a prefix that is matched against the permission name.
     * </pre>
     *
     * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
     * @param value The optionalPermissionNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalPermissionNameFilter(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      optionalPermissionNameFilter_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_permission_name_filter is a prefix that is matched against the permission name.
     * </pre>
     *
     * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
     * @return This builder for chaining.
     */
    public Builder clearOptionalPermissionNameFilter() {
      optionalPermissionNameFilter_ = getDefaultInstance().getOptionalPermissionNameFilter();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_permission_name_filter is a prefix that is matched against the permission name.
     * </pre>
     *
     * <code>string optional_permission_name_filter = 4 [json_name = "optionalPermissionNameFilter"];</code>
     * @param value The bytes for optionalPermissionNameFilter to set.
     * @return This builder for chaining.
     */
    public Builder setOptionalPermissionNameFilterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      optionalPermissionNameFilter_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:authzed.api.v1.ExpSchemaFilter)
  }

  // @@protoc_insertion_point(class_scope:authzed.api.v1.ExpSchemaFilter)
  private static final com.authzed.api.v1.ExpSchemaFilter DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.authzed.api.v1.ExpSchemaFilter();
  }

  public static com.authzed.api.v1.ExpSchemaFilter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExpSchemaFilter>
      PARSER = new com.google.protobuf.AbstractParser<ExpSchemaFilter>() {
    @java.lang.Override
    public ExpSchemaFilter parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ExpSchemaFilter> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExpSchemaFilter> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.authzed.api.v1.ExpSchemaFilter getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

