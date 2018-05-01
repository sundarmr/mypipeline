package com.example.pipeline;

import java.util.List;

public class DontFilterAny implements CommunicationRequestFilter{
	
	public boolean filter(CommunicationRequest communicationRequest){
		return false;
	}
	
	public List<CommunicationRequest> filter(List<CommunicationRequest> communicationRequests){
		return communicationRequests;
	}

}
