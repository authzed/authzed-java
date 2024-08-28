package com.authzed.api.materialize.v0;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.66.0)",
    comments = "Source: authzed/api/materialize/v0/watchpermissionsets.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WatchPermissionSetsServiceGrpc {

  private WatchPermissionSetsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "authzed.api.materialize.v0.WatchPermissionSetsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionSetsRequest,
      com.authzed.api.materialize.v0.WatchPermissionSetsResponse> getWatchPermissionSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WatchPermissionSets",
      requestType = com.authzed.api.materialize.v0.WatchPermissionSetsRequest.class,
      responseType = com.authzed.api.materialize.v0.WatchPermissionSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionSetsRequest,
      com.authzed.api.materialize.v0.WatchPermissionSetsResponse> getWatchPermissionSetsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.WatchPermissionSetsRequest, com.authzed.api.materialize.v0.WatchPermissionSetsResponse> getWatchPermissionSetsMethod;
    if ((getWatchPermissionSetsMethod = WatchPermissionSetsServiceGrpc.getWatchPermissionSetsMethod) == null) {
      synchronized (WatchPermissionSetsServiceGrpc.class) {
        if ((getWatchPermissionSetsMethod = WatchPermissionSetsServiceGrpc.getWatchPermissionSetsMethod) == null) {
          WatchPermissionSetsServiceGrpc.getWatchPermissionSetsMethod = getWatchPermissionSetsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.materialize.v0.WatchPermissionSetsRequest, com.authzed.api.materialize.v0.WatchPermissionSetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WatchPermissionSets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.WatchPermissionSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.WatchPermissionSetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WatchPermissionSetsServiceMethodDescriptorSupplier("WatchPermissionSets"))
              .build();
        }
      }
    }
    return getWatchPermissionSetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.LookupPermissionSetsRequest,
      com.authzed.api.materialize.v0.LookupPermissionSetsResponse> getLookupPermissionSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupPermissionSets",
      requestType = com.authzed.api.materialize.v0.LookupPermissionSetsRequest.class,
      responseType = com.authzed.api.materialize.v0.LookupPermissionSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.LookupPermissionSetsRequest,
      com.authzed.api.materialize.v0.LookupPermissionSetsResponse> getLookupPermissionSetsMethod() {
    io.grpc.MethodDescriptor<com.authzed.api.materialize.v0.LookupPermissionSetsRequest, com.authzed.api.materialize.v0.LookupPermissionSetsResponse> getLookupPermissionSetsMethod;
    if ((getLookupPermissionSetsMethod = WatchPermissionSetsServiceGrpc.getLookupPermissionSetsMethod) == null) {
      synchronized (WatchPermissionSetsServiceGrpc.class) {
        if ((getLookupPermissionSetsMethod = WatchPermissionSetsServiceGrpc.getLookupPermissionSetsMethod) == null) {
          WatchPermissionSetsServiceGrpc.getLookupPermissionSetsMethod = getLookupPermissionSetsMethod =
              io.grpc.MethodDescriptor.<com.authzed.api.materialize.v0.LookupPermissionSetsRequest, com.authzed.api.materialize.v0.LookupPermissionSetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupPermissionSets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.LookupPermissionSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.authzed.api.materialize.v0.LookupPermissionSetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WatchPermissionSetsServiceMethodDescriptorSupplier("LookupPermissionSets"))
              .build();
        }
      }
    }
    return getLookupPermissionSetsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WatchPermissionSetsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceStub>() {
        @java.lang.Override
        public WatchPermissionSetsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionSetsServiceStub(channel, callOptions);
        }
      };
    return WatchPermissionSetsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WatchPermissionSetsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceBlockingStub>() {
        @java.lang.Override
        public WatchPermissionSetsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionSetsServiceBlockingStub(channel, callOptions);
        }
      };
    return WatchPermissionSetsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WatchPermissionSetsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WatchPermissionSetsServiceFutureStub>() {
        @java.lang.Override
        public WatchPermissionSetsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WatchPermissionSetsServiceFutureStub(channel, callOptions);
        }
      };
    return WatchPermissionSetsServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * WatchPermissionSets returns a stream of changes to the sets which can be used to compute the watched permissions.
     * WatchPermissionSets lets consumers achieve the same thing as WatchPermissions, but trades off a simpler usage model with
     * significantly lower computational requirements. Unlike WatchPermissions, this method returns changes to the sets of permissions,
     * rather than the individual permissions. Permission sets are a normalized form of the computed permissions, which
     * means that the consumer must perform an extra computation over this representation to obtain the final computed
     * permissions, typically by intersecting the provided sets.
     * For example, this would look like a JOIN between the
     * materialize permission sets table in a target relation database, the table with the resources to authorize access
     * to, and the table with the subject (e.g. a user).
     * In exchange, the number of changes issued by WatchPermissionSets will be several orders of magnitude less than those
     * emitted by WatchPermissions, which has several implications:
     * - significantly less resources to compute the sets
     * - significantly less messages to stream over the network
     * - significantly less events to ingest on the consumer side
     * - less ingestion lag from the origin SpiceDB mutation
     * The type of scenarios WatchPermissionSets is particularly well suited is when a single change
     * in the origin SpiceDB can yield millions of changes. For example, in the GitHub authorization model, assigning a role
     * to a top-level team of an organization with hundreds of thousands of employees can lead to an explosion of
     * permission change events that would require a lot of computational resources to process, both on Materialize and
     * the consumer side.
     * WatchPermissionSets is thus recommended for any larger scale use case where the fan-out in permission changes that
     * emerges from a specific schema and data shape is too large to handle effectively.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * </pre>
     */
    default void watchPermissionSets(com.authzed.api.materialize.v0.WatchPermissionSetsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWatchPermissionSetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * LookupPermissionSets returns the current state of the permission sets which can be used to derive the computed permissions.
     * It's typically used to backfill the state of the permission sets in the consumer side.
     * It's a cursored API and the consumer is responsible to keep track of the cursor and use it on each subsequent call.
     * Each stream will return &lt;N&gt; permission sets defined by the specified request limit. The server will keep streaming until
     * the sets per stream is hit, or the current state of the sets is reached,
     * whatever happens first, and then close the stream. The server will indicate there are no more changes to stream
     * through the `completed_members` in the cursor.
     * There may be many elements to stream, and so the consumer should be prepared to resume the stream from the last
     * cursor received. Once completed, the consumer may start streaming permission set changes using WatchPermissionSets
     * and the revision token from the last LookupPermissionSets response.
     * </pre>
     */
    default void lookupPermissionSets(com.authzed.api.materialize.v0.LookupPermissionSetsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupPermissionSetsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WatchPermissionSetsService.
   */
  public static abstract class WatchPermissionSetsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WatchPermissionSetsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WatchPermissionSetsService.
   */
  public static final class WatchPermissionSetsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WatchPermissionSetsServiceStub> {
    private WatchPermissionSetsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionSetsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionSetsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * WatchPermissionSets returns a stream of changes to the sets which can be used to compute the watched permissions.
     * WatchPermissionSets lets consumers achieve the same thing as WatchPermissions, but trades off a simpler usage model with
     * significantly lower computational requirements. Unlike WatchPermissions, this method returns changes to the sets of permissions,
     * rather than the individual permissions. Permission sets are a normalized form of the computed permissions, which
     * means that the consumer must perform an extra computation over this representation to obtain the final computed
     * permissions, typically by intersecting the provided sets.
     * For example, this would look like a JOIN between the
     * materialize permission sets table in a target relation database, the table with the resources to authorize access
     * to, and the table with the subject (e.g. a user).
     * In exchange, the number of changes issued by WatchPermissionSets will be several orders of magnitude less than those
     * emitted by WatchPermissions, which has several implications:
     * - significantly less resources to compute the sets
     * - significantly less messages to stream over the network
     * - significantly less events to ingest on the consumer side
     * - less ingestion lag from the origin SpiceDB mutation
     * The type of scenarios WatchPermissionSets is particularly well suited is when a single change
     * in the origin SpiceDB can yield millions of changes. For example, in the GitHub authorization model, assigning a role
     * to a top-level team of an organization with hundreds of thousands of employees can lead to an explosion of
     * permission change events that would require a lot of computational resources to process, both on Materialize and
     * the consumer side.
     * WatchPermissionSets is thus recommended for any larger scale use case where the fan-out in permission changes that
     * emerges from a specific schema and data shape is too large to handle effectively.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * </pre>
     */
    public void watchPermissionSets(com.authzed.api.materialize.v0.WatchPermissionSetsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWatchPermissionSetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LookupPermissionSets returns the current state of the permission sets which can be used to derive the computed permissions.
     * It's typically used to backfill the state of the permission sets in the consumer side.
     * It's a cursored API and the consumer is responsible to keep track of the cursor and use it on each subsequent call.
     * Each stream will return &lt;N&gt; permission sets defined by the specified request limit. The server will keep streaming until
     * the sets per stream is hit, or the current state of the sets is reached,
     * whatever happens first, and then close the stream. The server will indicate there are no more changes to stream
     * through the `completed_members` in the cursor.
     * There may be many elements to stream, and so the consumer should be prepared to resume the stream from the last
     * cursor received. Once completed, the consumer may start streaming permission set changes using WatchPermissionSets
     * and the revision token from the last LookupPermissionSets response.
     * </pre>
     */
    public void lookupPermissionSets(com.authzed.api.materialize.v0.LookupPermissionSetsRequest request,
        io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLookupPermissionSetsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WatchPermissionSetsService.
   */
  public static final class WatchPermissionSetsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WatchPermissionSetsServiceBlockingStub> {
    private WatchPermissionSetsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionSetsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionSetsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * WatchPermissionSets returns a stream of changes to the sets which can be used to compute the watched permissions.
     * WatchPermissionSets lets consumers achieve the same thing as WatchPermissions, but trades off a simpler usage model with
     * significantly lower computational requirements. Unlike WatchPermissions, this method returns changes to the sets of permissions,
     * rather than the individual permissions. Permission sets are a normalized form of the computed permissions, which
     * means that the consumer must perform an extra computation over this representation to obtain the final computed
     * permissions, typically by intersecting the provided sets.
     * For example, this would look like a JOIN between the
     * materialize permission sets table in a target relation database, the table with the resources to authorize access
     * to, and the table with the subject (e.g. a user).
     * In exchange, the number of changes issued by WatchPermissionSets will be several orders of magnitude less than those
     * emitted by WatchPermissions, which has several implications:
     * - significantly less resources to compute the sets
     * - significantly less messages to stream over the network
     * - significantly less events to ingest on the consumer side
     * - less ingestion lag from the origin SpiceDB mutation
     * The type of scenarios WatchPermissionSets is particularly well suited is when a single change
     * in the origin SpiceDB can yield millions of changes. For example, in the GitHub authorization model, assigning a role
     * to a top-level team of an organization with hundreds of thousands of employees can lead to an explosion of
     * permission change events that would require a lot of computational resources to process, both on Materialize and
     * the consumer side.
     * WatchPermissionSets is thus recommended for any larger scale use case where the fan-out in permission changes that
     * emerges from a specific schema and data shape is too large to handle effectively.
     * The API does not offer a sharding mechanism and thus there should only be one consumer per target system.
     * Implementing an active-active HA consumer setup over the same target system will require coordinating which
     * revisions have been consumed in order to prevent transitioning to an inconsistent state.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.materialize.v0.WatchPermissionSetsResponse> watchPermissionSets(
        com.authzed.api.materialize.v0.WatchPermissionSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWatchPermissionSetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * LookupPermissionSets returns the current state of the permission sets which can be used to derive the computed permissions.
     * It's typically used to backfill the state of the permission sets in the consumer side.
     * It's a cursored API and the consumer is responsible to keep track of the cursor and use it on each subsequent call.
     * Each stream will return &lt;N&gt; permission sets defined by the specified request limit. The server will keep streaming until
     * the sets per stream is hit, or the current state of the sets is reached,
     * whatever happens first, and then close the stream. The server will indicate there are no more changes to stream
     * through the `completed_members` in the cursor.
     * There may be many elements to stream, and so the consumer should be prepared to resume the stream from the last
     * cursor received. Once completed, the consumer may start streaming permission set changes using WatchPermissionSets
     * and the revision token from the last LookupPermissionSets response.
     * </pre>
     */
    public java.util.Iterator<com.authzed.api.materialize.v0.LookupPermissionSetsResponse> lookupPermissionSets(
        com.authzed.api.materialize.v0.LookupPermissionSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLookupPermissionSetsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WatchPermissionSetsService.
   */
  public static final class WatchPermissionSetsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WatchPermissionSetsServiceFutureStub> {
    private WatchPermissionSetsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchPermissionSetsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WatchPermissionSetsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATCH_PERMISSION_SETS = 0;
  private static final int METHODID_LOOKUP_PERMISSION_SETS = 1;

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
        case METHODID_WATCH_PERMISSION_SETS:
          serviceImpl.watchPermissionSets((com.authzed.api.materialize.v0.WatchPermissionSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.WatchPermissionSetsResponse>) responseObserver);
          break;
        case METHODID_LOOKUP_PERMISSION_SETS:
          serviceImpl.lookupPermissionSets((com.authzed.api.materialize.v0.LookupPermissionSetsRequest) request,
              (io.grpc.stub.StreamObserver<com.authzed.api.materialize.v0.LookupPermissionSetsResponse>) responseObserver);
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
          getWatchPermissionSetsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.materialize.v0.WatchPermissionSetsRequest,
              com.authzed.api.materialize.v0.WatchPermissionSetsResponse>(
                service, METHODID_WATCH_PERMISSION_SETS)))
        .addMethod(
          getLookupPermissionSetsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.authzed.api.materialize.v0.LookupPermissionSetsRequest,
              com.authzed.api.materialize.v0.LookupPermissionSetsResponse>(
                service, METHODID_LOOKUP_PERMISSION_SETS)))
        .build();
  }

  private static abstract class WatchPermissionSetsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WatchPermissionSetsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.authzed.api.materialize.v0.Watchpermissionsets.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WatchPermissionSetsService");
    }
  }

  private static final class WatchPermissionSetsServiceFileDescriptorSupplier
      extends WatchPermissionSetsServiceBaseDescriptorSupplier {
    WatchPermissionSetsServiceFileDescriptorSupplier() {}
  }

  private static final class WatchPermissionSetsServiceMethodDescriptorSupplier
      extends WatchPermissionSetsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WatchPermissionSetsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WatchPermissionSetsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WatchPermissionSetsServiceFileDescriptorSupplier())
              .addMethod(getWatchPermissionSetsMethod())
              .addMethod(getLookupPermissionSetsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
