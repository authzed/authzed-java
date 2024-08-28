package com.authzed.api.v0;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/v0/developer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeveloperServiceGrpc {

  private DeveloperServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.v0.DeveloperService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.EditCheckRequest,
      com.authzed.api.v0.Developer.EditCheckResponse> getEditCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditCheck",
      requestType = com.authzed.api.v0.Developer.EditCheckRequest.class,
      responseType = com.authzed.api.v0.Developer.EditCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.EditCheckRequest,
      com.authzed.api.v0.Developer.EditCheckResponse> getEditCheckMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.EditCheckRequest, com.authzed.api.v0.Developer.EditCheckResponse> getEditCheckMethod;
    if ((getEditCheckMethod = DeveloperServiceGrpc.getEditCheckMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getEditCheckMethod = DeveloperServiceGrpc.getEditCheckMethod) == null) {
          DeveloperServiceGrpc.getEditCheckMethod = getEditCheckMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.EditCheckRequest, com.authzed.api.v0.Developer.EditCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EditCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.EditCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.EditCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("EditCheck"))
              .build();
        }
      }
    }
    return getEditCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ValidateRequest,
      com.authzed.api.v0.Developer.ValidateResponse> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = com.authzed.api.v0.Developer.ValidateRequest.class,
      responseType = com.authzed.api.v0.Developer.ValidateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ValidateRequest,
      com.authzed.api.v0.Developer.ValidateResponse> getValidateMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ValidateRequest, com.authzed.api.v0.Developer.ValidateResponse> getValidateMethod;
    if ((getValidateMethod = DeveloperServiceGrpc.getValidateMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getValidateMethod = DeveloperServiceGrpc.getValidateMethod) == null) {
          DeveloperServiceGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.ValidateRequest, com.authzed.api.v0.Developer.ValidateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.ValidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.ValidateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("Validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ShareRequest,
      com.authzed.api.v0.Developer.ShareResponse> getShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Share",
      requestType = com.authzed.api.v0.Developer.ShareRequest.class,
      responseType = com.authzed.api.v0.Developer.ShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ShareRequest,
      com.authzed.api.v0.Developer.ShareResponse> getShareMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.ShareRequest, com.authzed.api.v0.Developer.ShareResponse> getShareMethod;
    if ((getShareMethod = DeveloperServiceGrpc.getShareMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getShareMethod = DeveloperServiceGrpc.getShareMethod) == null) {
          DeveloperServiceGrpc.getShareMethod = getShareMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.ShareRequest, com.authzed.api.v0.Developer.ShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Share"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.ShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.ShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("Share"))
              .build();
        }
      }
    }
    return getShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.LookupShareRequest,
      com.authzed.api.v0.Developer.LookupShareResponse> getLookupSharedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupShared",
      requestType = com.authzed.api.v0.Developer.LookupShareRequest.class,
      responseType = com.authzed.api.v0.Developer.LookupShareResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.LookupShareRequest,
      com.authzed.api.v0.Developer.LookupShareResponse> getLookupSharedMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.LookupShareRequest, com.authzed.api.v0.Developer.LookupShareResponse> getLookupSharedMethod;
    if ((getLookupSharedMethod = DeveloperServiceGrpc.getLookupSharedMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getLookupSharedMethod = DeveloperServiceGrpc.getLookupSharedMethod) == null) {
          DeveloperServiceGrpc.getLookupSharedMethod = getLookupSharedMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.LookupShareRequest, com.authzed.api.v0.Developer.LookupShareResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupShared"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.LookupShareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.LookupShareResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("LookupShared"))
              .build();
        }
      }
    }
    return getLookupSharedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.UpgradeSchemaRequest,
      com.authzed.api.v0.Developer.UpgradeSchemaResponse> getUpgradeSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeSchema",
      requestType = com.authzed.api.v0.Developer.UpgradeSchemaRequest.class,
      responseType = com.authzed.api.v0.Developer.UpgradeSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.UpgradeSchemaRequest,
      com.authzed.api.v0.Developer.UpgradeSchemaResponse> getUpgradeSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.UpgradeSchemaRequest, com.authzed.api.v0.Developer.UpgradeSchemaResponse> getUpgradeSchemaMethod;
    if ((getUpgradeSchemaMethod = DeveloperServiceGrpc.getUpgradeSchemaMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getUpgradeSchemaMethod = DeveloperServiceGrpc.getUpgradeSchemaMethod) == null) {
          DeveloperServiceGrpc.getUpgradeSchemaMethod = getUpgradeSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.UpgradeSchemaRequest, com.authzed.api.v0.Developer.UpgradeSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.UpgradeSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.UpgradeSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("UpgradeSchema"))
              .build();
        }
      }
    }
    return getUpgradeSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.FormatSchemaRequest,
      com.authzed.api.v0.Developer.FormatSchemaResponse> getFormatSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FormatSchema",
      requestType = com.authzed.api.v0.Developer.FormatSchemaRequest.class,
      responseType = com.authzed.api.v0.Developer.FormatSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.FormatSchemaRequest,
      com.authzed.api.v0.Developer.FormatSchemaResponse> getFormatSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v0.Developer.FormatSchemaRequest, com.authzed.api.v0.Developer.FormatSchemaResponse> getFormatSchemaMethod;
    if ((getFormatSchemaMethod = DeveloperServiceGrpc.getFormatSchemaMethod) == null) {
      synchronized (DeveloperServiceGrpc.class) {
        if ((getFormatSchemaMethod = DeveloperServiceGrpc.getFormatSchemaMethod) == null) {
          DeveloperServiceGrpc.getFormatSchemaMethod = getFormatSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v0.Developer.FormatSchemaRequest, com.authzed.api.v0.Developer.FormatSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FormatSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.FormatSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v0.Developer.FormatSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DeveloperServiceMethodDescriptorSupplier("FormatSchema"))
              .build();
        }
      }
    }
    return getFormatSchemaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeveloperServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceStub>() {
        @java.lang.Override
        public DeveloperServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeveloperServiceStub(channel, callOptions);
        }
      };
    return DeveloperServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeveloperServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceBlockingStub>() {
        @java.lang.Override
        public DeveloperServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeveloperServiceBlockingStub(channel, callOptions);
        }
      };
    return DeveloperServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeveloperServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DeveloperServiceFutureStub>() {
        @java.lang.Override
        public DeveloperServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DeveloperServiceFutureStub(channel, callOptions);
        }
      };
    return DeveloperServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void editCheck(com.authzed.api.v0.Developer.EditCheckRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.EditCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEditCheckMethod(), responseObserver);
    }

    /**
     */
    default void validate(com.authzed.api.v0.Developer.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ValidateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    /**
     */
    default void share(com.authzed.api.v0.Developer.ShareRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getShareMethod(), responseObserver);
    }

    /**
     */
    default void lookupShared(com.authzed.api.v0.Developer.LookupShareRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.LookupShareResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupSharedMethod(), responseObserver);
    }

    /**
     */
    default void upgradeSchema(com.authzed.api.v0.Developer.UpgradeSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.UpgradeSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpgradeSchemaMethod(), responseObserver);
    }

    /**
     */
    default void formatSchema(com.authzed.api.v0.Developer.FormatSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.FormatSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFormatSchemaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DeveloperService.
   */
  public static abstract class DeveloperServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DeveloperServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DeveloperService.
   */
  public static final class DeveloperServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DeveloperServiceStub> {
    private DeveloperServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperServiceStub(channel, callOptions);
    }

    /**
     */
    public void editCheck(com.authzed.api.v0.Developer.EditCheckRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.EditCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEditCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validate(com.authzed.api.v0.Developer.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ValidateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void share(com.authzed.api.v0.Developer.ShareRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lookupShared(com.authzed.api.v0.Developer.LookupShareRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.LookupShareResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupSharedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void upgradeSchema(com.authzed.api.v0.Developer.UpgradeSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.UpgradeSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void formatSchema(com.authzed.api.v0.Developer.FormatSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.FormatSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFormatSchemaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DeveloperService.
   */
  public static final class DeveloperServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperServiceBlockingStub> {
    private DeveloperServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.authzed.api.v0.Developer.EditCheckResponse editCheck(com.authzed.api.v0.Developer.EditCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEditCheckMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.authzed.api.v0.Developer.ValidateResponse validate(com.authzed.api.v0.Developer.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.authzed.api.v0.Developer.ShareResponse share(com.authzed.api.v0.Developer.ShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getShareMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.authzed.api.v0.Developer.LookupShareResponse lookupShared(com.authzed.api.v0.Developer.LookupShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupSharedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.authzed.api.v0.Developer.UpgradeSchemaResponse upgradeSchema(com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeSchemaMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.authzed.api.v0.Developer.FormatSchemaResponse formatSchema(com.authzed.api.v0.Developer.FormatSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFormatSchemaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DeveloperService.
   */
  public static final class DeveloperServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeveloperServiceFutureStub> {
    private DeveloperServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.EditCheckResponse> editCheck(
        com.authzed.api.v0.Developer.EditCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEditCheckMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.ValidateResponse> validate(
        com.authzed.api.v0.Developer.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.ShareResponse> share(
        com.authzed.api.v0.Developer.ShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getShareMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.LookupShareResponse> lookupShared(
        com.authzed.api.v0.Developer.LookupShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupSharedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.UpgradeSchemaResponse> upgradeSchema(
        com.authzed.api.v0.Developer.UpgradeSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeSchemaMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v0.Developer.FormatSchemaResponse> formatSchema(
        com.authzed.api.v0.Developer.FormatSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFormatSchemaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EDIT_CHECK = 0;
  private static final int METHODID_VALIDATE = 1;
  private static final int METHODID_SHARE = 2;
  private static final int METHODID_LOOKUP_SHARED = 3;
  private static final int METHODID_UPGRADE_SCHEMA = 4;
  private static final int METHODID_FORMAT_SCHEMA = 5;

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
        case METHODID_EDIT_CHECK:
          serviceImpl.editCheck((com.authzed.api.v0.Developer.EditCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.EditCheckResponse>) responseObserver);
          break;
        case METHODID_VALIDATE:
          serviceImpl.validate((com.authzed.api.v0.Developer.ValidateRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ValidateResponse>) responseObserver);
          break;
        case METHODID_SHARE:
          serviceImpl.share((com.authzed.api.v0.Developer.ShareRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.ShareResponse>) responseObserver);
          break;
        case METHODID_LOOKUP_SHARED:
          serviceImpl.lookupShared((com.authzed.api.v0.Developer.LookupShareRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.LookupShareResponse>) responseObserver);
          break;
        case METHODID_UPGRADE_SCHEMA:
          serviceImpl.upgradeSchema((com.authzed.api.v0.Developer.UpgradeSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.UpgradeSchemaResponse>) responseObserver);
          break;
        case METHODID_FORMAT_SCHEMA:
          serviceImpl.formatSchema((com.authzed.api.v0.Developer.FormatSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v0.Developer.FormatSchemaResponse>) responseObserver);
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
          getEditCheckMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.EditCheckRequest,
              com.authzed.api.v0.Developer.EditCheckResponse>(
                service, METHODID_EDIT_CHECK)))
        .addMethod(
          getValidateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.ValidateRequest,
              com.authzed.api.v0.Developer.ValidateResponse>(
                service, METHODID_VALIDATE)))
        .addMethod(
          getShareMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.ShareRequest,
              com.authzed.api.v0.Developer.ShareResponse>(
                service, METHODID_SHARE)))
        .addMethod(
          getLookupSharedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.LookupShareRequest,
              com.authzed.api.v0.Developer.LookupShareResponse>(
                service, METHODID_LOOKUP_SHARED)))
        .addMethod(
          getUpgradeSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.UpgradeSchemaRequest,
              com.authzed.api.v0.Developer.UpgradeSchemaResponse>(
                service, METHODID_UPGRADE_SCHEMA)))
        .addMethod(
          getFormatSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v0.Developer.FormatSchemaRequest,
              com.authzed.api.v0.Developer.FormatSchemaResponse>(
                service, METHODID_FORMAT_SCHEMA)))
        .build();
  }

  private static abstract class DeveloperServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeveloperServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.v0.Developer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeveloperService");
    }
  }

  private static final class DeveloperServiceFileDescriptorSupplier
      extends DeveloperServiceBaseDescriptorSupplier {
    DeveloperServiceFileDescriptorSupplier() {}
  }

  private static final class DeveloperServiceMethodDescriptorSupplier
      extends DeveloperServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeveloperServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeveloperServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeveloperServiceFileDescriptorSupplier())
              .addMethod(getEditCheckMethod())
              .addMethod(getValidateMethod())
              .addMethod(getShareMethod())
              .addMethod(getLookupSharedMethod())
              .addMethod(getUpgradeSchemaMethod())
              .addMethod(getFormatSchemaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
