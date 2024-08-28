package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/v1/watch_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WatchServiceGrpc {

  private WatchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.v1.WatchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.WatchRequest,
      com.authzed.api.v1.WatchResponse> getWatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Watch",
      requestType = com.authzed.api.v1.WatchRequest.class,
      responseType = com.authzed.api.v1.WatchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.WatchRequest,
      com.authzed.api.v1.WatchResponse> getWatchMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.WatchRequest, com.authzed.api.v1.WatchResponse> getWatchMethod;
    if ((getWatchMethod = WatchServiceGrpc.getWatchMethod) == null) {
      synchronized (WatchServiceGrpc.class) {
        if ((getWatchMethod = WatchServiceGrpc.getWatchMethod) == null) {
          WatchServiceGrpc.getWatchMethod = getWatchMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.WatchRequest, com.authzed.api.v1.WatchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Watch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WatchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WatchServiceMethodDescriptorSupplier("Watch"))
              .build();
        }
      }
    }
    return getWatchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WatchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchServiceStub>() {
        @java.lang.Override
        public WatchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchServiceStub(channel, callOptions);
        }
      };
    return WatchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WatchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchServiceBlockingStub>() {
        @java.lang.Override
        public WatchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchServiceBlockingStub(channel, callOptions);
        }
      };
    return WatchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WatchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchServiceFutureStub>() {
        @java.lang.Override
        public WatchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchServiceFutureStub(channel, callOptions);
        }
      };
    return WatchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void watch(com.authzed.api.v1.WatchRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WatchResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWatchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WatchService.
   */
  public static abstract class WatchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WatchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WatchService.
   */
  public static final class WatchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WatchServiceStub> {
    private WatchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchServiceStub(channel, callOptions);
    }

    /**
     */
    public void watch(com.authzed.api.v1.WatchRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WatchResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWatchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WatchService.
   */
  public static final class WatchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WatchServiceBlockingStub> {
    private WatchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.authzed.api.v1.WatchResponse> watch(
        com.authzed.api.v1.WatchRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWatchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WatchService.
   */
  public static final class WatchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WatchServiceFutureStub> {
    private WatchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATCH = 0;

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
        case METHODID_WATCH:
          serviceImpl.watch((com.authzed.api.v1.WatchRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.WatchResponse>) responseObserver);
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
          getWatchMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.v1.WatchRequest,
              com.authzed.api.v1.WatchResponse>(
                service, METHODID_WATCH)))
        .build();
  }

  private static abstract class WatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WatchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.v1.WatchServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WatchService");
    }
  }

  private static final class WatchServiceFileDescriptorSupplier
      extends WatchServiceBaseDescriptorSupplier {
    WatchServiceFileDescriptorSupplier() {}
  }

  private static final class WatchServiceMethodDescriptorSupplier
      extends WatchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WatchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WatchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WatchServiceFileDescriptorSupplier())
              .addMethod(getWatchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
