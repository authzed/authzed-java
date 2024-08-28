package com.authzed.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * SchemaService implements operations on a Permissions System's Schema.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/v1/schema_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SchemaServiceGrpc {

  private SchemaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.v1.SchemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest,
      com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadSchema",
      requestType = com.authzed.api.v1.ReadSchemaRequest.class,
      responseType = com.authzed.api.v1.ReadSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest,
      com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse> getReadSchemaMethod;
    if ((getReadSchemaMethod = SchemaServiceGrpc.getReadSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getReadSchemaMethod = SchemaServiceGrpc.getReadSchemaMethod) == null) {
          SchemaServiceGrpc.getReadSchemaMethod = getReadSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.ReadSchemaRequest, com.authzed.api.v1.ReadSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ReadSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.ReadSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ReadSchema"))
              .build();
        }
      }
    }
    return getReadSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest,
      com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WriteSchema",
      requestType = com.authzed.api.v1.WriteSchemaRequest.class,
      responseType = com.authzed.api.v1.WriteSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest,
      com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse> getWriteSchemaMethod;
    if ((getWriteSchemaMethod = SchemaServiceGrpc.getWriteSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getWriteSchemaMethod = SchemaServiceGrpc.getWriteSchemaMethod) == null) {
          SchemaServiceGrpc.getWriteSchemaMethod = getWriteSchemaMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.v1.WriteSchemaRequest, com.authzed.api.v1.WriteSchemaResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WriteSchema"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WriteSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.v1.WriteSchemaResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("WriteSchema"))
              .build();
        }
      }
    }
    return getWriteSchemaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SchemaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub>() {
        @java.lang.Override
        public SchemaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SchemaServiceStub(channel, callOptions);
        }
      };
    return SchemaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SchemaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub>() {
        @java.lang.Override
        public SchemaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SchemaServiceBlockingStub(channel, callOptions);
        }
      };
    return SchemaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SchemaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub>() {
        @java.lang.Override
        public SchemaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SchemaServiceFutureStub(channel, callOptions);
        }
      };
    return SchemaServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * SchemaService implements operations on a Permissions System's Schema.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Read returns the current Object Definitions for a Permissions System.
     * Errors include:
     * - INVALID_ARGUMENT: a provided value has failed to semantically validate
     * - NOT_FOUND: no schema has been defined
     * </pre>
     */
    default void readSchema(com.authzed.api.v1.ReadSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadSchemaMethod(), responseObserver);
    }

    /**
     * <pre>
     * Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    default void writeSchema(com.authzed.api.v1.WriteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWriteSchemaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SchemaService.
   * <pre>
   * SchemaService implements operations on a Permissions System's Schema.
   * </pre>
   */
  public static abstract class SchemaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SchemaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SchemaService.
   * <pre>
   * SchemaService implements operations on a Permissions System's Schema.
   * </pre>
   */
  public static final class SchemaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SchemaServiceStub> {
    private SchemaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Read returns the current Object Definitions for a Permissions System.
     * Errors include:
     * - INVALID_ARGUMENT: a provided value has failed to semantically validate
     * - NOT_FOUND: no schema has been defined
     * </pre>
     */
    public void readSchema(com.authzed.api.v1.ReadSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    public void writeSchema(com.authzed.api.v1.WriteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWriteSchemaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SchemaService.
   * <pre>
   * SchemaService implements operations on a Permissions System's Schema.
   * </pre>
   */
  public static final class SchemaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SchemaServiceBlockingStub> {
    private SchemaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Read returns the current Object Definitions for a Permissions System.
     * Errors include:
     * - INVALID_ARGUMENT: a provided value has failed to semantically validate
     * - NOT_FOUND: no schema has been defined
     * </pre>
     */
    public com.authzed.api.v1.ReadSchemaResponse readSchema(com.authzed.api.v1.ReadSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadSchemaMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    public com.authzed.api.v1.WriteSchemaResponse writeSchema(com.authzed.api.v1.WriteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWriteSchemaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SchemaService.
   * <pre>
   * SchemaService implements operations on a Permissions System's Schema.
   * </pre>
   */
  public static final class SchemaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SchemaServiceFutureStub> {
    private SchemaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Read returns the current Object Definitions for a Permissions System.
     * Errors include:
     * - INVALID_ARGUMENT: a provided value has failed to semantically validate
     * - NOT_FOUND: no schema has been defined
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.ReadSchemaResponse> readSchema(
        com.authzed.api.v1.ReadSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadSchemaMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Write overwrites the current Object Definitions for a Permissions System.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.authzed.api.v1.WriteSchemaResponse> writeSchema(
        com.authzed.api.v1.WriteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWriteSchemaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_READ_SCHEMA = 0;
  private static final int METHODID_WRITE_SCHEMA = 1;

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
        case METHODID_READ_SCHEMA:
          serviceImpl.readSchema((com.authzed.api.v1.ReadSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.ReadSchemaResponse>) responseObserver);
          break;
        case METHODID_WRITE_SCHEMA:
          serviceImpl.writeSchema((com.authzed.api.v1.WriteSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.v1.WriteSchemaResponse>) responseObserver);
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
          getReadSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.ReadSchemaRequest,
              com.authzed.api.v1.ReadSchemaResponse>(
                service, METHODID_READ_SCHEMA)))
        .addMethod(
          getWriteSchemaMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.authzed.api.v1.WriteSchemaRequest,
              com.authzed.api.v1.WriteSchemaResponse>(
                service, METHODID_WRITE_SCHEMA)))
        .build();
  }

  private static abstract class SchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SchemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.v1.SchemaServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SchemaService");
    }
  }

  private static final class SchemaServiceFileDescriptorSupplier
      extends SchemaServiceBaseDescriptorSupplier {
    SchemaServiceFileDescriptorSupplier() {}
  }

  private static final class SchemaServiceMethodDescriptorSupplier
      extends SchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SchemaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SchemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SchemaServiceFileDescriptorSupplier())
              .addMethod(getReadSchemaMethod())
              .addMethod(getWriteSchemaMethod())
              .build();
        }
      }
    }
    return result;
  }
}
