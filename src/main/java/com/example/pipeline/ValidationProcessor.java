package com.example.pipeline;

public abstract class ValidationProcessor {

	public abstract boolean validate(CommunicationRequest request) ;
	
	public void cancelCommunicationRequest(CommunicationRequest request) {
		//Do something to cancel the request handle exception and what not
	}
	
}
