package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * PermissionsService implements a set of RPCs that perform operations on
 * relationships and permissions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/v1/permission_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PermissionsServiceGrpc {

  private PermissionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.v1.PermissionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ReadRelationshipsRequest,
      com.authzed.api.v1.ReadRelationshipsResponse> getReadRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadRelationships",
      requestType = com.authzed.api.v1.ReadRelationshipsRequest.class,
      responseType = com.authzed.api.v1.ReadRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ReadRelationshipsRequest,
      com.authzed.api.v1.ReadRelationshipsResponse> getReadRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ReadRelationshipsRequest, com.authzed.api.v1.ReadRelationshipsResponse> getReadRelationshipsMethod;
    if ((getReadRelationshipsMethod = PermissionsServiceGrpc.getReadRelationshipsMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getReadRelationshipsMethod = PermissionsServiceGrpc.getReadRelationshipsMethod) == null) {
          PermissionsServiceGrpc.getReadRelationshipsMethod = getReadRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ReadRelationshipsRequest, com.authzed.api.v1.ReadRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ReadRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ReadRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("ReadRelationships"))
              .build();
        }
      }
    }
    return getReadRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.WriteRelationshipsRequest,
      com.authzed.api.v1.WriteRelationshipsResponse> getWriteRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteRelationships",
      requestType = com.authzed.api.v1.WriteRelationshipsRequest.class,
      responseType = com.authzed.api.v1.WriteRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.WriteRelationshipsRequest,
      com.authzed.api.v1.WriteRelationshipsResponse> getWriteRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.WriteRelationshipsRequest, com.authzed.api.v1.WriteRelationshipsResponse> getWriteRelationshipsMethod;
    if ((getWriteRelationshipsMethod = PermissionsServiceGrpc.getWriteRelationshipsMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getWriteRelationshipsMethod = PermissionsServiceGrpc.getWriteRelationshipsMethod) == null) {
          PermissionsServiceGrpc.getWriteRelationshipsMethod = getWriteRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.WriteRelationshipsRequest, com.authzed.api.v1.WriteRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WriteRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WriteRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("WriteRelationships"))
              .build();
        }
      }
    }
    return getWriteRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.DeleteRelationshipsRequest,
      com.authzed.api.v1.DeleteRelationshipsResponse> getDeleteRelationshipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRelationships",
      requestType = com.authzed.api.v1.DeleteRelationshipsRequest.class,
      responseType = com.authzed.api.v1.DeleteRelationshipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.DeleteRelationshipsRequest,
      com.authzed.api.v1.DeleteRelationshipsResponse> getDeleteRelationshipsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.DeleteRelationshipsRequest, com.authzed.api.v1.DeleteRelationshipsResponse> getDeleteRelationshipsMethod;
    if ((getDeleteRelationshipsMethod = PermissionsServiceGrpc.getDeleteRelationshipsMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getDeleteRelationshipsMethod = PermissionsServiceGrpc.getDeleteRelationshipsMethod) == null) {
          PermissionsServiceGrpc.getDeleteRelationshipsMethod = getDeleteRelationshipsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.DeleteRelationshipsRequest, com.authzed.api.v1.DeleteRelationshipsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRelationships"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.DeleteRelationshipsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.DeleteRelationshipsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("DeleteRelationships"))
              .build();
        }
      }
    }
    return getDeleteRelationshipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.CheckPermissionRequest,
      com.authzed.api.v1.CheckPermissionResponse> getCheckPermissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckPermission",
      requestType = com.authzed.api.v1.CheckPermissionRequest.class,
      responseType = com.authzed.api.v1.CheckPermissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.CheckPermissionRequest,
      com.authzed.api.v1.CheckPermissionResponse> getCheckPermissionMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.CheckPermissionRequest, com.authzed.api.v1.CheckPermissionResponse> getCheckPermissionMethod;
    if ((getCheckPermissionMethod = PermissionsServiceGrpc.getCheckPermissionMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getCheckPermissionMethod = PermissionsServiceGrpc.getCheckPermissionMethod) == null) {
          PermissionsServiceGrpc.getCheckPermissionMethod = getCheckPermissionMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.CheckPermissionRequest, com.authzed.api.v1.CheckPermissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckPermission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.CheckPermissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.CheckPermissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("CheckPermission"))
              .build();
        }
      }
    }
    return getCheckPermissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.CheckBulkPermissionsRequest,
      com.authzed.api.v1.CheckBulkPermissionsResponse> getCheckBulkPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckBulkPermissions",
      requestType = com.authzed.api.v1.CheckBulkPermissionsRequest.class,
      responseType = com.authzed.api.v1.CheckBulkPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.CheckBulkPermissionsRequest,
      com.authzed.api.v1.CheckBulkPermissionsResponse> getCheckBulkPermissionsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.CheckBulkPermissionsRequest, com.authzed.api.v1.CheckBulkPermissionsResponse> getCheckBulkPermissionsMethod;
    if ((getCheckBulkPermissionsMethod = PermissionsServiceGrpc.getCheckBulkPermissionsMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getCheckBulkPermissionsMethod = PermissionsServiceGrpc.getCheckBulkPermissionsMethod) == null) {
          PermissionsServiceGrpc.getCheckBulkPermissionsMethod = getCheckBulkPermissionsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.CheckBulkPermissionsRequest, com.authzed.api.v1.CheckBulkPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckBulkPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.CheckBulkPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.CheckBulkPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("CheckBulkPermissions"))
              .build();
        }
      }
    }
    return getCheckBulkPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ExpandPermissionTreeRequest,
      com.authzed.api.v1.ExpandPermissionTreeResponse> getExpandPermissionTreeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExpandPermissionTree",
      requestType = com.authzed.api.v1.ExpandPermissionTreeRequest.class,
      responseType = com.authzed.api.v1.ExpandPermissionTreeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ExpandPermissionTreeRequest,
      com.authzed.api.v1.ExpandPermissionTreeResponse> getExpandPermissionTreeMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ExpandPermissionTreeRequest, com.authzed.api.v1.ExpandPermissionTreeResponse> getExpandPermissionTreeMethod;
    if ((getExpandPermissionTreeMethod = PermissionsServiceGrpc.getExpandPermissionTreeMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getExpandPermissionTreeMethod = PermissionsServiceGrpc.getExpandPermissionTreeMethod) == null) {
          PermissionsServiceGrpc.getExpandPermissionTreeMethod = getExpandPermissionTreeMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ExpandPermissionTreeRequest, com.authzed.api.v1.ExpandPermissionTreeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExpandPermissionTree"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExpandPermissionTreeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ExpandPermissionTreeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("ExpandPermissionTree"))
              .build();
        }
      }
    }
    return getExpandPermissionTreeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.LookupResourcesRequest,
      com.authzed.api.v1.LookupResourcesResponse> getLookupResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupResources",
      requestType = com.authzed.api.v1.LookupResourcesRequest.class,
      responseType = com.authzed.api.v1.LookupResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.LookupResourcesRequest,
      com.authzed.api.v1.LookupResourcesResponse> getLookupResourcesMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.LookupResourcesRequest, com.authzed.api.v1.LookupResourcesResponse> getLookupResourcesMethod;
    if ((getLookupResourcesMethod = PermissionsServiceGrpc.getLookupResourcesMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getLookupResourcesMethod = PermissionsServiceGrpc.getLookupResourcesMethod) == null) {
          PermissionsServiceGrpc.getLookupResourcesMethod = getLookupResourcesMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.LookupResourcesRequest, com.authzed.api.v1.LookupResourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupResources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.LookupResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.LookupResourcesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("LookupResources"))
              .build();
        }
      }
    }
    return getLookupResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.LookupSubjectsRequest,
      com.authzed.api.v1.LookupSubjectsResponse> getLookupSubjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupSubjects",
      requestType = com.authzed.api.v1.LookupSubjectsRequest.class,
      responseType = com.authzed.api.v1.LookupSubjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.LookupSubjectsRequest,
      com.authzed.api.v1.LookupSubjectsResponse> getLookupSubjectsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.LookupSubjectsRequest, com.authzed.api.v1.LookupSubjectsResponse> getLookupSubjectsMethod;
    if ((getLookupSubjectsMethod = PermissionsServiceGrpc.getLookupSubjectsMethod) == null) {
      synchronized (PermissionsServiceGrpc.class) {
        if ((getLookupSubjectsMethod = PermissionsServiceGrpc.getLookupSubjectsMethod) == null) {
          PermissionsServiceGrpc.getLookupSubjectsMethod = getLookupSubjectsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.LookupSubjectsRequest, com.authzed.api.v1.LookupSubjectsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupSubjects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.LookupSubjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.LookupSubjectsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PermissionsServiceMethodDescriptorSupplier("LookupSubjects"))
              .build();
        }
      }
    }
    return getLookupSubjectsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PermissionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceStub>() {
        @java.lang.Override
        public PermissionsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionsServiceStub(channel, callOptions);
        }
      };
    return PermissionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PermissionsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceBlockingStub>() {
        @java.lang.Override
        public PermissionsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionsServiceBlockingStub(channel, callOptions);
        }
      };
    return PermissionsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PermissionsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PermissionsServiceFutureStub>() {
        @java.lang.Override
        public PermissionsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PermissionsServiceFutureStub(channel, callOptions);
        }
      };
    return PermissionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * PermissionsService implements a set of RPCs that perform operations on
   * relationships and permissions.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * ReadRelationships reads a set of the relationships matching one or more
     * filters.
     * </pre>
     */
    default void readRelationships(com.authzed.api.v1.ReadRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadRelationshipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * WriteRelationships atomically writes and/or deletes a set of specified
     * relationships. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    default void writeRelationships(com.authzed.api.v1.WriteRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteRelationshipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * DeleteRelationships atomically bulk deletes all relationships matching the
     * provided filter. If no relationships match, none will be deleted and the
     * operation will succeed. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    default void deleteRelationships(com.authzed.api.v1.DeleteRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.DeleteRelationshipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRelationshipsMethod(), responseObserver);
    }

    /**
     * <pre>
     * CheckPermission determines for a given resource whether a subject computes
     * to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    default void checkPermission(com.authzed.api.v1.CheckPermissionRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckPermissionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckPermissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * CheckBulkPermissions evaluates the given list of permission checks
     * and returns the list of results.
     * </pre>
     */
    default void checkBulkPermissions(com.authzed.api.v1.CheckBulkPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckBulkPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckBulkPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * ExpandPermissionTree reveals the graph structure for a resource's
     * permission or relation. This RPC does not recurse infinitely deep and may
     * require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    default void expandPermissionTree(com.authzed.api.v1.ExpandPermissionTreeRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExpandPermissionTreeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExpandPermissionTreeMethod(), responseObserver);
    }

    /**
     * <pre>
     * LookupResources returns all the resources of a given type that a subject
     * can access whether via a computed permission or relation membership.
     * </pre>
     */
    default void lookupResources(com.authzed.api.v1.LookupResourcesRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupResourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupResourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * LookupSubjects returns all the subjects of a given type that
     * have access whether via a computed permission or relation membership.
     * </pre>
     */
    default void lookupSubjects(com.authzed.api.v1.LookupSubjectsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupSubjectsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupSubjectsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PermissionsService.
   * <pre>
   * PermissionsService implements a set of RPCs that perform operations on
   * relationships and permissions.
   * </pre>
   */
  public static abstract class PermissionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PermissionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PermissionsService.
   * <pre>
   * PermissionsService implements a set of RPCs that perform operations on
   * relationships and permissions.
   * </pre>
   */
  public static final class PermissionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PermissionsServiceStub> {
    private PermissionsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * ReadRelationships reads a set of the relationships matching one or more
     * filters.
     * </pre>
     */
    public void readRelationships(com.authzed.api.v1.ReadRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadRelationshipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReadRelationshipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * WriteRelationships atomically writes and/or deletes a set of specified
     * relationships. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public void writeRelationships(com.authzed.api.v1.WriteRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteRelationshipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteRelationshipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteRelationships atomically bulk deletes all relationships matching the
     * provided filter. If no relationships match, none will be deleted and the
     * operation will succeed. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public void deleteRelationships(com.authzed.api.v1.DeleteRelationshipsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.DeleteRelationshipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRelationshipsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CheckPermission determines for a given resource whether a subject computes
     * to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    public void checkPermission(com.authzed.api.v1.CheckPermissionRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckPermissionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckPermissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * CheckBulkPermissions evaluates the given list of permission checks
     * and returns the list of results.
     * </pre>
     */
    public void checkBulkPermissions(com.authzed.api.v1.CheckBulkPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckBulkPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckBulkPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ExpandPermissionTree reveals the graph structure for a resource's
     * permission or relation. This RPC does not recurse infinitely deep and may
     * require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    public void expandPermissionTree(com.authzed.api.v1.ExpandPermissionTreeRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ExpandPermissionTreeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExpandPermissionTreeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LookupResources returns all the resources of a given type that a subject
     * can access whether via a computed permission or relation membership.
     * </pre>
     */
    public void lookupResources(com.authzed.api.v1.LookupResourcesRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupResourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLookupResourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LookupSubjects returns all the subjects of a given type that
     * have access whether via a computed permission or relation membership.
     * </pre>
     */
    public void lookupSubjects(com.authzed.api.v1.LookupSubjectsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupSubjectsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLookupSubjectsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PermissionsService.
   * <pre>
   * PermissionsService implements a set of RPCs that perform operations on
   * relationships and permissions.
   * </pre>
   */
  public static final class PermissionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PermissionsServiceBlockingStub> {
    private PermissionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * ReadRelationships reads a set of the relationships matching one or more
     * filters.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.v1.ReadRelationshipsResponse> readRelationships(
        com.authzed.api.v1.ReadRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReadRelationshipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * WriteRelationships atomically writes and/or deletes a set of specified
     * relationships. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public com.authzed.api.v1.WriteRelationshipsResponse writeRelationships(com.authzed.api.v1.WriteRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteRelationshipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteRelationships atomically bulk deletes all relationships matching the
     * provided filter. If no relationships match, none will be deleted and the
     * operation will succeed. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public com.authzed.api.v1.DeleteRelationshipsResponse deleteRelationships(com.authzed.api.v1.DeleteRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRelationshipsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CheckPermission determines for a given resource whether a subject computes
     * to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    public com.authzed.api.v1.CheckPermissionResponse checkPermission(com.authzed.api.v1.CheckPermissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckPermissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * CheckBulkPermissions evaluates the given list of permission checks
     * and returns the list of results.
     * </pre>
     */
    public com.authzed.api.v1.CheckBulkPermissionsResponse checkBulkPermissions(com.authzed.api.v1.CheckBulkPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckBulkPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ExpandPermissionTree reveals the graph structure for a resource's
     * permission or relation. This RPC does not recurse infinitely deep and may
     * require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    public com.authzed.api.v1.ExpandPermissionTreeResponse expandPermissionTree(com.authzed.api.v1.ExpandPermissionTreeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExpandPermissionTreeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * LookupResources returns all the resources of a given type that a subject
     * can access whether via a computed permission or relation membership.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.v1.LookupResourcesResponse> lookupResources(
        com.authzed.api.v1.LookupResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLookupResourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * LookupSubjects returns all the subjects of a given type that
     * have access whether via a computed permission or relation membership.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.v1.LookupSubjectsResponse> lookupSubjects(
        com.authzed.api.v1.LookupSubjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLookupSubjectsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PermissionsService.
   * <pre>
   * PermissionsService implements a set of RPCs that perform operations on
   * relationships and permissions.
   * </pre>
   */
  public static final class PermissionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PermissionsServiceFutureStub> {
    private PermissionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PermissionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PermissionsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * WriteRelationships atomically writes and/or deletes a set of specified
     * relationships. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.WriteRelationshipsResponse> writeRelationships(
        com.authzed.api.v1.WriteRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteRelationshipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteRelationships atomically bulk deletes all relationships matching the
     * provided filter. If no relationships match, none will be deleted and the
     * operation will succeed. An optional set of preconditions can be provided that must
     * be satisfied for the operation to commit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.DeleteRelationshipsResponse> deleteRelationships(
        com.authzed.api.v1.DeleteRelationshipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRelationshipsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CheckPermission determines for a given resource whether a subject computes
     * to having a permission or is a direct member of a particular relation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.CheckPermissionResponse> checkPermission(
        com.authzed.api.v1.CheckPermissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckPermissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * CheckBulkPermissions evaluates the given list of permission checks
     * and returns the list of results.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.CheckBulkPermissionsResponse> checkBulkPermissions(
        com.authzed.api.v1.CheckBulkPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckBulkPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ExpandPermissionTree reveals the graph structure for a resource's
     * permission or relation. This RPC does not recurse infinitely deep and may
     * require multiple calls to fully unnest a deeply nested graph.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ExpandPermissionTreeResponse> expandPermissionTree(
        com.authzed.api.v1.ExpandPermissionTreeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExpandPermissionTreeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_RELATIONSHIPS = 0;
  private static final int METHODID_WRITE_RELATIONSHIPS = 1;
  private static final int METHODID_DELETE_RELATIONSHIPS = 2;
  private static final int METHODID_CHECK_PERMISSION = 3;
  private static final int METHODID_CHECK_BULK_PERMISSIONS = 4;
  private static final int METHODID_EXPAND_PERMISSION_TREE = 5;
  private static final int METHODID_LOOKUP_RESOURCES = 6;
  private static final int METHODID_LOOKUP_SUBJECTS = 7;

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
        case METHODID_READ_RELATIONSHIPS:
          serviceImpl.readRelationships((com.authzed.api.v1.ReadRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadRelationshipsResponse>) responseObserver);
          break;
        case METHODID_WRITE_RELATIONSHIPS:
          serviceImpl.writeRelationships((com.authzed.api.v1.WriteRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteRelationshipsResponse>) responseObserver);
          break;
        case METHODID_DELETE_RELATIONSHIPS:
          serviceImpl.deleteRelationships((com.authzed.api.v1.DeleteRelationshipsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.DeleteRelationshipsResponse>) responseObserver);
          break;
        case METHODID_CHECK_PERMISSION:
          serviceImpl.checkPermission((com.authzed.api.v1.CheckPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckPermissionResponse>) responseObserver);
          break;
        case METHODID_CHECK_BULK_PERMISSIONS:
          serviceImpl.checkBulkPermissions((com.authzed.api.v1.CheckBulkPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.CheckBulkPermissionsResponse>) responseObserver);
          break;
        case METHODID_EXPAND_PERMISSION_TREE:
          serviceImpl.expandPermissionTree((com.authzed.api.v1.ExpandPermissionTreeRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ExpandPermissionTreeResponse>) responseObserver);
          break;
        case METHODID_LOOKUP_RESOURCES:
          serviceImpl.lookupResources((com.authzed.api.v1.LookupResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupResourcesResponse>) responseObserver);
          break;
        case METHODID_LOOKUP_SUBJECTS:
          serviceImpl.lookupSubjects((com.authzed.api.v1.LookupSubjectsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.LookupSubjectsResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getReadRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.ReadRelationshipsRequest,
              com.authzed.api.v1.ReadRelationshipsResponse>(
                service, METHODID_READ_RELATIONSHIPS)))
        .addMethod(
          getWriteRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.WriteRelationshipsRequest,
              com.authzed.api.v1.WriteRelationshipsResponse>(
                service, METHODID_WRITE_RELATIONSHIPS)))
        .addMethod(
          getDeleteRelationshipsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.DeleteRelationshipsRequest,
              com.authzed.api.v1.DeleteRelationshipsResponse>(
                service, METHODID_DELETE_RELATIONSHIPS)))
        .addMethod(
          getCheckPermissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.CheckPermissionRequest,
              com.authzed.api.v1.CheckPermissionResponse>(
                service, METHODID_CHECK_PERMISSION)))
        .addMethod(
          getCheckBulkPermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.CheckBulkPermissionsRequest,
              com.authzed.api.v1.CheckBulkPermissionsResponse>(
                service, METHODID_CHECK_BULK_PERMISSIONS)))
        .addMethod(
          getExpandPermissionTreeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ExpandPermissionTreeRequest,
              com.authzed.api.v1.ExpandPermissionTreeResponse>(
                service, METHODID_EXPAND_PERMISSION_TREE)))
        .addMethod(
          getLookupResourcesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.LookupResourcesRequest,
              com.authzed.api.v1.LookupResourcesResponse>(
                service, METHODID_LOOKUP_RESOURCES)))
        .addMethod(
          getLookupSubjectsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.LookupSubjectsRequest,
              com.authzed.api.v1.LookupSubjectsResponse>(
                service, METHODID_LOOKUP_SUBJECTS)))
        .build();
  }

  private static abstract class PermissionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PermissionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.v1.PermissionService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PermissionsService");
    }
  }

  private static final class PermissionsServiceFileDescriptorSupplier
      extends PermissionsServiceBaseDescriptorSupplier {
    PermissionsServiceFileDescriptorSupplier() {}
  }

  private static final class PermissionsServiceMethodDescriptorSupplier
      extends PermissionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PermissionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PermissionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PermissionsServiceFileDescriptorSupplier())
              .addMethod(getReadRelationshipsMethod())
              .addMethod(getWriteRelationshipsMethod())
              .addMethod(getDeleteRelationshipsMethod())
              .addMethod(getCheckPermissionMethod())
              .addMethod(getCheckBulkPermissionsMethod())
              .addMethod(getExpandPermissionTreeMethod())
              .addMethod(getLookupResourcesMethod())
              .addMethod(getLookupSubjectsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
