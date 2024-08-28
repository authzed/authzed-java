// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/core.proto

package com.authzed.api.v1;

/**
 * <pre>
 * ContextualizedCaveat represents a reference to a caveat to be used by caveated relationships.
 * The context consists of key-value pairs that will be injected at evaluation time.
 * The keys must match the arguments defined on the caveat in the schema.
 * </pre>
 *
 * Protobuf type {@code authzed.api.v1.ContextualizedCaveat}
 */
public final class ContextualizedCaveat extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:authzed.api.v1.ContextualizedCaveat)
    ContextualizedCaveatOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ContextualizedCaveat.newBuilder() to construct.
  private ContextualizedCaveat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ContextualizedCaveat() {
    caveatName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ContextualizedCaveat();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.authzed.api.v1.Core.internal_static_authzed_api_v1_ContextualizedCaveat_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.authzed.api.v1.Core.internal_static_authzed_api_v1_ContextualizedCaveat_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.authzed.api.v1.ContextualizedCaveat.class, com.authzed.api.v1.ContextualizedCaveat.Builder.class);
  }

  public static final int CAVEAT_NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object caveatName_ = "";
  /**
   * <pre>
   * caveat_name is the name of the caveat expression to use, as defined in the schema
   * </pre>
   *
   * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
   * @return The caveatName.
   */
  @java.lang.Override
  public java.lang.String getCaveatName() {
    java.lang.Object ref = caveatName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      caveatName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * caveat_name is the name of the caveat expression to use, as defined in the schema
   * </pre>
   *
   * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
   * @return The bytes for caveatName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCaveatNameBytes() {
    java.lang.Object ref = caveatName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      caveatName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTEXT_FIELD_NUMBER = 2;
  private com.google.protobuf.Struct context_;
  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   * @return Whether the context field is set.
   */
  @java.lang.Override
  public boolean hasContext() {
    return context_ != null;
  }
  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   * @return The context.
   */
  @java.lang.Override
  public com.google.protobuf.Struct getContext() {
    return context_ == null ? com.google.protobuf.Struct.getDefaultInstance() : context_;
  }
  /**
   * <pre>
   * context consists of any named values that are defined at write time for the caveat expression
   * </pre>
   *
   * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
   */
  @java.lang.Override
  public com.google.protobuf.StructOrBuilder getContextOrBuilder() {
    return context_ == null ? com.google.protobuf.Struct.getDefaultInstance() : context_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(caveatName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, caveatName_);
    }
    if (context_ != null) {
      output.writeMessage(2, getContext());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(caveatName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, caveatName_);
    }
    if (context_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getContext());
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
    if (!(obj instanceof com.authzed.api.v1.ContextualizedCaveat)) {
      return super.equals(obj);
    }
    com.authzed.api.v1.ContextualizedCaveat other = (com.authzed.api.v1.ContextualizedCaveat) obj;

    if (!getCaveatName()
        .equals(other.getCaveatName())) return false;
    if (hasContext() != other.hasContext()) return false;
    if (hasContext()) {
      if (!getContext()
          .equals(other.getContext())) return false;
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
    hash = (37 * hash) + CAVEAT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getCaveatName().hashCode();
    if (hasContext()) {
      hash = (37 * hash) + CONTEXT_FIELD_NUMBER;
      hash = (53 * hash) + getContext().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ContextualizedCaveat parseFrom(
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
  public static Builder newBuilder(com.authzed.api.v1.ContextualizedCaveat prototype) {
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
   * ContextualizedCaveat represents a reference to a caveat to be used by caveated relationships.
   * The context consists of key-value pairs that will be injected at evaluation time.
   * The keys must match the arguments defined on the caveat in the schema.
   * </pre>
   *
   * Protobuf type {@code authzed.api.v1.ContextualizedCaveat}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:authzed.api.v1.ContextualizedCaveat)
      com.authzed.api.v1.ContextualizedCaveatOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.authzed.api.v1.Core.internal_static_authzed_api_v1_ContextualizedCaveat_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.authzed.api.v1.Core.internal_static_authzed_api_v1_ContextualizedCaveat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.authzed.api.v1.ContextualizedCaveat.class, com.authzed.api.v1.ContextualizedCaveat.Builder.class);
    }

    // Construct using com.authzed.api.v1.ContextualizedCaveat.newBuilder()
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
      caveatName_ = "";
      context_ = null;
      if (contextBuilder_ != null) {
        contextBuilder_.dispose();
        contextBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.authzed.api.v1.Core.internal_static_authzed_api_v1_ContextualizedCaveat_descriptor;
    }

    @java.lang.Override
    public com.authzed.api.v1.ContextualizedCaveat getDefaultInstanceForType() {
      return com.authzed.api.v1.ContextualizedCaveat.getDefaultInstance();
    }

    @java.lang.Override
    public com.authzed.api.v1.ContextualizedCaveat build() {
      com.authzed.api.v1.ContextualizedCaveat result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.authzed.api.v1.ContextualizedCaveat buildPartial() {
      com.authzed.api.v1.ContextualizedCaveat result = new com.authzed.api.v1.ContextualizedCaveat(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.authzed.api.v1.ContextualizedCaveat result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.caveatName_ = caveatName_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.context_ = contextBuilder_ == null
            ? context_
            : contextBuilder_.build();
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
      if (other instanceof com.authzed.api.v1.ContextualizedCaveat) {
        return mergeFrom((com.authzed.api.v1.ContextualizedCaveat)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.authzed.api.v1.ContextualizedCaveat other) {
      if (other == com.authzed.api.v1.ContextualizedCaveat.getDefaultInstance()) return this;
      if (!other.getCaveatName().isEmpty()) {
        caveatName_ = other.caveatName_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasContext()) {
        mergeContext(other.getContext());
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
              caveatName_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getContextFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private java.lang.Object caveatName_ = "";
    /**
     * <pre>
     * caveat_name is the name of the caveat expression to use, as defined in the schema
     * </pre>
     *
     * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
     * @return The caveatName.
     */
    public java.lang.String getCaveatName() {
      java.lang.Object ref = caveatName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        caveatName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * caveat_name is the name of the caveat expression to use, as defined in the schema
     * </pre>
     *
     * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
     * @return The bytes for caveatName.
     */
    public com.google.protobuf.ByteString
        getCaveatNameBytes() {
      java.lang.Object ref = caveatName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        caveatName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * caveat_name is the name of the caveat expression to use, as defined in the schema
     * </pre>
     *
     * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
     * @param value The caveatName to set.
     * @return This builder for chaining.
     */
    public Builder setCaveatName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      caveatName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * caveat_name is the name of the caveat expression to use, as defined in the schema
     * </pre>
     *
     * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
     * @return This builder for chaining.
     */
    public Builder clearCaveatName() {
      caveatName_ = getDefaultInstance().getCaveatName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * caveat_name is the name of the caveat expression to use, as defined in the schema
     * </pre>
     *
     * <code>string caveat_name = 1 [json_name = "caveatName", (.validate.rules) = { ... }</code>
     * @param value The bytes for caveatName to set.
     * @return This builder for chaining.
     */
    public Builder setCaveatNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      caveatName_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.google.protobuf.Struct context_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> contextBuilder_;
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     * @return Whether the context field is set.
     */
    public boolean hasContext() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     * @return The context.
     */
    public com.google.protobuf.Struct getContext() {
      if (contextBuilder_ == null) {
        return context_ == null ? com.google.protobuf.Struct.getDefaultInstance() : context_;
      } else {
        return contextBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public Builder setContext(com.google.protobuf.Struct value) {
      if (contextBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        context_ = value;
      } else {
        contextBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public Builder setContext(
        com.google.protobuf.Struct.Builder builderForValue) {
      if (contextBuilder_ == null) {
        context_ = builderForValue.build();
      } else {
        contextBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public Builder mergeContext(com.google.protobuf.Struct value) {
      if (contextBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          context_ != null &&
          context_ != com.google.protobuf.Struct.getDefaultInstance()) {
          getContextBuilder().mergeFrom(value);
        } else {
          context_ = value;
        }
      } else {
        contextBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public Builder clearContext() {
      bitField0_ = (bitField0_ & ~0x00000002);
      context_ = null;
      if (contextBuilder_ != null) {
        contextBuilder_.dispose();
        contextBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public com.google.protobuf.Struct.Builder getContextBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getContextFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    public com.google.protobuf.StructOrBuilder getContextOrBuilder() {
      if (contextBuilder_ != null) {
        return contextBuilder_.getMessageOrBuilder();
      } else {
        return context_ == null ?
            com.google.protobuf.Struct.getDefaultInstance() : context_;
      }
    }
    /**
     * <pre>
     * context consists of any named values that are defined at write time for the caveat expression
     * </pre>
     *
     * <code>.google.protobuf.Struct context = 2 [json_name = "context", (.validate.rules) = { ... }</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> 
        getContextFieldBuilder() {
      if (contextBuilder_ == null) {
        contextBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder>(
                getContext(),
                getParentForChildren(),
                isClean());
        context_ = null;
      }
      return contextBuilder_;
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


    // @@protoc_insertion_point(builder_scope:authzed.api.v1.ContextualizedCaveat)
  }

  // @@protoc_insertion_point(class_scope:authzed.api.v1.ContextualizedCaveat)
  private static final com.authzed.api.v1.ContextualizedCaveat DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.authzed.api.v1.ContextualizedCaveat();
  }

  public static com.authzed.api.v1.ContextualizedCaveat getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ContextualizedCaveat>
      PARSER = new com.google.protobuf.AbstractParser<ContextualizedCaveat>() {
    @java.lang.Override
    public ContextualizedCaveat parsePartialFrom(
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

  public static com.google.protobuf.Parser<ContextualizedCaveat> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ContextualizedCaveat> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.authzed.api.v1.ContextualizedCaveat getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

