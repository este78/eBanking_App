package grpc.eBank.login;


import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class LoginGUIClient {
	private static LoginServiceGrpc.LoginServiceBlockingStub blockingStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();*/
		String host = "localhost";
		int port = 50050;
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingStub = LoginServiceGrpc.newBlockingStub(channel);


		//Call the login RPC from login() method
		login();

		//Call the logout RPC from logout() method
		//logout();
	}

	//Login
	public static void login() {
		//console output
		System.out.println("Inside Login in Client: ");
		//GUI for name and password. Only one Implemented: User Name "Esteban, Password InVino.
		String userName = JOptionPane.showInputDialog(null, "Enter your name to login: ");
		String password = JOptionPane.showInputDialog(null, "Enter your password: ");

		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername(userName).setPassword(password).build();

		LoginResponse response = blockingStub.login(loginRequest);

		JOptionPane.showMessageDialog(null,"Server: "+ response.getResponseMessage());
		
		//In case the login is succesful the gui will present the option to logout, otherwise it will show the login screen
		if(response.getLogIn()==true) {
			logout(userName);
		}
		else {
			login();
		}
	}

	//Logout
	public static void logout(String userName) {
		System.out.println("Inside Logout in Client: ");
		JOptionPane.showMessageDialog(null, userName + ", Click Ok to logout");
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername(userName).build();

		LogoutResponse response = blockingStub.logout(logoutRequest);
		JOptionPane.showMessageDialog(null,"Server: "+ response.getResponseMessage());
		System.out.println("Server: " + response );
	}
}
