package grpc.eBank.payments;

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
    comments = "Source: microserv2.proto")
public final class PaymentServiceGrpc {

  private PaymentServiceGrpc() {}

  public static final String SERVICE_NAME = "payments.PaymentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.eBank.payments.PaymentRequest,
      grpc.eBank.payments.UpdateBalanceResponse> getSendMultiplePaymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMultiplePayments",
      requestType = grpc.eBank.payments.PaymentRequest.class,
      responseType = grpc.eBank.payments.UpdateBalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.eBank.payments.PaymentRequest,
      grpc.eBank.payments.UpdateBalanceResponse> getSendMultiplePaymentsMethod() {
    io.grpc.MethodDescriptor<grpc.eBank.payments.PaymentRequest, grpc.eBank.payments.UpdateBalanceResponse> getSendMultiplePaymentsMethod;
    if ((getSendMultiplePaymentsMethod = PaymentServiceGrpc.getSendMultiplePaymentsMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getSendMultiplePaymentsMethod = PaymentServiceGrpc.getSendMultiplePaymentsMethod) == null) {
          PaymentServiceGrpc.getSendMultiplePaymentsMethod = getSendMultiplePaymentsMethod = 
              io.grpc.MethodDescriptor.<grpc.eBank.payments.PaymentRequest, grpc.eBank.payments.UpdateBalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "payments.PaymentService", "sendMultiplePayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.payments.PaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.eBank.payments.UpdateBalanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("sendMultiplePayments"))
                  .build();
          }
        }
     }
     return getSendMultiplePaymentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PaymentServiceStub newStub(io.grpc.Channel channel) {
    return new PaymentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PaymentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PaymentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PaymentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PaymentServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class PaymentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *sends multiple payments to single/multiple account(s) and returns an updated balance of the account(s) used to send the payment from
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.eBank.payments.PaymentRequest> sendMultiplePayments(
        io.grpc.stub.StreamObserver<grpc.eBank.payments.UpdateBalanceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendMultiplePaymentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMultiplePaymentsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.eBank.payments.PaymentRequest,
                grpc.eBank.payments.UpdateBalanceResponse>(
                  this, METHODID_SEND_MULTIPLE_PAYMENTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PaymentServiceStub extends io.grpc.stub.AbstractStub<PaymentServiceStub> {
    private PaymentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *sends multiple payments to single/multiple account(s) and returns an updated balance of the account(s) used to send the payment from
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.eBank.payments.PaymentRequest> sendMultiplePayments(
        io.grpc.stub.StreamObserver<grpc.eBank.payments.UpdateBalanceResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendMultiplePaymentsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PaymentServiceBlockingStub extends io.grpc.stub.AbstractStub<PaymentServiceBlockingStub> {
    private PaymentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PaymentServiceFutureStub extends io.grpc.stub.AbstractStub<PaymentServiceFutureStub> {
    private PaymentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PaymentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PaymentServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_MULTIPLE_PAYMENTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PaymentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PaymentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MULTIPLE_PAYMENTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendMultiplePayments(
              (io.grpc.stub.StreamObserver<grpc.eBank.payments.UpdateBalanceResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PaymentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.eBank.payments.PaymentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PaymentService");
    }
  }

  private static final class PaymentServiceFileDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier {
    PaymentServiceFileDescriptorSupplier() {}
  }

  private static final class PaymentServiceMethodDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PaymentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PaymentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PaymentServiceFileDescriptorSupplier())
              .addMethod(getSendMultiplePaymentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
