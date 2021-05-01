package grpc.eBank.account;

import java.io.IOException;
import java.util.logging.Logger;

import grpc.eBank.payments.PaymentServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import grpc.eBank.account.BalanceServiceGrpc.BalanceServiceImplBase;

import java.util.Iterator;
import java.util.logging.Logger;


import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


public class AccountServer extends BalanceServiceImplBase {
	
	private static final Logger logger = Logger.getLogger(AccountServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 	AccountServer accountserver = new AccountServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(accountserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	 
	 @Override
	 public void requestTransactionHistory (TransactionRequest request, StreamObserver<TransactionsResponse> responseObserver) {
		 	
			//hard coded 2 accounts as an example
			String [] accounts = {"account1", "account2"};
			String [] account1 = {"Trinity Plaza Ltd.", "Airtricity", "ESB Mortgage","Greyhound", "Sky"};
			double [] account1subtotals = {3000, -59, -400, -18.5, -33.60};
			String [] account2 = {"SuperValu", "Account 1", "Netflix","Amazon", "Post Office"};
			double [] account2subtotals = {-67.56, 100, -14.5, -25.78, -13.60};
		
			//iterate through the array of transactions and output the entity and amount
			if(request.getAccount().equalsIgnoreCase("account1")) {
				for(int j= request.getNumber()-1 ; j>=0 ;j--) {
					TransactionsResponse reply = TransactionsResponse.newBuilder().setEntity(account1[j]).setAmount(account1subtotals[j]).build();
					System.out.println(account1[j] + " "+ account1subtotals[j]);
					responseObserver.onNext(reply);
					try {
						//wait for a second
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				responseObserver.onCompleted();
			}	
			//second account details
			else if(request.getAccount().equalsIgnoreCase("account2")) {
				for(int k =request.getNumber()-1; k>=0;k--) {
					TransactionsResponse reply = TransactionsResponse.newBuilder().setEntity(account2[k]).setAmount(account2subtotals[k]).build();
					System.out.println(account2[k] + " "+ account2subtotals[k]);
					responseObserver.onNext(reply);
					try {
						//wait for a second
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				responseObserver.onCompleted();
			}
			//in case the request is not recognised. i.g "Account900" or " "
			else {
				TransactionsResponse reply = TransactionsResponse.newBuilder().setEntity("Null").setAmount(0).build();
				System.out.println("Account not found");
				responseObserver.onCompleted();
			}

		}

	 
	 
	 @Override
	 public StreamObserver<UpdatedBalanceRequest> getBalance(StreamObserver<UpdatedBalanceResponse> responseObserver) {
						
				return new StreamObserver<UpdatedBalanceRequest>() {
					
					double totalBalance = 0;
					
					@Override
					public void onNext(UpdatedBalanceRequest msg) {
						
						System.out.println("receiving Account Number: "+ msg.getAccount() + " and Balance "+
																								msg.getBalance() );
						totalBalance += msg.getBalance();
						
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						UpdatedBalanceResponse res = UpdatedBalanceResponse.newBuilder().setAccumulatedBalance(totalBalance).build();
				        System.out.println("Accumulated Balance: "+ res.getAccumulatedBalance() );
						responseObserver.onNext(res);
				        responseObserver.onCompleted();
					}		
				};
			}
}
