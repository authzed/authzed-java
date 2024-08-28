// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/materialize/v0/watchpermissionsets.proto

package com.authzed.api.materialize.v0;

/**
 * Protobuf type {@code authzed.api.materialize.v0.WatchPermissionSetsRequest}
 */
public final class WatchPermissionSetsRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:authzed.api.materialize.v0.WatchPermissionSetsRequest)
    WatchPermissionSetsRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WatchPermissionSetsRequest.newBuilder() to construct.
  private WatchPermissionSetsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WatchPermissionSetsRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WatchPermissionSetsRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.authzed.api.materialize.v0.Watchpermissionsets.internal_static_authzed_api_materialize_v0_WatchPermissionSetsRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.authzed.api.materialize.v0.Watchpermissionsets.internal_static_authzed_api_materialize_v0_WatchPermissionSetsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.authzed.api.materialize.v0.WatchPermissionSetsRequest.class, com.authzed.api.materialize.v0.WatchPermissionSetsRequest.Builder.class);
  }

  public static final int OPTIONAL_STARTING_AFTER_FIELD_NUMBER = 1;
  private com.authzed.api.v1.ZedToken optionalStartingAfter_;
  /**
   * <pre>
   * optional_starting_after is used to specify the SpiceDB revision to start watching from.
   * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
   * @return Whether the optionalStartingAfter field is set.
   */
  @java.lang.Override
  public boolean hasOptionalStartingAfter() {
    return optionalStartingAfter_ != null;
  }
  /**
   * <pre>
   * optional_starting_after is used to specify the SpiceDB revision to start watching from.
   * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
   * @return The optionalStartingAfter.
   */
  @java.lang.Override
  public com.authzed.api.v1.ZedToken getOptionalStartingAfter() {
    return optionalStartingAfter_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : optionalStartingAfter_;
  }
  /**
   * <pre>
   * optional_starting_after is used to specify the SpiceDB revision to start watching from.
   * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ZedTokenOrBuilder getOptionalStartingAfterOrBuilder() {
    return optionalStartingAfter_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : optionalStartingAfter_;
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
    if (optionalStartingAfter_ != null) {
      output.writeMessage(1, getOptionalStartingAfter());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (optionalStartingAfter_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getOptionalStartingAfter());
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
    if (!(obj instanceof com.authzed.api.materialize.v0.WatchPermissionSetsRequest)) {
      return super.equals(obj);
    }
    com.authzed.api.materialize.v0.WatchPermissionSetsRequest other = (com.authzed.api.materialize.v0.WatchPermissionSetsRequest) obj;

    if (hasOptionalStartingAfter() != other.hasOptionalStartingAfter()) return false;
    if (hasOptionalStartingAfter()) {
      if (!getOptionalStartingAfter()
          .equals(other.getOptionalStartingAfter())) return false;
    }
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
    if (hasOptionalStartingAfter()) {
      hash = (37 * hash) + OPTIONAL_STARTING_AFTER_FIELD_NUMBER;
      hash = (53 * hash) + getOptionalStartingAfter().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest parseFrom(
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
  public static Builder newBuilder(com.authzed.api.materialize.v0.WatchPermissionSetsRequest prototype) {
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
   * Protobuf type {@code authzed.api.materialize.v0.WatchPermissionSetsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:authzed.api.materialize.v0.WatchPermissionSetsRequest)
      com.authzed.api.materialize.v0.WatchPermissionSetsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.authzed.api.materialize.v0.Watchpermissionsets.internal_static_authzed_api_materialize_v0_WatchPermissionSetsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.authzed.api.materialize.v0.Watchpermissionsets.internal_static_authzed_api_materialize_v0_WatchPermissionSetsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.authzed.api.materialize.v0.WatchPermissionSetsRequest.class, com.authzed.api.materialize.v0.WatchPermissionSetsRequest.Builder.class);
    }

    // Construct using com.authzed.api.materialize.v0.WatchPermissionSetsRequest.newBuilder()
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
      optionalStartingAfter_ = null;
      if (optionalStartingAfterBuilder_ != null) {
        optionalStartingAfterBuilder_.dispose();
        optionalStartingAfterBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.authzed.api.materialize.v0.Watchpermissionsets.internal_static_authzed_api_materialize_v0_WatchPermissionSetsRequest_descriptor;
    }

    @java.lang.Override
    public com.authzed.api.materialize.v0.WatchPermissionSetsRequest getDefaultInstanceForType() {
      return com.authzed.api.materialize.v0.WatchPermissionSetsRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.authzed.api.materialize.v0.WatchPermissionSetsRequest build() {
      com.authzed.api.materialize.v0.WatchPermissionSetsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.authzed.api.materialize.v0.WatchPermissionSetsRequest buildPartial() {
      com.authzed.api.materialize.v0.WatchPermissionSetsRequest result = new com.authzed.api.materialize.v0.WatchPermissionSetsRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.authzed.api.materialize.v0.WatchPermissionSetsRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.optionalStartingAfter_ = optionalStartingAfterBuilder_ == null
            ? optionalStartingAfter_
            : optionalStartingAfterBuilder_.build();
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
      if (other instanceof com.authzed.api.materialize.v0.WatchPermissionSetsRequest) {
        return mergeFrom((com.authzed.api.materialize.v0.WatchPermissionSetsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.authzed.api.materialize.v0.WatchPermissionSetsRequest other) {
      if (other == com.authzed.api.materialize.v0.WatchPermissionSetsRequest.getDefaultInstance()) return this;
      if (other.hasOptionalStartingAfter()) {
        mergeOptionalStartingAfter(other.getOptionalStartingAfter());
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
              input.readMessage(
                  getOptionalStartingAfterFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
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

    private com.authzed.api.v1.ZedToken optionalStartingAfter_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder> optionalStartingAfterBuilder_;
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     * @return Whether the optionalStartingAfter field is set.
     */
    public boolean hasOptionalStartingAfter() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     * @return The optionalStartingAfter.
     */
    public com.authzed.api.v1.ZedToken getOptionalStartingAfter() {
      if (optionalStartingAfterBuilder_ == null) {
        return optionalStartingAfter_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : optionalStartingAfter_;
      } else {
        return optionalStartingAfterBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public Builder setOptionalStartingAfter(com.authzed.api.v1.ZedToken value) {
      if (optionalStartingAfterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        optionalStartingAfter_ = value;
      } else {
        optionalStartingAfterBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public Builder setOptionalStartingAfter(
        com.authzed.api.v1.ZedToken.Builder builderForValue) {
      if (optionalStartingAfterBuilder_ == null) {
        optionalStartingAfter_ = builderForValue.build();
      } else {
        optionalStartingAfterBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public Builder mergeOptionalStartingAfter(com.authzed.api.v1.ZedToken value) {
      if (optionalStartingAfterBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          optionalStartingAfter_ != null &&
          optionalStartingAfter_ != com.authzed.api.v1.ZedToken.getDefaultInstance()) {
          getOptionalStartingAfterBuilder().mergeFrom(value);
        } else {
          optionalStartingAfter_ = value;
        }
      } else {
        optionalStartingAfterBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public Builder clearOptionalStartingAfter() {
      bitField0_ = (bitField0_ & ~0x00000001);
      optionalStartingAfter_ = null;
      if (optionalStartingAfterBuilder_ != null) {
        optionalStartingAfterBuilder_.dispose();
        optionalStartingAfterBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public com.authzed.api.v1.ZedToken.Builder getOptionalStartingAfterBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getOptionalStartingAfterFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    public com.authzed.api.v1.ZedTokenOrBuilder getOptionalStartingAfterOrBuilder() {
      if (optionalStartingAfterBuilder_ != null) {
        return optionalStartingAfterBuilder_.getMessageOrBuilder();
      } else {
        return optionalStartingAfter_ == null ?
            com.authzed.api.v1.ZedToken.getDefaultInstance() : optionalStartingAfter_;
      }
    }
    /**
     * <pre>
     * optional_starting_after is used to specify the SpiceDB revision to start watching from.
     * If not specified, the watch will start from the current SpiceDB revision time of the request ("head revision").
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken optional_starting_after = 1 [json_name = "optionalStartingAfter"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder> 
        getOptionalStartingAfterFieldBuilder() {
      if (optionalStartingAfterBuilder_ == null) {
        optionalStartingAfterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder>(
                getOptionalStartingAfter(),
                getParentForChildren(),
                isClean());
        optionalStartingAfter_ = null;
      }
      return optionalStartingAfterBuilder_;
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


    // @@protoc_insertion_point(builder_scope:authzed.api.materialize.v0.WatchPermissionSetsRequest)
  }

  // @@protoc_insertion_point(class_scope:authzed.api.materialize.v0.WatchPermissionSetsRequest)
  private static final com.authzed.api.materialize.v0.WatchPermissionSetsRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.authzed.api.materialize.v0.WatchPermissionSetsRequest();
  }

  public static com.authzed.api.materialize.v0.WatchPermissionSetsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WatchPermissionSetsRequest>
      PARSER = new com.google.protobuf.AbstractParser<WatchPermissionSetsRequest>() {
    @java.lang.Override
    public WatchPermissionSetsRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<WatchPermissionSetsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WatchPermissionSetsRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.authzed.api.materialize.v0.WatchPermissionSetsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

