package com.example.pipeline;

import java.util.List;

public interface CommunicationRequestEnricher {
	public CommunicationRequest enrich(CommunicationRequest communicationRequest, Channel channel);
	public List<CommunicationRequest> enrich(List<CommunicationRequest> communicationRequests, Channel channel);
}
