package grpc.eBank.payments;

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

import grpc.eBank.payments.PaymentServiceGrpc.PaymentServiceImplBase;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class PaymentServer extends PaymentServiceImplBase {


	private static final Logger logger = Logger.getLogger(PaymentServer.class.getName());

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 	PaymentServer paymentserver = new PaymentServer();
		   
		    int port = 50051;
		    Server server = ServerBuilder.forPort(port)
		        .addService(paymentserver)
		        .build()
		        .start();
		    
		    logger.info("Server started, listening on " + port);
		    		    
		    server.awaitTermination();
	 }
	 
	
	 
}
