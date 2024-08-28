package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ExperimentalService exposes a number of APIs that are currently being
 * prototyped and tested for future inclusion in the stable API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/v1/experimental_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExperimentalServiceGrpc {

  private ExperimentalServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.v1.ExperimentalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.BulkImportRelationshipsRequest,
      com.authzed.api.v1.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkImportRelationships",
      requestType = com.authzed.api.v1.BulkImportRelationshipsRequest.class,
      responseType = com.authzed.api.v1.BulkImportRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.BulkImportRelationshipsRequest,
      com.authzed.api.v1.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.BulkImportRelationshipsRequest, com.authzed.api.v1.BulkImportRelationshipsResponse> getBulkImportRelationshipsMethod;
    if ((getBulkImportRelationshipsMethod = ExperimentalServiceGrpc.getBulkImportRelationshipsMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getBulkImportRelationshipsMethod = ExperimentalServiceGrpc.getBulkImportRelationshipsMethod) == null) {
          ExperimentalServiceGrpc.getBulkImportRelationshipsMethod = getBulkImportRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.BulkImportRelationshipsRequest, com.authzed.api.v1.BulkImportRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkImportRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkImportRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkImportRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkImportRelationships"))
              .build();
        }
      }
    }
    return getBulkImportRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.BulkExportRelationshipsRequest,
      com.authzed.api.v1.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkExportRelationships",
      requestType = com.authzed.api.v1.BulkExportRelationshipsRequest.class,
      responseType = com.authzed.api.v1.BulkExportRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.BulkExportRelationshipsRequest,
      com.authzed.api.v1.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.BulkExportRelationshipsRequest, com.authzed.api.v1.BulkExportRelationshipsResponse> getBulkExportRelationshipsMethod;
    if ((getBulkExportRelationshipsMethod = ExperimentalServiceGrpc.getBulkExportRelationshipsMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getBulkExportRelationshipsMethod = ExperimentalServiceGrpc.getBulkExportRelationshipsMethod) == null) {
          ExperimentalServiceGrpc.getBulkExportRelationshipsMethod = getBulkExportRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.BulkExportRelationshipsRequest, com.authzed.api.v1.BulkExportRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkExportRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkExportRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkExportRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkExportRelationships"))
              .build();
        }
      }
    }
    return getBulkExportRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.BulkCheckPermissionRequest,
      com.authzed.api.v1.BulkCheckPermissionResponse> getBulkCheckPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkCheckPermission",
      requestType = com.authzed.api.v1.BulkCheckPermissionRequest.class,
      responseType = com.authzed.api.v1.BulkCheckPermissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.BulkCheckPermissionRequest,
      com.authzed.api.v1.BulkCheckPermissionResponse> getBulkCheckPermissionMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.BulkCheckPermissionRequest, com.authzed.api.v1.BulkCheckPermissionResponse> getBulkCheckPermissionMethod;
    if ((getBulkCheckPermissionMethod = ExperimentalServiceGrpc.getBulkCheckPermissionMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getBulkCheckPermissionMethod = ExperimentalServiceGrpc.getBulkCheckPermissionMethod) == null) {
          ExperimentalServiceGrpc.getBulkCheckPermissionMethod = getBulkCheckPermissionMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.BulkCheckPermissionRequest, com.authzed.api.v1.BulkCheckPermissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkCheckPermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkCheckPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.BulkCheckPermissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("BulkCheckPermission"))
              .build();
        }
      }
    }
    return getBulkCheckPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalReflectSchemaRequest,
      com.authzed.api.v1.ExperimentalReflectSchemaResponse> getExperimentalReflectSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalReflectSchema",
      requestType = com.authzed.api.v1.ExperimentalReflectSchemaRequest.class,
      responseType = com.authzed.api.v1.ExperimentalReflectSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalReflectSchemaRequest,
      com.authzed.api.v1.ExperimentalReflectSchemaResponse> getExperimentalReflectSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalReflectSchemaRequest, com.authzed.api.v1.ExperimentalReflectSchemaResponse> getExperimentalReflectSchemaMethod;
    if ((getExperimentalReflectSchemaMethod = ExperimentalServiceGrpc.getExperimentalReflectSchemaMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalReflectSchemaMethod = ExperimentalServiceGrpc.getExperimentalReflectSchemaMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalReflectSchemaMethod = getExperimentalReflectSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalReflectSchemaRequest, com.authzed.api.v1.ExperimentalReflectSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalReflectSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalReflectSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalReflectSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalReflectSchema"))
              .build();
        }
      }
    }
    return getExperimentalReflectSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalComputablePermissionsRequest,
      com.authzed.api.v1.ExperimentalComputablePermissionsResponse> getExperimentalComputablePermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalComputablePermissions",
      requestType = com.authzed.api.v1.ExperimentalComputablePermissionsRequest.class,
      responseType = com.authzed.api.v1.ExperimentalComputablePermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalComputablePermissionsRequest,
      com.authzed.api.v1.ExperimentalComputablePermissionsResponse> getExperimentalComputablePermissionsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalComputablePermissionsRequest, com.authzed.api.v1.ExperimentalComputablePermissionsResponse> getExperimentalComputablePermissionsMethod;
    if ((getExperimentalComputablePermissionsMethod = ExperimentalServiceGrpc.getExperimentalComputablePermissionsMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalComputablePermissionsMethod = ExperimentalServiceGrpc.getExperimentalComputablePermissionsMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalComputablePermissionsMethod = getExperimentalComputablePermissionsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalComputablePermissionsRequest, com.authzed.api.v1.ExperimentalComputablePermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalComputablePermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalComputablePermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalComputablePermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalComputablePermissions"))
              .build();
        }
      }
    }
    return getExperimentalComputablePermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDependentRelationsRequest,
      com.authzed.api.v1.ExperimentalDependentRelationsResponse> getExperimentalDependentRelationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalDependentRelations",
      requestType = com.authzed.api.v1.ExperimentalDependentRelationsRequest.class,
      responseType = com.authzed.api.v1.ExperimentalDependentRelationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDependentRelationsRequest,
      com.authzed.api.v1.ExperimentalDependentRelationsResponse> getExperimentalDependentRelationsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDependentRelationsRequest, com.authzed.api.v1.ExperimentalDependentRelationsResponse> getExperimentalDependentRelationsMethod;
    if ((getExperimentalDependentRelationsMethod = ExperimentalServiceGrpc.getExperimentalDependentRelationsMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalDependentRelationsMethod = ExperimentalServiceGrpc.getExperimentalDependentRelationsMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalDependentRelationsMethod = getExperimentalDependentRelationsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalDependentRelationsRequest, com.authzed.api.v1.ExperimentalDependentRelationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalDependentRelations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalDependentRelationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalDependentRelationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalDependentRelations"))
              .build();
        }
      }
    }
    return getExperimentalDependentRelationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDiffSchemaRequest,
      com.authzed.api.v1.ExperimentalDiffSchemaResponse> getExperimentalDiffSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalDiffSchema",
      requestType = com.authzed.api.v1.ExperimentalDiffSchemaRequest.class,
      responseType = com.authzed.api.v1.ExperimentalDiffSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDiffSchemaRequest,
      com.authzed.api.v1.ExperimentalDiffSchemaResponse> getExperimentalDiffSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalDiffSchemaRequest, com.authzed.api.v1.ExperimentalDiffSchemaResponse> getExperimentalDiffSchemaMethod;
    if ((getExperimentalDiffSchemaMethod = ExperimentalServiceGrpc.getExperimentalDiffSchemaMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalDiffSchemaMethod = ExperimentalServiceGrpc.getExperimentalDiffSchemaMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalDiffSchemaMethod = getExperimentalDiffSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalDiffSchemaRequest, com.authzed.api.v1.ExperimentalDiffSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalDiffSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalDiffSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalDiffSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalDiffSchema"))
              .build();
        }
      }
    }
    return getExperimentalDiffSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest,
      com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> getExperimentalRegisterRelationshipCounterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalRegisterRelationshipCounter",
      requestType = com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest.class,
      responseType = com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest,
      com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> getExperimentalRegisterRelationshipCounterMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> getExperimentalRegisterRelationshipCounterMethod;
    if ((getExperimentalRegisterRelationshipCounterMethod = ExperimentalServiceGrpc.getExperimentalRegisterRelationshipCounterMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalRegisterRelationshipCounterMethod = ExperimentalServiceGrpc.getExperimentalRegisterRelationshipCounterMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalRegisterRelationshipCounterMethod = getExperimentalRegisterRelationshipCounterMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalRegisterRelationshipCounter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalRegisterRelationshipCounter"))
              .build();
        }
      }
    }
    return getExperimentalRegisterRelationshipCounterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalCountRelationshipsRequest,
      com.authzed.api.v1.ExperimentalCountRelationshipsResponse> getExperimentalCountRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalCountRelationships",
      requestType = com.authzed.api.v1.ExperimentalCountRelationshipsRequest.class,
      responseType = com.authzed.api.v1.ExperimentalCountRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalCountRelationshipsRequest,
      com.authzed.api.v1.ExperimentalCountRelationshipsResponse> getExperimentalCountRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalCountRelationshipsRequest, com.authzed.api.v1.ExperimentalCountRelationshipsResponse> getExperimentalCountRelationshipsMethod;
    if ((getExperimentalCountRelationshipsMethod = ExperimentalServiceGrpc.getExperimentalCountRelationshipsMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalCountRelationshipsMethod = ExperimentalServiceGrpc.getExperimentalCountRelationshipsMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalCountRelationshipsMethod = getExperimentalCountRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalCountRelationshipsRequest, com.authzed.api.v1.ExperimentalCountRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalCountRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalCountRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalCountRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalCountRelationships"))
              .build();
        }
      }
    }
    return getExperimentalCountRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest,
      com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> getExperimentalUnregisterRelationshipCounterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExperimentalUnregisterRelationshipCounter",
      requestType = com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest.class,
      responseType = com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest,
      com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> getExperimentalUnregisterRelationshipCounterMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> getExperimentalUnregisterRelationshipCounterMethod;
    if ((getExperimentalUnregisterRelationshipCounterMethod = ExperimentalServiceGrpc.getExperimentalUnregisterRelationshipCounterMethod) == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        if ((getExperimentalUnregisterRelationshipCounterMethod = ExperimentalServiceGrpc.getExperimentalUnregisterRelationshipCounterMethod) == null) {
          ExperimentalServiceGrpc.getExperimentalUnregisterRelationshipCounterMethod = getExperimentalUnregisterRelationshipCounterMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest, com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExperimentalUnregisterRelationshipCounter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExperimentalServiceMethodDescriptorSupplier("ExperimentalUnregisterRelationshipCounter"))
              .build();
        }
      }
    }
    return getExperimentalUnregisterRelationshipCounterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExperimentalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceStub>() {
        @java.lang.Override
        public ExperimentalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExperimentalServiceStub(channel, callOptions);
        }
      };
    return ExperimentalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExperimentalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceBlockingStub>() {
        @java.lang.Override
        public ExperimentalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExperimentalServiceBlockingStub(channel, callOptions);
        }
      };
    return ExperimentalServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExperimentalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExperimentalServiceFutureStub>() {
        @java.lang.Override
        public ExperimentalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExperimentalServiceFutureStub(channel, callOptions);
        }
      };
    return ExperimentalServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ExperimentalService exposes a number of APIs that are currently being
   * prototyped and tested for future inclusion in the stable API.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * BulkImportRelationships is a faster path to writing a large number of
     * relationships at once. It is both batched and streaming. For maximum
     * performance, the caller should attempt to write relationships in as close
     * to relationship sort order as possible: (resource.object_type,
     * resource.object_id, relation, subject.object.object_type,
     * subject.object.object_id, subject.optional_relation)
     * 
     * EXPERIMENTAL
     * https://github.com/authzed/spicedb/issues/1303
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsRequest> bulkImportRelationships(
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBulkImportRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * BulkExportRelationships is the fastest path available to exporting
     * relationships from the server. It is resumable, and will return results
     * in an order determined by the server.
     * </pre>
     */
    default void bulkExportRelationships(com.authzed.api.v1.BulkExportRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkExportRelationshipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkExportRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * NOTE: BulkCheckPermission has been promoted to the stable API as "CheckBulkPermission" and the
     * API will be removed from experimental in a future release.
     * </pre>
     */
    @java.lang.Deprecated
    default void bulkCheckPermission(com.authzed.api.v1.BulkCheckPermissionRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkCheckPermissionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkCheckPermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ReflectSchema is an API that allows clients to reflect the schema stored in
     * SpiceDB. This is useful for clients that need to introspect the schema of a SpiceDB instance.
     * </pre>
     */
    default void experimentalReflectSchema(com.authzed.api.v1.ExperimentalReflectSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalReflectSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalReflectSchemaMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ComputablePermissions is an API that allows clients to request the set of
     * permissions that compute based off a relation. For example, if a schema has a relation
     * `viewer` and a permission `view` defined as `permission view = viewer + editor`, then the
     * computable permissions for the relation `viewer` will include `view`.
     * </pre>
     */
    default void experimentalComputablePermissions(com.authzed.api.v1.ExperimentalComputablePermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalComputablePermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DependentRelations is an API that allows clients to request the set of
     * relations and permissions that used to compute a permission, recursively. It is the
     * inverse of the ComputablePermissions API.
     * </pre>
     */
    default void experimentalDependentRelations(com.authzed.api.v1.ExperimentalDependentRelationsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDependentRelationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalDependentRelationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DiffSchema is an API that allows clients to request the difference between the
     * specified schema and the schema stored in SpiceDB. This is useful for clients that need to
     * introspect the schema of a SpiceDB instance.
     * </pre>
     */
    default void experimentalDiffSchema(com.authzed.api.v1.ExperimentalDiffSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDiffSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalDiffSchemaMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
     * a count can be requested.
     * </pre>
     */
    default void experimentalRegisterRelationshipCounter(com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalRegisterRelationshipCounterMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: CountRelationships returns the count of relationships for *pre-registered* filter.
     * </pre>
     */
    default void experimentalCountRelationships(com.authzed.api.v1.ExperimentalCountRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalCountRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
     * </pre>
     */
    default void experimentalUnregisterRelationshipCounter(com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExperimentalUnregisterRelationshipCounterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExperimentalService.
   * <pre>
   * ExperimentalService exposes a number of APIs that are currently being
   * prototyped and tested for future inclusion in the stable API.
   * </pre>
   */
  public static abstract class ExperimentalServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ExperimentalServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExperimentalService.
   * <pre>
   * ExperimentalService exposes a number of APIs that are currently being
   * prototyped and tested for future inclusion in the stable API.
   * </pre>
   */
  public static final class ExperimentalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExperimentalServiceStub> {
    private ExperimentalServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentalServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * BulkImportRelationships is a faster path to writing a large number of
     * relationships at once. It is both batched and streaming. For maximum
     * performance, the caller should attempt to write relationships in as close
     * to relationship sort order as possible: (resource.object_type,
     * resource.object_id, relation, subject.object.object_type,
     * subject.object.object_id, subject.optional_relation)
     * 
     * EXPERIMENTAL
     * https://github.com/authzed/spicedb/issues/1303
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsRequest> bulkImportRelationships(
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getBulkImportRelationshipsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * BulkExportRelationships is the fastest path available to exporting
     * relationships from the server. It is resumable, and will return results
     * in an order determined by the server.
     * </pre>
     */
    public void bulkExportRelationships(com.authzed.api.v1.BulkExportRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkExportRelationshipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBulkExportRelationshipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * NOTE: BulkCheckPermission has been promoted to the stable API as "CheckBulkPermission" and the
     * API will be removed from experimental in a future release.
     * </pre>
     */
    @java.lang.Deprecated
    public void bulkCheckPermission(com.authzed.api.v1.BulkCheckPermissionRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkCheckPermissionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkCheckPermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ReflectSchema is an API that allows clients to reflect the schema stored in
     * SpiceDB. This is useful for clients that need to introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public void experimentalReflectSchema(com.authzed.api.v1.ExperimentalReflectSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalReflectSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalReflectSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ComputablePermissions is an API that allows clients to request the set of
     * permissions that compute based off a relation. For example, if a schema has a relation
     * `viewer` and a permission `view` defined as `permission view = viewer + editor`, then the
     * computable permissions for the relation `viewer` will include `view`.
     * </pre>
     */
    public void experimentalComputablePermissions(com.authzed.api.v1.ExperimentalComputablePermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalComputablePermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DependentRelations is an API that allows clients to request the set of
     * relations and permissions that used to compute a permission, recursively. It is the
     * inverse of the ComputablePermissions API.
     * </pre>
     */
    public void experimentalDependentRelations(com.authzed.api.v1.ExperimentalDependentRelationsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDependentRelationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalDependentRelationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DiffSchema is an API that allows clients to request the difference between the
     * specified schema and the schema stored in SpiceDB. This is useful for clients that need to
     * introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public void experimentalDiffSchema(com.authzed.api.v1.ExperimentalDiffSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDiffSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalDiffSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
     * a count can be requested.
     * </pre>
     */
    public void experimentalRegisterRelationshipCounter(com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalRegisterRelationshipCounterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: CountRelationships returns the count of relationships for *pre-registered* filter.
     * </pre>
     */
    public void experimentalCountRelationships(com.authzed.api.v1.ExperimentalCountRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalCountRelationshipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
     * </pre>
     */
    public void experimentalUnregisterRelationshipCounter(com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExperimentalUnregisterRelationshipCounterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExperimentalService.
   * <pre>
   * ExperimentalService exposes a number of APIs that are currently being
   * prototyped and tested for future inclusion in the stable API.
   * </pre>
   */
  public static final class ExperimentalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExperimentalServiceBlockingStub> {
    private ExperimentalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentalServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * BulkExportRelationships is the fastest path available to exporting
     * relationships from the server. It is resumable, and will return results
     * in an order determined by the server.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.v1.BulkExportRelationshipsResponse> bulkExportRelationships(
        com.authzed.api.v1.BulkExportRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBulkExportRelationshipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * NOTE: BulkCheckPermission has been promoted to the stable API as "CheckBulkPermission" and the
     * API will be removed from experimental in a future release.
     * </pre>
     */
    @java.lang.Deprecated
    public com.authzed.api.v1.BulkCheckPermissionResponse bulkCheckPermission(com.authzed.api.v1.BulkCheckPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkCheckPermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ReflectSchema is an API that allows clients to reflect the schema stored in
     * SpiceDB. This is useful for clients that need to introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalReflectSchemaResponse experimentalReflectSchema(com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalReflectSchemaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ComputablePermissions is an API that allows clients to request the set of
     * permissions that compute based off a relation. For example, if a schema has a relation
     * `viewer` and a permission `view` defined as `permission view = viewer + editor`, then the
     * computable permissions for the relation `viewer` will include `view`.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalComputablePermissionsResponse experimentalComputablePermissions(com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalComputablePermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DependentRelations is an API that allows clients to request the set of
     * relations and permissions that used to compute a permission, recursively. It is the
     * inverse of the ComputablePermissions API.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalDependentRelationsResponse experimentalDependentRelations(com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalDependentRelationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DiffSchema is an API that allows clients to request the difference between the
     * specified schema and the schema stored in SpiceDB. This is useful for clients that need to
     * introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalDiffSchemaResponse experimentalDiffSchema(com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalDiffSchemaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
     * a count can be requested.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse experimentalRegisterRelationshipCounter(com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalRegisterRelationshipCounterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: CountRelationships returns the count of relationships for *pre-registered* filter.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalCountRelationshipsResponse experimentalCountRelationships(com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalCountRelationshipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
     * </pre>
     */
    public com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse experimentalUnregisterRelationshipCounter(com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExperimentalUnregisterRelationshipCounterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExperimentalService.
   * <pre>
   * ExperimentalService exposes a number of APIs that are currently being
   * prototyped and tested for future inclusion in the stable API.
   * </pre>
   */
  public static final class ExperimentalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExperimentalServiceFutureStub> {
    private ExperimentalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExperimentalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExperimentalServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * NOTE: BulkCheckPermission has been promoted to the stable API as "CheckBulkPermission" and the
     * API will be removed from experimental in a future release.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.BulkCheckPermissionResponse> bulkCheckPermission(
        com.authzed.api.v1.BulkCheckPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkCheckPermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ReflectSchema is an API that allows clients to reflect the schema stored in
     * SpiceDB. This is useful for clients that need to introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalReflectSchemaResponse> experimentalReflectSchema(
        com.authzed.api.v1.ExperimentalReflectSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalReflectSchemaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: ComputablePermissions is an API that allows clients to request the set of
     * permissions that compute based off a relation. For example, if a schema has a relation
     * `viewer` and a permission `view` defined as `permission view = viewer + editor`, then the
     * computable permissions for the relation `viewer` will include `view`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalComputablePermissionsResponse> experimentalComputablePermissions(
        com.authzed.api.v1.ExperimentalComputablePermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalComputablePermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DependentRelations is an API that allows clients to request the set of
     * relations and permissions that used to compute a permission, recursively. It is the
     * inverse of the ComputablePermissions API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalDependentRelationsResponse> experimentalDependentRelations(
        com.authzed.api.v1.ExperimentalDependentRelationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalDependentRelationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: DiffSchema is an API that allows clients to request the difference between the
     * specified schema and the schema stored in SpiceDB. This is useful for clients that need to
     * introspect the schema of a SpiceDB instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalDiffSchemaResponse> experimentalDiffSchema(
        com.authzed.api.v1.ExperimentalDiffSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalDiffSchemaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: RegisterRelationshipCounter registers a new filter for counting relationships. A filter must be registered before
     * a count can be requested.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse> experimentalRegisterRelationshipCounter(
        com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalRegisterRelationshipCounterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: CountRelationships returns the count of relationships for *pre-registered* filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalCountRelationshipsResponse> experimentalCountRelationships(
        com.authzed.api.v1.ExperimentalCountRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalCountRelationshipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * EXPERIMENTAL: UnregisterRelationshipCounter unregisters an existing filter for counting relationships.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse> experimentalUnregisterRelationshipCounter(
        com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExperimentalUnregisterRelationshipCounterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BULK_EXPORT_RELATIONSHIPS = 0;
  private static final int METHODID_BULK_CHECK_PERMISSION = 1;
  private static final int METHODID_EXPERIMENTAL_REFLECT_SCHEMA = 2;
  private static final int METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS = 3;
  private static final int METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS = 4;
  private static final int METHODID_EXPERIMENTAL_DIFF_SCHEMA = 5;
  private static final int METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER = 6;
  private static final int METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS = 7;
  private static final int METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER = 8;
  private static final int METHODID_BULK_IMPORT_RELATIONSHIPS = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BULK_EXPORT_RELATIONSHIPS:
          serviceImpl.bulkExportRelationships((com.authzed.api.v1.BulkExportRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkExportRelationshipsResponse>) responseObserver);
          break;
        case METHODID_BULK_CHECK_PERMISSION:
          serviceImpl.bulkCheckPermission((com.authzed.api.v1.BulkCheckPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkCheckPermissionResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_REFLECT_SCHEMA:
          serviceImpl.experimentalReflectSchema((com.authzed.api.v1.ExperimentalReflectSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalReflectSchemaResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS:
          serviceImpl.experimentalComputablePermissions((com.authzed.api.v1.ExperimentalComputablePermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalComputablePermissionsResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS:
          serviceImpl.experimentalDependentRelations((com.authzed.api.v1.ExperimentalDependentRelationsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDependentRelationsResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_DIFF_SCHEMA:
          serviceImpl.experimentalDiffSchema((com.authzed.api.v1.ExperimentalDiffSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalDiffSchemaResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER:
          serviceImpl.experimentalRegisterRelationshipCounter((com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS:
          serviceImpl.experimentalCountRelationships((com.authzed.api.v1.ExperimentalCountRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalCountRelationshipsResponse>) responseObserver);
          break;
        case METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER:
          serviceImpl.experimentalUnregisterRelationshipCounter((com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BULK_IMPORT_RELATIONSHIPS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bulkImportRelationships(
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.BulkImportRelationshipsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getBulkImportRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.BulkImportRelationshipsRequest,
              com.authzed.api.v1.BulkImportRelationshipsResponse>(
                service, METHODID_BULK_IMPORT_RELATIONSHIPS)))
        .addMethod(
          getBulkExportRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.BulkExportRelationshipsRequest,
              com.authzed.api.v1.BulkExportRelationshipsResponse>(
                service, METHODID_BULK_EXPORT_RELATIONSHIPS)))
        .addMethod(
          getBulkCheckPermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.BulkCheckPermissionRequest,
              com.authzed.api.v1.BulkCheckPermissionResponse>(
                service, METHODID_BULK_CHECK_PERMISSION)))
        .addMethod(
          getExperimentalReflectSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalReflectSchemaRequest,
              com.authzed.api.v1.ExperimentalReflectSchemaResponse>(
                service, METHODID_EXPERIMENTAL_REFLECT_SCHEMA)))
        .addMethod(
          getExperimentalComputablePermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalComputablePermissionsRequest,
              com.authzed.api.v1.ExperimentalComputablePermissionsResponse>(
                service, METHODID_EXPERIMENTAL_COMPUTABLE_PERMISSIONS)))
        .addMethod(
          getExperimentalDependentRelationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalDependentRelationsRequest,
              com.authzed.api.v1.ExperimentalDependentRelationsResponse>(
                service, METHODID_EXPERIMENTAL_DEPENDENT_RELATIONS)))
        .addMethod(
          getExperimentalDiffSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalDiffSchemaRequest,
              com.authzed.api.v1.ExperimentalDiffSchemaResponse>(
                service, METHODID_EXPERIMENTAL_DIFF_SCHEMA)))
        .addMethod(
          getExperimentalRegisterRelationshipCounterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalRegisterRelationshipCounterRequest,
              com.authzed.api.v1.ExperimentalRegisterRelationshipCounterResponse>(
                service, METHODID_EXPERIMENTAL_REGISTER_RELATIONSHIP_COUNTER)))
        .addMethod(
          getExperimentalCountRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalCountRelationshipsRequest,
              com.authzed.api.v1.ExperimentalCountRelationshipsResponse>(
                service, METHODID_EXPERIMENTAL_COUNT_RELATIONSHIPS)))
        .addMethod(
          getExperimentalUnregisterRelationshipCounterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterRequest,
              com.authzed.api.v1.ExperimentalUnregisterRelationshipCounterResponse>(
                service, METHODID_EXPERIMENTAL_UNREGISTER_RELATIONSHIP_COUNTER)))
        .build();
  }

  private static abstract class ExperimentalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExperimentalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.v1.ExperimentalServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExperimentalService");
    }
  }

  private static final class ExperimentalServiceFileDescriptorSupplier
      extends ExperimentalServiceBaseDescriptorSupplier {
    ExperimentalServiceFileDescriptorSupplier() {}
  }

  private static final class ExperimentalServiceMethodDescriptorSupplier
      extends ExperimentalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExperimentalServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExperimentalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExperimentalServiceFileDescriptorSupplier())
              .addMethod(getBulkImportRelationshipsMethod())
              .addMethod(getBulkExportRelationshipsMethod())
              .addMethod(getBulkCheckPermissionMethod())
              .addMethod(getExperimentalReflectSchemaMethod())
              .addMethod(getExperimentalComputablePermissionsMethod())
              .addMethod(getExperimentalDependentRelationsMethod())
              .addMethod(getExperimentalDiffSchemaMethod())
              .addMethod(getExperimentalRegisterRelationshipCounterMethod())
              .addMethod(getExperimentalCountRelationshipsMethod())
              .addMethod(getExperimentalUnregisterRelationshipCounterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
