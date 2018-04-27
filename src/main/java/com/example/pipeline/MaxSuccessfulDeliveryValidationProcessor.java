package com.example.pipeline;

public class MaxSuccessfulDeliveryValidationProcessor extends  ValidationProcessor {

	public boolean validate(CommunicationRequest request) {
		System.out.println("In "+MaxSuccessfulDeliveryValidationProcessor.class.getCanonicalName());
		return true;
	}
}
