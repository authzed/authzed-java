// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: authzed/api/v1/experimental_service.proto

package com.authzed.api.v1;

/**
 * Protobuf type {@code authzed.api.v1.ExpRelationSubjectTypeChange}
 */
public final class ExpRelationSubjectTypeChange extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:authzed.api.v1.ExpRelationSubjectTypeChange)
    ExpRelationSubjectTypeChangeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExpRelationSubjectTypeChange.newBuilder() to construct.
  private ExpRelationSubjectTypeChange(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExpRelationSubjectTypeChange() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExpRelationSubjectTypeChange();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpRelationSubjectTypeChange_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpRelationSubjectTypeChange_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.authzed.api.v1.ExpRelationSubjectTypeChange.class, com.authzed.api.v1.ExpRelationSubjectTypeChange.Builder.class);
  }

  public static final int RELATION_FIELD_NUMBER = 1;
  private com.authzed.api.v1.ExpRelation relation_;
  /**
   * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
   * @return Whether the relation field is set.
   */
  @java.lang.Override
  public boolean hasRelation() {
    return relation_ != null;
  }
  /**
   * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
   * @return The relation.
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpRelation getRelation() {
    return relation_ == null ? com.authzed.api.v1.ExpRelation.getDefaultInstance() : relation_;
  }
  /**
   * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpRelationOrBuilder getRelationOrBuilder() {
    return relation_ == null ? com.authzed.api.v1.ExpRelation.getDefaultInstance() : relation_;
  }

  public static final int CHANGED_SUBJECT_TYPE_FIELD_NUMBER = 2;
  private com.authzed.api.v1.ExpTypeReference changedSubjectType_;
  /**
   * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
   * @return Whether the changedSubjectType field is set.
   */
  @java.lang.Override
  public boolean hasChangedSubjectType() {
    return changedSubjectType_ != null;
  }
  /**
   * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
   * @return The changedSubjectType.
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpTypeReference getChangedSubjectType() {
    return changedSubjectType_ == null ? com.authzed.api.v1.ExpTypeReference.getDefaultInstance() : changedSubjectType_;
  }
  /**
   * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
   */
  @java.lang.Override
  public com.authzed.api.v1.ExpTypeReferenceOrBuilder getChangedSubjectTypeOrBuilder() {
    return changedSubjectType_ == null ? com.authzed.api.v1.ExpTypeReference.getDefaultInstance() : changedSubjectType_;
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
    if (relation_ != null) {
      output.writeMessage(1, getRelation());
    }
    if (changedSubjectType_ != null) {
      output.writeMessage(2, getChangedSubjectType());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (relation_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getRelation());
    }
    if (changedSubjectType_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getChangedSubjectType());
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
    if (!(obj instanceof com.authzed.api.v1.ExpRelationSubjectTypeChange)) {
      return super.equals(obj);
    }
    com.authzed.api.v1.ExpRelationSubjectTypeChange other = (com.authzed.api.v1.ExpRelationSubjectTypeChange) obj;

    if (hasRelation() != other.hasRelation()) return false;
    if (hasRelation()) {
      if (!getRelation()
          .equals(other.getRelation())) return false;
    }
    if (hasChangedSubjectType() != other.hasChangedSubjectType()) return false;
    if (hasChangedSubjectType()) {
      if (!getChangedSubjectType()
          .equals(other.getChangedSubjectType())) return false;
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
    if (hasRelation()) {
      hash = (37 * hash) + RELATION_FIELD_NUMBER;
      hash = (53 * hash) + getRelation().hashCode();
    }
    if (hasChangedSubjectType()) {
      hash = (37 * hash) + CHANGED_SUBJECT_TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getChangedSubjectType().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.authzed.api.v1.ExpRelationSubjectTypeChange parseFrom(
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
  public static Builder newBuilder(com.authzed.api.v1.ExpRelationSubjectTypeChange prototype) {
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
   * Protobuf type {@code authzed.api.v1.ExpRelationSubjectTypeChange}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:authzed.api.v1.ExpRelationSubjectTypeChange)
      com.authzed.api.v1.ExpRelationSubjectTypeChangeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpRelationSubjectTypeChange_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpRelationSubjectTypeChange_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.authzed.api.v1.ExpRelationSubjectTypeChange.class, com.authzed.api.v1.ExpRelationSubjectTypeChange.Builder.class);
    }

    // Construct using com.authzed.api.v1.ExpRelationSubjectTypeChange.newBuilder()
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
      relation_ = null;
      if (relationBuilder_ != null) {
        relationBuilder_.dispose();
        relationBuilder_ = null;
      }
      changedSubjectType_ = null;
      if (changedSubjectTypeBuilder_ != null) {
        changedSubjectTypeBuilder_.dispose();
        changedSubjectTypeBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.internal_static_authzed_api_v1_ExpRelationSubjectTypeChange_descriptor;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpRelationSubjectTypeChange getDefaultInstanceForType() {
      return com.authzed.api.v1.ExpRelationSubjectTypeChange.getDefaultInstance();
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpRelationSubjectTypeChange build() {
      com.authzed.api.v1.ExpRelationSubjectTypeChange result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.authzed.api.v1.ExpRelationSubjectTypeChange buildPartial() {
      com.authzed.api.v1.ExpRelationSubjectTypeChange result = new com.authzed.api.v1.ExpRelationSubjectTypeChange(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.authzed.api.v1.ExpRelationSubjectTypeChange result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.relation_ = relationBuilder_ == null
            ? relation_
            : relationBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.changedSubjectType_ = changedSubjectTypeBuilder_ == null
            ? changedSubjectType_
            : changedSubjectTypeBuilder_.build();
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
      if (other instanceof com.authzed.api.v1.ExpRelationSubjectTypeChange) {
        return mergeFrom((com.authzed.api.v1.ExpRelationSubjectTypeChange)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.authzed.api.v1.ExpRelationSubjectTypeChange other) {
      if (other == com.authzed.api.v1.ExpRelationSubjectTypeChange.getDefaultInstance()) return this;
      if (other.hasRelation()) {
        mergeRelation(other.getRelation());
      }
      if (other.hasChangedSubjectType()) {
        mergeChangedSubjectType(other.getChangedSubjectType());
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
                  getRelationFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getChangedSubjectTypeFieldBuilder().getBuilder(),
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

    private com.authzed.api.v1.ExpRelation relation_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ExpRelation, com.authzed.api.v1.ExpRelation.Builder, com.authzed.api.v1.ExpRelationOrBuilder> relationBuilder_;
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     * @return Whether the relation field is set.
     */
    public boolean hasRelation() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     * @return The relation.
     */
    public com.authzed.api.v1.ExpRelation getRelation() {
      if (relationBuilder_ == null) {
        return relation_ == null ? com.authzed.api.v1.ExpRelation.getDefaultInstance() : relation_;
      } else {
        return relationBuilder_.getMessage();
      }
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public Builder setRelation(com.authzed.api.v1.ExpRelation value) {
      if (relationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        relation_ = value;
      } else {
        relationBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public Builder setRelation(
        com.authzed.api.v1.ExpRelation.Builder builderForValue) {
      if (relationBuilder_ == null) {
        relation_ = builderForValue.build();
      } else {
        relationBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public Builder mergeRelation(com.authzed.api.v1.ExpRelation value) {
      if (relationBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          relation_ != null &&
          relation_ != com.authzed.api.v1.ExpRelation.getDefaultInstance()) {
          getRelationBuilder().mergeFrom(value);
        } else {
          relation_ = value;
        }
      } else {
        relationBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public Builder clearRelation() {
      bitField0_ = (bitField0_ & ~0x00000001);
      relation_ = null;
      if (relationBuilder_ != null) {
        relationBuilder_.dispose();
        relationBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public com.authzed.api.v1.ExpRelation.Builder getRelationBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getRelationFieldBuilder().getBuilder();
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    public com.authzed.api.v1.ExpRelationOrBuilder getRelationOrBuilder() {
      if (relationBuilder_ != null) {
        return relationBuilder_.getMessageOrBuilder();
      } else {
        return relation_ == null ?
            com.authzed.api.v1.ExpRelation.getDefaultInstance() : relation_;
      }
    }
    /**
     * <code>.authzed.api.v1.ExpRelation relation = 1 [json_name = "relation"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ExpRelation, com.authzed.api.v1.ExpRelation.Builder, com.authzed.api.v1.ExpRelationOrBuilder> 
        getRelationFieldBuilder() {
      if (relationBuilder_ == null) {
        relationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.authzed.api.v1.ExpRelation, com.authzed.api.v1.ExpRelation.Builder, com.authzed.api.v1.ExpRelationOrBuilder>(
                getRelation(),
                getParentForChildren(),
                isClean());
        relation_ = null;
      }
      return relationBuilder_;
    }

    private com.authzed.api.v1.ExpTypeReference changedSubjectType_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ExpTypeReference, com.authzed.api.v1.ExpTypeReference.Builder, com.authzed.api.v1.ExpTypeReferenceOrBuilder> changedSubjectTypeBuilder_;
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     * @return Whether the changedSubjectType field is set.
     */
    public boolean hasChangedSubjectType() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     * @return The changedSubjectType.
     */
    public com.authzed.api.v1.ExpTypeReference getChangedSubjectType() {
      if (changedSubjectTypeBuilder_ == null) {
        return changedSubjectType_ == null ? com.authzed.api.v1.ExpTypeReference.getDefaultInstance() : changedSubjectType_;
      } else {
        return changedSubjectTypeBuilder_.getMessage();
      }
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public Builder setChangedSubjectType(com.authzed.api.v1.ExpTypeReference value) {
      if (changedSubjectTypeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        changedSubjectType_ = value;
      } else {
        changedSubjectTypeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public Builder setChangedSubjectType(
        com.authzed.api.v1.ExpTypeReference.Builder builderForValue) {
      if (changedSubjectTypeBuilder_ == null) {
        changedSubjectType_ = builderForValue.build();
      } else {
        changedSubjectTypeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public Builder mergeChangedSubjectType(com.authzed.api.v1.ExpTypeReference value) {
      if (changedSubjectTypeBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          changedSubjectType_ != null &&
          changedSubjectType_ != com.authzed.api.v1.ExpTypeReference.getDefaultInstance()) {
          getChangedSubjectTypeBuilder().mergeFrom(value);
        } else {
          changedSubjectType_ = value;
        }
      } else {
        changedSubjectTypeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public Builder clearChangedSubjectType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      changedSubjectType_ = null;
      if (changedSubjectTypeBuilder_ != null) {
        changedSubjectTypeBuilder_.dispose();
        changedSubjectTypeBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public com.authzed.api.v1.ExpTypeReference.Builder getChangedSubjectTypeBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getChangedSubjectTypeFieldBuilder().getBuilder();
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    public com.authzed.api.v1.ExpTypeReferenceOrBuilder getChangedSubjectTypeOrBuilder() {
      if (changedSubjectTypeBuilder_ != null) {
        return changedSubjectTypeBuilder_.getMessageOrBuilder();
      } else {
        return changedSubjectType_ == null ?
            com.authzed.api.v1.ExpTypeReference.getDefaultInstance() : changedSubjectType_;
      }
    }
    /**
     * <code>.authzed.api.v1.ExpTypeReference changed_subject_type = 2 [json_name = "changedSubjectType"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.authzed.api.v1.ExpTypeReference, com.authzed.api.v1.ExpTypeReference.Builder, com.authzed.api.v1.ExpTypeReferenceOrBuilder> 
        getChangedSubjectTypeFieldBuilder() {
      if (changedSubjectTypeBuilder_ == null) {
        changedSubjectTypeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.authzed.api.v1.ExpTypeReference, com.authzed.api.v1.ExpTypeReference.Builder, com.authzed.api.v1.ExpTypeReferenceOrBuilder>(
                getChangedSubjectType(),
                getParentForChildren(),
                isClean());
        changedSubjectType_ = null;
      }
      return changedSubjectTypeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:authzed.api.v1.ExpRelationSubjectTypeChange)
  }

  // @@protoc_insertion_point(class_scope:authzed.api.v1.ExpRelationSubjectTypeChange)
  private static final com.authzed.api.v1.ExpRelationSubjectTypeChange DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.authzed.api.v1.ExpRelationSubjectTypeChange();
  }

  public static com.authzed.api.v1.ExpRelationSubjectTypeChange getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExpRelationSubjectTypeChange>
      PARSER = new com.google.protobuf.AbstractParser<ExpRelationSubjectTypeChange>() {
    @java.lang.Override
    public ExpRelationSubjectTypeChange parsePartialFrom(
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

  public static com.google.protobuf.Parser<ExpRelationSubjectTypeChange> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExpRelationSubjectTypeChange> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.authzed.api.v1.ExpRelationSubjectTypeChange getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

