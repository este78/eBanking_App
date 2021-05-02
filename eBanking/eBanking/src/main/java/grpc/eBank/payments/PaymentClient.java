package grpc.eBank.payments;


import java.util.Random;

import javax.jmdns.ServiceInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class PaymentClient {

	private static PaymentServiceGrpc.PaymentServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception {
		
		/*ServiceInfo serviceInfo;
		String service_type = "_http2._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();*/
		
		String host = "localhost";
		int port = 50052;
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		//stubs -- generate from proto
		asyncStub = PaymentServiceGrpc.newStub(channel);

		
		sendMultiplePayments();

	}



public static void sendMultiplePayments() {

	StreamObserver<UpdateBalanceResponse> responseObserver = new StreamObserver<UpdateBalanceResponse>() {

			@Override
			public void onNext(UpdateBalanceResponse msg) {
				System.out.println("payment to " + msg.getAccountTo() +", "+ msg.getAcknowledgement() );

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("server completed");
			}

		};

		//
		StreamObserver<PaymentRequest> requestObserver = asyncStub.sendMultiplePayments(responseObserver);

		try {
			System.out.println("Payments: SENDING MESSAGES");
			requestObserver.onNext(PaymentRequest.newBuilder().setAccountFrom("Account 1").setAccountTo("Andy").setAmount(500).build() );
			Thread.sleep(new Random().nextInt(1000) + 500);
			requestObserver.onNext(PaymentRequest.newBuilder().setAccountFrom("Account 2").setAccountTo("Maggie").setAmount(20).build() );
			Thread.sleep(new Random().nextInt(1000) + 500);
			requestObserver.onNext(PaymentRequest.newBuilder().setAccountFrom("Account 1").setAccountTo("Juana").setAmount(2000).build() );
			Thread.sleep(new Random().nextInt(1000) + 500);
			requestObserver.onNext(PaymentRequest.newBuilder().setAccountFrom("Account 1").setAccountTo("Ultan").setAmount(3000).build() );
			Thread.sleep(new Random().nextInt(1000) + 500);
			requestObserver.onNext(PaymentRequest.newBuilder().setAccountFrom("Account 2").setAccountTo("Siobhan").setAmount(2500).build() );
			Thread.sleep(new Random().nextInt(1000) + 500);

			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			


		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

	}
}
