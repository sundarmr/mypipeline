package com.example.pipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListValidator implements CommunicationRequestValidator{
	private List<CommunicationRequestValidator> validators;
	

	public ListValidator(List<CommunicationRequestValidator> validators) {
		super();
		this.validators = validators;
	}

	public ListValidator(CommunicationRequestValidator... validators) {
		super();
		this.validators = Arrays.asList(validators);
	}
	
	public boolean validate(CommunicationRequest communicationRequest) {
		boolean foundInvalid = false;
		for (CommunicationRequestValidator validator : validators) {
			if (!validator.validate(communicationRequest)) {
				foundInvalid = true;
				break;
			}
		}
		return !foundInvalid;
	}

	public List<CommunicationRequest> validate(List<CommunicationRequest> communicationRequests) {
		List<CommunicationRequest> toReturn = new ArrayList<CommunicationRequest>();
		for (CommunicationRequest communicationRequest : communicationRequests) {
			if (validate(communicationRequest)) {
				toReturn.add(communicationRequest);
			}
		}
		return toReturn;
	}

}
