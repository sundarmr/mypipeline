package com.example.pipeline;

import java.util.ArrayList;
import java.util.List;

public class PipeLineManager {

	
		//This can be inject easily when put in to a EAP environment
		//and driven from property files , the intention is that
		//in future if any new validations comeup we can get that
		//added in any order and rejig from props file for the order
	    private List<ValidationProcessor> validationProcessor ;

	    public PipeLineManager() {
	    		validationProcessor = new ArrayList<ValidationProcessor>();
	    		validationProcessor.add(new GodForbidsTheValidation());
	    		validationProcessor.add(new ExpirationDateValidatorProcessor());
	    		validationProcessor.add(new MaxSuccessfulDeliveryValidationProcessor());
	    		
	    }

	    public boolean validate(CommunicationRequest req) throws Exception{
	        return new Pipeline(
	        		validationProcessor
	        ).validate(req);
	    }

		
	
}
