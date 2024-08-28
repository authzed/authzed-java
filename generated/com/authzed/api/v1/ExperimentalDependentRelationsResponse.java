// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/experimental_service.proto

package com.authzed.api.v1;

/**
 * Protobuf type {@code authzed.api.v1.ExperimentalDependentRelationsResponse}
 */
public final class ExperimentalDependentRelationsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:authzed.api.v1.ExperimentalDependentRelationsResponse)
    ExperimentalDependentRelationsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExperimentalDependentRelationsResponse.newBuilder() to construct.
  private ExperimentalDependentRelationsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExperimentalDependentRelationsResponse() {
    relations_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExperimentalDependentRelationsResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExperimentalDependentRelationsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExperimentalDependentRelationsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.authzed.api.v1.ExperimentalDependentRelationsResponse.class, com.authzed.api.v1.ExperimentalDependentRelationsResponse.Builder.class);
  }

  public static final int RELATIONS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.authzed.api.v1.ExpRelationReference> relations_;
  /**
   * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
   */
  @java.lang.Override
  public java.util.List<com.authzed.api.v1.ExpRelationReference> getRelationsList() {
    return relations_;
  }
  /**
   * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.authzed.api.v1.ExpRelationReferenceOrBuilder> 
      getRelationsOrBuilderList() {
    return relations_;
  }
  /**
   * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
   */
  @java.lang.Override
  public int getRelationsCount() {
    return relations_.size();
  }
  /**
   * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpRelationReference getRelations(int index) {
    return relations_.get(index);
  }
  /**
   * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpRelationReferenceOrBuilder getRelationsOrBuilder(
      int index) {
    return relations_.get(index);
  }

  public static final int READ_AT_FIELD_NUMBER = 2;
  private com.authzed.api.v1.ZedToken readAt_;
  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
   * @return Whether the readAt field is set.
   */
  @java.lang.Override
  public boolean hasReadAt() {
    return readAt_ != null;
  }
  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
   * @return The readAt.
   */
  @java.lang.Override
  public com.authzed.api.v1.ZedToken getReadAt() {
    return readAt_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : readAt_;
  }
  /**
   * <pre>
   * read_at is the ZedToken at which the schema was read.
   * </pre>
   *
   * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ZedTokenOrBuilder getReadAtOrBuilder() {
    return readAt_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : readAt_;
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
    for (int i = 0; i < relations_.size(); i++) {
      output.writeMessage(1, relations_.get(i));
    }
    if (readAt_ != null) {
      output.writeMessage(2, getReadAt());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < relations_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, relations_.get(i));
    }
    if (readAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getReadAt());
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
    if (!(obj instanceof com.authzed.api.v1.ExperimentalDependentRelationsResponse)) {
      return super.equals(obj);
    }
    com.authzed.api.v1.ExperimentalDependentRelationsResponse other = (com.authzed.api.v1.ExperimentalDependentRelationsResponse) obj;

    if (!getRelationsList()
        .equals(other.getRelationsList())) return false;
    if (hasReadAt() != other.hasReadAt()) return false;
    if (hasReadAt()) {
      if (!getReadAt()
          .equals(other.getReadAt())) return false;
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
    if (getRelationsCount() > 0) {
      hash = (37 * hash) + RELATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getRelationsList().hashCode();
    }
    if (hasReadAt()) {
      hash = (37 * hash) + READ_AT_FIELD_NUMBER;
      hash = (53 * hash) + getReadAt().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse parseFrom(
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
  public static Builder newBuilder(com.authzed.api.v1.ExperimentalDependentRelationsResponse prototype) {
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
   * Protobuf type {@code authzed.api.v1.ExperimentalDependentRelationsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:authzed.api.v1.ExperimentalDependentRelationsResponse)
      com.authzed.api.v1.ExperimentalDependentRelationsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExperimentalDependentRelationsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExperimentalDependentRelationsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.authzed.api.v1.ExperimentalDependentRelationsResponse.class, com.authzed.api.v1.ExperimentalDependentRelationsResponse.Builder.class);
    }

    // Construct using com.authzed.api.v1.ExperimentalDependentRelationsResponse.newBuilder()
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
      if (relationsBuilder_ == null) {
        relations_ = java.util.Collections.emptyList();
      } else {
        relations_ = null;
        relationsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      readAt_ = null;
      if (readAtBuilder_ != null) {
        readAtBuilder_.dispose();
        readAtBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExperimentalDependentRelationsResponse_descriptor;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExperimentalDependentRelationsResponse getDefaultInstanceForType() {
      return com.authzed.api.v1.ExperimentalDependentRelationsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.authzed.api.v1.ExperimentalDependentRelationsResponse build() {
      com.authzed.api.v1.ExperimentalDependentRelationsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExperimentalDependentRelationsResponse buildPartial() {
      com.authzed.api.v1.ExperimentalDependentRelationsResponse result = new com.authzed.api.v1.ExperimentalDependentRelationsResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.authzed.api.v1.ExperimentalDependentRelationsResponse result) {
      if (relationsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          relations_ = java.util.Collections.unmodifiableList(relations_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.relations_ = relations_;
      } else {
        result.relations_ = relationsBuilder_.build();
      }
    }

    private void buildPartial0(com.authzed.api.v1.ExperimentalDependentRelationsResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.readAt_ = readAtBuilder_ == null
            ? readAt_
            : readAtBuilder_.build();
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
      if (other instanceof com.authzed.api.v1.ExperimentalDependentRelationsResponse) {
        return mergeFrom((com.authzed.api.v1.ExperimentalDependentRelationsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.authzed.api.v1.ExperimentalDependentRelationsResponse other) {
      if (other == com.authzed.api.v1.ExperimentalDependentRelationsResponse.getDefaultInstance()) return this;
      if (relationsBuilder_ == null) {
        if (!other.relations_.isEmpty()) {
          if (relations_.isEmpty()) {
            relations_ = other.relations_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRelationsIsMutable();
            relations_.addAll(other.relations_);
          }
          onChanged();
        }
      } else {
        if (!other.relations_.isEmpty()) {
          if (relationsBuilder_.isEmpty()) {
            relationsBuilder_.dispose();
            relationsBuilder_ = null;
            relations_ = other.relations_;
            bitField0_ = (bitField0_ & ~0x00000001);
            relationsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRelationsFieldBuilder() : null;
          } else {
            relationsBuilder_.addAllMessages(other.relations_);
          }
        }
      }
      if (other.hasReadAt()) {
        mergeReadAt(other.getReadAt());
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
              com.authzed.api.v1.ExpRelationReference m =
                  input.readMessage(
                      com.authzed.api.v1.ExpRelationReference.parser(),
                      extensionRegistry);
              if (relationsBuilder_ == null) {
                ensureRelationsIsMutable();
                relations_.add(m);
              } else {
                relationsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getReadAtFieldBuilder().getBuilder(),
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

    private java.util.List<com.authzed.api.v1.ExpRelationReference> relations_ =
      java.util.Collections.emptyList();
    private void ensureRelationsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        relations_ = new java.util.ArrayList<com.authzed.api.v1.ExpRelationReference>(relations_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.authzed.api.v1.ExpRelationReference, com.authzed.api.v1.ExpRelationReference.Builder, com.authzed.api.v1.ExpRelationReferenceOrBuilder> relationsBuilder_;

    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public java.util.List<com.authzed.api.v1.ExpRelationReference> getRelationsList() {
      if (relationsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(relations_);
      } else {
        return relationsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public int getRelationsCount() {
      if (relationsBuilder_ == null) {
        return relations_.size();
      } else {
        return relationsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public com.authzed.api.v1.ExpRelationReference getRelations(int index) {
      if (relationsBuilder_ == null) {
        return relations_.get(index);
      } else {
        return relationsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder setRelations(
        int index, com.authzed.api.v1.ExpRelationReference value) {
      if (relationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRelationsIsMutable();
        relations_.set(index, value);
        onChanged();
      } else {
        relationsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder setRelations(
        int index, com.authzed.api.v1.ExpRelationReference.Builder builderForValue) {
      if (relationsBuilder_ == null) {
        ensureRelationsIsMutable();
        relations_.set(index, builderForValue.build());
        onChanged();
      } else {
        relationsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder addRelations(com.authzed.api.v1.ExpRelationReference value) {
      if (relationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRelationsIsMutable();
        relations_.add(value);
        onChanged();
      } else {
        relationsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder addRelations(
        int index, com.authzed.api.v1.ExpRelationReference value) {
      if (relationsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRelationsIsMutable();
        relations_.add(index, value);
        onChanged();
      } else {
        relationsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder addRelations(
        com.authzed.api.v1.ExpRelationReference.Builder builderForValue) {
      if (relationsBuilder_ == null) {
        ensureRelationsIsMutable();
        relations_.add(builderForValue.build());
        onChanged();
      } else {
        relationsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder addRelations(
        int index, com.authzed.api.v1.ExpRelationReference.Builder builderForValue) {
      if (relationsBuilder_ == null) {
        ensureRelationsIsMutable();
        relations_.add(index, builderForValue.build());
        onChanged();
      } else {
        relationsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder addAllRelations(
        java.lang.Iterable<? extends com.authzed.api.v1.ExpRelationReference> values) {
      if (relationsBuilder_ == null) {
        ensureRelationsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, relations_);
        onChanged();
      } else {
        relationsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder clearRelations() {
      if (relationsBuilder_ == null) {
        relations_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        relationsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public Builder removeRelations(int index) {
      if (relationsBuilder_ == null) {
        ensureRelationsIsMutable();
        relations_.remove(index);
        onChanged();
      } else {
        relationsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public com.authzed.api.v1.ExpRelationReference.Builder getRelationsBuilder(
        int index) {
      return getRelationsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public com.authzed.api.v1.ExpRelationReferenceOrBuilder getRelationsOrBuilder(
        int index) {
      if (relationsBuilder_ == null) {
        return relations_.get(index);  } else {
        return relationsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public java.util.List<? extends com.authzed.api.v1.ExpRelationReferenceOrBuilder> 
         getRelationsOrBuilderList() {
      if (relationsBuilder_ != null) {
        return relationsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(relations_);
      }
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public com.authzed.api.v1.ExpRelationReference.Builder addRelationsBuilder() {
      return getRelationsFieldBuilder().addBuilder(
          com.authzed.api.v1.ExpRelationReference.getDefaultInstance());
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public com.authzed.api.v1.ExpRelationReference.Builder addRelationsBuilder(
        int index) {
      return getRelationsFieldBuilder().addBuilder(
          index, com.authzed.api.v1.ExpRelationReference.getDefaultInstance());
    }
    /**
     * <code>repeated .authzed.api.v1.ExpRelationReference relations = 1 [json_name = "relations"];</code>
     */
    public java.util.List<com.authzed.api.v1.ExpRelationReference.Builder> 
         getRelationsBuilderList() {
      return getRelationsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.authzed.api.v1.ExpRelationReference, com.authzed.api.v1.ExpRelationReference.Builder, com.authzed.api.v1.ExpRelationReferenceOrBuilder> 
        getRelationsFieldBuilder() {
      if (relationsBuilder_ == null) {
        relationsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.authzed.api.v1.ExpRelationReference, com.authzed.api.v1.ExpRelationReference.Builder, com.authzed.api.v1.ExpRelationReferenceOrBuilder>(
                relations_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        relations_ = null;
      }
      return relationsBuilder_;
    }

    private com.authzed.api.v1.ZedToken readAt_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder> readAtBuilder_;
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     * @return Whether the readAt field is set.
     */
    public boolean hasReadAt() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     * @return The readAt.
     */
    public com.authzed.api.v1.ZedToken getReadAt() {
      if (readAtBuilder_ == null) {
        return readAt_ == null ? com.authzed.api.v1.ZedToken.getDefaultInstance() : readAt_;
      } else {
        return readAtBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public Builder setReadAt(com.authzed.api.v1.ZedToken value) {
      if (readAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        readAt_ = value;
      } else {
        readAtBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public Builder setReadAt(
        com.authzed.api.v1.ZedToken.Builder builderForValue) {
      if (readAtBuilder_ == null) {
        readAt_ = builderForValue.build();
      } else {
        readAtBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public Builder mergeReadAt(com.authzed.api.v1.ZedToken value) {
      if (readAtBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          readAt_ != null &&
          readAt_ != com.authzed.api.v1.ZedToken.getDefaultInstance()) {
          getReadAtBuilder().mergeFrom(value);
        } else {
          readAt_ = value;
        }
      } else {
        readAtBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public Builder clearReadAt() {
      bitField0_ = (bitField0_ & ~0x00000002);
      readAt_ = null;
      if (readAtBuilder_ != null) {
        readAtBuilder_.dispose();
        readAtBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public com.authzed.api.v1.ZedToken.Builder getReadAtBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getReadAtFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    public com.authzed.api.v1.ZedTokenOrBuilder getReadAtOrBuilder() {
      if (readAtBuilder_ != null) {
        return readAtBuilder_.getMessageOrBuilder();
      } else {
        return readAt_ == null ?
            com.authzed.api.v1.ZedToken.getDefaultInstance() : readAt_;
      }
    }
    /**
     * <pre>
     * read_at is the ZedToken at which the schema was read.
     * </pre>
     *
     * <code>.authzed.api.v1.ZedToken read_at = 2 [json_name = "readAt"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder> 
        getReadAtFieldBuilder() {
      if (readAtBuilder_ == null) {
        readAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.authzed.api.v1.ZedToken, com.authzed.api.v1.ZedToken.Builder, com.authzed.api.v1.ZedTokenOrBuilder>(
                getReadAt(),
                getParentForChildren(),
                isClean());
        readAt_ = null;
      }
      return readAtBuilder_;
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


    // @@protoc_insertion_point(builder_scope:authzed.api.v1.ExperimentalDependentRelationsResponse)
  }

  // @@protoc_insertion_point(class_scope:authzed.api.v1.ExperimentalDependentRelationsResponse)
  private static final com.authzed.api.v1.ExperimentalDependentRelationsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.authzed.api.v1.ExperimentalDependentRelationsResponse();
  }

  public static com.authzed.api.v1.ExperimentalDependentRelationsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExperimentalDependentRelationsResponse>
      PARSER = new com.google.protobuf.AbstractParser<ExperimentalDependentRelationsResponse>() {
    @java.lang.Override
    public ExperimentalDependentRelationsResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<ExperimentalDependentRelationsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExperimentalDependentRelationsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.authzed.api.v1.ExperimentalDependentRelationsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

