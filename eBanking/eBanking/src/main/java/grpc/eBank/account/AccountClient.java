package grpc.eBank.account;


import java.util.Iterator;
import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class AccountClient {

	private static BalanceServiceGrpc.BalanceServiceBlockingStub blockingStub;
	private static BalanceServiceGrpc.BalanceServiceStub asyncStub;

	public static void main(String[] args) {
		
		// Attempt at Service discovery. It returns an invalid port number and crashes
		//ServiceInfo serviceInfo;
		//String service_type = "_grpc._tcp.local.";
		//serviceInfo = SimpleServiceDiscovery.run(service_type);
		//int port = serviceInfo.getPort();
		
		int port = 50051;
		String host = "localhost";
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		blockingStub = BalanceServiceGrpc.newBlockingStub(channel);
		asyncStub = BalanceServiceGrpc.newStub(channel);


		//Call the login RPC from login() method
		requestTransactionHistory();

		//Call the logout RPC from logout() method
		getBalance();
	}
	//server side streaming
	public static void requestTransactionHistory() {
		
		TransactionRequest transactionRequest = TransactionRequest.newBuilder().setAccount("Account1").setNumber(5).build();
		System.out.println("Requesting transaction history: "+transactionRequest.getAccount());
		try {
			Iterator<TransactionsResponse> responses = blockingStub.requestTransactionHistory(transactionRequest);

			while(responses.hasNext()) {
				TransactionsResponse temp = responses.next();
				System.out.println(temp.getEntity()+ " "+ temp.getAmount());				
			}

		} catch (StatusRuntimeException e) {
			e.printStackTrace();
		}
		
	}
	//Client side streaming
	public static void getBalance() {

			StreamObserver<UpdatedBalanceResponse> responseObserver = new StreamObserver<UpdatedBalanceResponse>() {

				@Override
				public void onNext(UpdatedBalanceResponse value) {
					System.out.println("receiving balance: " + value.getAccumulatedBalance() );
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onCompleted() {
					System.out.println("completed ");

				}

			};

			//
			StreamObserver<UpdatedBalanceRequest> requestObserver = asyncStub.getBalance(responseObserver);

			try {
				//{3000, -59, -400, -18.5, -33.60}
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(3000).build());
				Thread.sleep(new Random().nextInt(1000) + 500);
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-59).build());
				Thread.sleep(new Random().nextInt(1000) + 500);
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-400).build());
				Thread.sleep(new Random().nextInt(1000) + 500);
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-18.5).build());
				Thread.sleep(new Random().nextInt(1000) + 500);
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-33.60).build());

				System.out.println("GetBalance: SENDING MESSAGES");

				// Mark the end of requests
				requestObserver.onCompleted();


				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 500);


			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
}
