package grpc.eBank.account;

import grpc.eBank.account.TransactionRequest;
import grpc.eBank.account.TransactionsResponse;

import java.util.Iterator;
import java.util.Random;

import grpc.eBank.account.BalanceServiceGrpc;
import grpc.eBank.account.BalanceServiceGrpc.BalanceServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class AccountClient {
	private static BalanceServiceGrpc.BalanceServiceBlockingStub blockingStub;
	private static BalanceServiceGrpc.BalanceServiceStub asyncStub;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

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
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-59).build());
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-400).build());
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-18.5).build());
				requestObserver.onNext(UpdatedBalanceRequest.newBuilder().setBalance(-33.60).build());

				System.out.println("SENDING MESSAGES");

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
