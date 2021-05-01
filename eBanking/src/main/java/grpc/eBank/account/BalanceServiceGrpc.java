package grpc.eBank.account;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: microserv1.proto")
public final class BalanceServiceGrpc {

  private BalanceServiceGrpc() {}

  public static final String SERVICE_NAME = "account.BalanceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.eBank.account.TransactionRequest,
      grpc.eBank.account.TransactionsResponse> getRequestTransactionHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "requestTransactionHistory",
      requestType = grpc.eBank.account.TransactionRequest.class,
      responseType = grpc.eBank.account.TransactionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.eBank.account.TransactionRequest,
      grpc.eBank.account.TransactionsResponse> getRequestTransactionHistoryMethod() {
    io.grpc.MethodDescriptor<grpc.eBank.account.TransactionRequest, grpc.eBank.account.TransactionsResponse> getRequestTransactionHistoryMethod;
    if ((getRequestTransactionHistoryMethod = BalanceServiceGrpc.getRequestTransactionHistoryMethod) == null) {
      synchronized (BalanceServiceGrpc.class) {
        if ((getRequestTransactionHistoryMethod = BalanceServiceGrpc.getRequestTransactionHistoryMethod) == null) {
          BalanceServiceGrpc.getRequestTransactionHistoryMethod = getRequestTransactionHistoryMethod = 
              io.grpc.MethodDescriptor.<grpc.eBank.account.TransactionRequest, grpc.eBank.account.TransactionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "account.BalanceService", "requestTransactionHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.account.TransactionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.account.TransactionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceServiceMethodDescriptorSupplier("requestTransactionHistory"))
                  .build();
          }
        }
     }
     return getRequestTransactionHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.eBank.account.UpdatedBalanceRequest,
      grpc.eBank.account.UpdatedBalanceResponse> getGetBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBalance",
      requestType = grpc.eBank.account.UpdatedBalanceRequest.class,
      responseType = grpc.eBank.account.UpdatedBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.eBank.account.UpdatedBalanceRequest,
      grpc.eBank.account.UpdatedBalanceResponse> getGetBalanceMethod() {
    io.grpc.MethodDescriptor<grpc.eBank.account.UpdatedBalanceRequest, grpc.eBank.account.UpdatedBalanceResponse> getGetBalanceMethod;
    if ((getGetBalanceMethod = BalanceServiceGrpc.getGetBalanceMethod) == null) {
      synchronized (BalanceServiceGrpc.class) {
        if ((getGetBalanceMethod = BalanceServiceGrpc.getGetBalanceMethod) == null) {
          BalanceServiceGrpc.getGetBalanceMethod = getGetBalanceMethod = 
              io.grpc.MethodDescriptor.<grpc.eBank.account.UpdatedBalanceRequest, grpc.eBank.account.UpdatedBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "account.BalanceService", "getBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.account.UpdatedBalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.account.UpdatedBalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BalanceServiceMethodDescriptorSupplier("getBalance"))
                  .build();
          }
        }
     }
     return getGetBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BalanceServiceStub newStub(io.grpc.Channel channel) {
    return new BalanceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BalanceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BalanceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BalanceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BalanceServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class BalanceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *sends a request to get the last few(5) transactions in a particular account
     * </pre>
     */
    public void requestTransactionHistory(grpc.eBank.account.TransactionRequest request,
        io.grpc.stub.StreamObserver<grpc.eBank.account.TransactionsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestTransactionHistoryMethod(), responseObserver);
    }

    /**
     * <pre>
     *gets the balance of multiple accounts a user may have, and returns the accumulated balance
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.eBank.account.UpdatedBalanceRequest> getBalance(
        io.grpc.stub.StreamObserver<grpc.eBank.account.UpdatedBalanceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestTransactionHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.eBank.account.TransactionRequest,
                grpc.eBank.account.TransactionsResponse>(
                  this, METHODID_REQUEST_TRANSACTION_HISTORY)))
          .addMethod(
            getGetBalanceMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.eBank.account.UpdatedBalanceRequest,
                grpc.eBank.account.UpdatedBalanceResponse>(
                  this, METHODID_GET_BALANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BalanceServiceStub extends io.grpc.stub.AbstractStub<BalanceServiceStub> {
    private BalanceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *sends a request to get the last few(5) transactions in a particular account
     * </pre>
     */
    public void requestTransactionHistory(grpc.eBank.account.TransactionRequest request,
        io.grpc.stub.StreamObserver<grpc.eBank.account.TransactionsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRequestTransactionHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *gets the balance of multiple accounts a user may have, and returns the accumulated balance
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.eBank.account.UpdatedBalanceRequest> getBalance(
        io.grpc.stub.StreamObserver<grpc.eBank.account.UpdatedBalanceResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BalanceServiceBlockingStub extends io.grpc.stub.AbstractStub<BalanceServiceBlockingStub> {
    private BalanceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *sends a request to get the last few(5) transactions in a particular account
     * </pre>
     */
    public java.util.Iterator<grpc.eBank.account.TransactionsResponse> requestTransactionHistory(
        grpc.eBank.account.TransactionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getRequestTransactionHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BalanceServiceFutureStub extends io.grpc.stub.AbstractStub<BalanceServiceFutureStub> {
    private BalanceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BalanceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BalanceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BalanceServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_REQUEST_TRANSACTION_HISTORY = 0;
  private static final int METHODID_GET_BALANCE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BalanceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BalanceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST_TRANSACTION_HISTORY:
          serviceImpl.requestTransactionHistory((grpc.eBank.account.TransactionRequest) request,
              (io.grpc.stub.StreamObserver<grpc.eBank.account.TransactionsResponse>) responseObserver);
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
        case METHODID_GET_BALANCE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getBalance(
              (io.grpc.stub.StreamObserver<grpc.eBank.account.UpdatedBalanceResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BalanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BalanceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.eBank.account.BalanceServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BalanceService");
    }
  }

  private static final class BalanceServiceFileDescriptorSupplier
      extends BalanceServiceBaseDescriptorSupplier {
    BalanceServiceFileDescriptorSupplier() {}
  }

  private static final class BalanceServiceMethodDescriptorSupplier
      extends BalanceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BalanceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BalanceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BalanceServiceFileDescriptorSupplier())
              .addMethod(getRequestTransactionHistoryMethod())
              .addMethod(getGetBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
