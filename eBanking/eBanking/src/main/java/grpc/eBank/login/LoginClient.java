package grpc.eBank.login;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LoginClient {
	private static LoginServiceGrpc.LoginServiceBlockingStub blockingStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Attempt at Service discovery. It returns an invalid port number and crashes
				//ServiceInfo serviceInfo;
				//String service_type = "_grpc._tcp.local.";
				//serviceInfo = SimpleServiceDiscovery.run(service_type);
				//int port = serviceInfo.getPort();
		int port= 50050;
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build();

		blockingStub = LoginServiceGrpc.newBlockingStub(channel);

		
		try{
			//Call the login RPC from login() method
			login();
			Thread.sleep(5000);
			//Call the logout RPC from logout() method
			logout();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	//Login
	public static void login() {
		System.out.println("Inside Login in Client: ");

		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Esteban").setPassword("InVino").build();

		LoginResponse response = blockingStub.login(loginRequest);

		System.out.println("Response from Server: " + response);
	}

	//Logout
	public static void logout() {
		System.out.println("Inside Logout in Client: ");

		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Esteban").build();

		LogoutResponse response = blockingStub.logout(logoutRequest);

		System.out.println("Response from Server: " + response);
	}
}
