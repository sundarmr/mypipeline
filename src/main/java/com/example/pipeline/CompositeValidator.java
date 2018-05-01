package com.example.pipeline;

import java.util.List;

public class CompositeValidator implements CommunicationRequestValidator{
	private CommunicationRequestValidator first;
	private CommunicationRequestValidator second;
	
	public CompositeValidator(CommunicationRequestValidator first, CommunicationRequestValidator second) {
		super();
		this.first = first;
		this.second = second;
	}

	public boolean validate(CommunicationRequest communicationRequest) {
		return first.validate(communicationRequest) && second.validate(communicationRequest);
	}

	public List<CommunicationRequest> validate(List<CommunicationRequest> communicationRequests) {
		return second.validate(first.validate(communicationRequests));
	}

}
