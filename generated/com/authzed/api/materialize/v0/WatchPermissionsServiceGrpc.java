package com.authzed.api.materialize.v0;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/materialize/v0/watchpermissions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WatchPermissionsServiceGrpc {

  private WatchPermissionsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.materialize.v0.WatchPermissionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionsRequest,
      com.authzed.api.materialize.v0.WatchPermissionsResponse> getWatchPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WatchPermissions",
      requestType = com.authzed.api.materialize.v0.WatchPermissionsRequest.class,
      responseType = com.authzed.api.materialize.v0.WatchPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionsRequest,
      com.authzed.api.materialize.v0.WatchPermissionsResponse> getWatchPermissionsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionsRequest, com.authzed.api.materialize.v0.WatchPermissionsResponse> getWatchPermissionsMethod;
    if ((getWatchPermissionsMethod = WatchPermissionsServiceGrpc.getWatchPermissionsMethod) == null) {
      synchronized (WatchPermissionsServiceGrpc.class) {
        if ((getWatchPermissionsMethod = WatchPermissionsServiceGrpc.getWatchPermissionsMethod) == null) {
          WatchPermissionsServiceGrpc.getWatchPermissionsMethod = getWatchPermissionsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.materialize.v0.WatchPermissionsRequest, com.authzed.api.materialize.v0.WatchPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WatchPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.WatchPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.WatchPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WatchPermissionsServiceMethodDescriptorSupplier("WatchPermissions"))
              .build();
        }
      }
    }
    return getWatchPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WatchPermissionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceStub>() {
        @java.lang.Override
        public WatchPermissionsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionsServiceStub(channel, callOptions);
        }
      };
    return WatchPermissionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WatchPermissionsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceBlockingStub>() {
        @java.lang.Override
        public WatchPermissionsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionsServiceBlockingStub(channel, callOptions);
        }
      };
    return WatchPermissionsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WatchPermissionsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionsServiceFutureStub>() {
        @java.lang.Override
        public WatchPermissionsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionsServiceFutureStub(channel, callOptions);
        }
      };
    return WatchPermissionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * WatchPermissions returns a stream of PermissionChange events for the given permissions.
     * WatchPermissions is a long-running RPC, and will stream events until the client
     * closes the connection or the server terminates the stream. The consumer is responsible of
     * keeping track of the last seen revision and resuming the stream from that point in the event
     * of disconnection or client-side restarts.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * Usage of WatchPermissions requires to be explicitly enabled on the service, including the permissions to be
     * watched. It requires more resources and is less performant than WatchPermissionsSets. It's usage
     * is only recommended when performing the set intersections of WatchPermissionSets in the client side is not viable
     * or there is a strict application requirement to use consume the computed permissions.
     * </pre>
     */
    default void watchPermissions(com.authzed.api.materialize.v0.WatchPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWatchPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WatchPermissionsService.
   */
  public static abstract class WatchPermissionsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WatchPermissionsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WatchPermissionsService.
   */
  public static final class WatchPermissionsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WatchPermissionsServiceStub> {
    private WatchPermissionsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * WatchPermissions returns a stream of PermissionChange events for the given permissions.
     * WatchPermissions is a long-running RPC, and will stream events until the client
     * closes the connection or the server terminates the stream. The consumer is responsible of
     * keeping track of the last seen revision and resuming the stream from that point in the event
     * of disconnection or client-side restarts.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * Usage of WatchPermissions requires to be explicitly enabled on the service, including the permissions to be
     * watched. It requires more resources and is less performant than WatchPermissionsSets. It's usage
     * is only recommended when performing the set intersections of WatchPermissionSets in the client side is not viable
     * or there is a strict application requirement to use consume the computed permissions.
     * </pre>
     */
    public void watchPermissions(com.authzed.api.materialize.v0.WatchPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWatchPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WatchPermissionsService.
   */
  public static final class WatchPermissionsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WatchPermissionsServiceBlockingStub> {
    private WatchPermissionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * WatchPermissions returns a stream of PermissionChange events for the given permissions.
     * WatchPermissions is a long-running RPC, and will stream events until the client
     * closes the connection or the server terminates the stream. The consumer is responsible of
     * keeping track of the last seen revision and resuming the stream from that point in the event
     * of disconnection or client-side restarts.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * Usage of WatchPermissions requires to be explicitly enabled on the service, including the permissions to be
     * watched. It requires more resources and is less performant than WatchPermissionsSets. It's usage
     * is only recommended when performing the set intersections of WatchPermissionSets in the client side is not viable
     * or there is a strict application requirement to use consume the computed permissions.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.materialize.v0.WatchPermissionsResponse> watchPermissions(
        com.authzed.api.materialize.v0.WatchPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWatchPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WatchPermissionsService.
   */
  public static final class WatchPermissionsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WatchPermissionsServiceFutureStub> {
    private WatchPermissionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATCH_PERMISSIONS = 0;

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
        case METHODID_WATCH_PERMISSIONS:
          serviceImpl.watchPermissions((com.authzed.api.materialize.v0.WatchPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionsResponse>) responseObserver);
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
          getWatchPermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.materialize.v0.WatchPermissionsRequest,
              com.authzed.api.materialize.v0.WatchPermissionsResponse>(
                service, METHODID_WATCH_PERMISSIONS)))
        .build();
  }

  private static abstract class WatchPermissionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WatchPermissionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.materialize.v0.Watchpermissions.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WatchPermissionsService");
    }
  }

  private static final class WatchPermissionsServiceFileDescriptorSupplier
      extends WatchPermissionsServiceBaseDescriptorSupplier {
    WatchPermissionsServiceFileDescriptorSupplier() {}
  }

  private static final class WatchPermissionsServiceMethodDescriptorSupplier
      extends WatchPermissionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WatchPermissionsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WatchPermissionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WatchPermissionsServiceFileDescriptorSupplier())
              .addMethod(getWatchPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
