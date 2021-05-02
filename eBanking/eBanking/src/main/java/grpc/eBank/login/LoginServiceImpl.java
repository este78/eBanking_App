// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: microserv.proto

package grpc.eBank.login;

public final class LoginServiceImpl {
  private LoginServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_login_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_login_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_login_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_login_LoginResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_login_LogoutRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_login_LogoutRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_login_LogoutResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_login_LogoutResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017microserv.proto\022\005login\"2\n\014LoginRequest" +
      "\022\020\n\010username\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"M\n\r" +
      "LoginResponse\022\027\n\017responseMessage\030\001 \001(\t\022\024" +
      "\n\014responseCode\030\002 \001(\005\022\r\n\005logIn\030\003 \001(\010\"!\n\rL" +
      "ogoutRequest\022\020\n\010username\030\001 \001(\t\"?\n\016Logout" +
      "Response\022\027\n\017responseMessage\030\001 \001(\t\022\024\n\014res" +
      "ponseCode\030\002 \001(\0052}\n\014LoginService\0224\n\005login" +
      "\022\023.login.LoginRequest\032\024.login.LoginRespo" +
      "nse\"\000\0227\n\006logout\022\024.login.LogoutRequest\032\025." +
      "login.LogoutResponse\"\000B&\n\020grpc.eBank.log" +
      "inB\020LoginServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_login_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_login_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_login_LoginRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_login_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_login_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_login_LoginResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", "LogIn", });
    internal_static_login_LogoutRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_login_LogoutRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_login_LogoutRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_login_LogoutResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_login_LogoutResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_login_LogoutResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "ResponseCode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
