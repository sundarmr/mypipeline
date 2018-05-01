package com.example.pipeline;

import java.util.List;

public interface CommunicationRequestFilter {
	
	public boolean filter(CommunicationRequest communicationRequest);
	
	public List<CommunicationRequest> filter(List<CommunicationRequest> communicationRequests);

}
