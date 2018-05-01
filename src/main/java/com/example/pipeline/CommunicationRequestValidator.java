package com.example.pipeline;

import java.util.List;

public interface CommunicationRequestValidator {
	
	public boolean validate(CommunicationRequest communicationRequest);
	
	public List<CommunicationRequest> validate(List<CommunicationRequest> communicationRequests);

}
