package grpc.eBank.login;

import java.io.IOException;

import grpc.eBank.login.LoginServiceGrpc;
import grpc.eBank.login.LoginServiceGrpc.LoginServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LoginServer extends LoginServiceImplBase {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Starting gRPC Login Server");
		LoginServer userserver = new LoginServer();
		
		//Registration
		int port = 50050;
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port,"_http_tcp_local.", "LoginServer");

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(userserver)
					.build()
					.start();

			System.out.println("Server started with Port:" + server.getPort());
		    server.awaitTermination();

		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}

	}//main

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		System.out.println("Initiating login");
		String username = request.getUsername();
		String password = request.getPassword();

		LoginResponse.Builder response = LoginResponse.newBuilder();
		System.out.println("username1 = " + username + ", password = " + password);

		if(username.equalsIgnoreCase("Esteban") && password.equals("InVino")) {
			// return Success response
			response.setResponseMessage(username + "...You are logged in").setLogIn(true);
		}
		else {
			// return Success response
			response.setResponseMessage(username + "...Login Failed").setLogIn(false);
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}


	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		System.out.println("Initiatin logout");
		String username = request.getUsername();

		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("Logging out username = " + username);

		if(username.equalsIgnoreCase("Esteban")) {
			// return Success response
			response.setResponseMessage(username + "....You have been logged out").setLogIn(false);
		}
		else {
			// return Success response
			response.setResponseMessage(username +
					"...Logout Failed, can't find " + username);
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
