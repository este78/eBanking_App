// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: microserv2.proto

package grpc.eBank.payments;

public interface PaymentRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:payments.PaymentRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string accountFrom = 1;</code>
   */
  java.lang.String getAccountFrom();
  /**
   * <code>string accountFrom = 1;</code>
   */
  com.google.protobuf.ByteString
      getAccountFromBytes();

  /**
   * <code>string accountTo = 2;</code>
   */
  java.lang.String getAccountTo();
  /**
   * <code>string accountTo = 2;</code>
   */
  com.google.protobuf.ByteString
      getAccountToBytes();

  /**
   * <code>float amount = 3;</code>
   */
  float getAmount();
}
