package com.example.pipeline;

import java.util.List;

public class LinkEnricher implements CommunicationRequestEnricher {

	public CommunicationRequest enrich(CommunicationRequest communicationRequest, Channel channel) {
		// add enrichments to communicationRequest's properties
		return communicationRequest;
	}

	public List<CommunicationRequest> enrich(List<CommunicationRequest> communicationRequests, Channel channel) {
		// enrich in batch if that's a thing, otherwise delegate to the above enrich
		return communicationRequests;
	}

}
