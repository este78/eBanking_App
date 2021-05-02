package grpc.eBank.payments;


import java.io.IOException;
import java.util.Random;
import grpc.eBank.payments.PaymentServiceGrpc.PaymentServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class PaymentServer extends PaymentServiceImplBase {

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 	System.out.println("Starting gRPC Payment Server");
		 	//server declaration 
		 	PaymentServer paymentserver = new PaymentServer();
		    //Service registration
		    int port = 50052;
		    SimpleServiceRegistration ssr = new SimpleServiceRegistration();
			ssr.run(port, "_http2_tcp_local.", "PaymentServer");

		    try {
		
		    	Server server = ServerBuilder.forPort(port)
		    			.addService(paymentserver)
		    			.build()
		    			.start();
		    	//Give some time to the machine to start the server
		    	Thread.sleep(new Random().nextInt(10000) + 500);
		    	System.out.println("Server started with Port:" + server.getPort());
		    		    
		    	server.awaitTermination();}
		    catch(IOException e){
				e.printStackTrace();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
	 }
	 
	 @Override
	 public StreamObserver<PaymentRequest> sendMultiplePayments(StreamObserver<UpdateBalanceResponse> responseObserver) {
		return new StreamObserver<PaymentRequest>() {

				@Override
				public void onNext(PaymentRequest request) {
						StringBuilder input1 = new StringBuilder(); 
						//hard coded, at the moment it just creates strings with the messages sends strings back. In theory it should use the messages to
						//contact and update accounts stored in a database
			            input1.append(request.getAccountTo()+", €"+request.getAmount() ); 
			            System.out.println(input1.toString());
			            
			            UpdateBalanceResponse reply = UpdateBalanceResponse.newBuilder().setAccountTo(input1.toString()).setAcknowledgement("Sent").build();
			      
			            responseObserver.onNext(reply);	
				}
				
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stubble	
				}

				@Override
				public void onCompleted() {
					 responseObserver.onCompleted();
				}	
			};
		}
	
	 
}
