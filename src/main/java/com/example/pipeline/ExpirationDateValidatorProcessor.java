package com.example.pipeline;

public class ExpirationDateValidatorProcessor extends ValidationProcessor {

	public boolean validate(CommunicationRequest request) {
		System.out.println("In "+ExpirationDateValidatorProcessor.class.getCanonicalName());
		//super.cancelCommunicationRequest(request);
		if(request.getRequestMetaData().isDoesExpire()) {
			//process
			
		}
		return true;
	}

}
