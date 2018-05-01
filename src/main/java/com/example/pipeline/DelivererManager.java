package com.example.pipeline;

public class DelivererManager {
	public static CommunicationRequestDeliverer getDeliverer(Channel channel){
		return new NoOpDeliverer();
	}

}
