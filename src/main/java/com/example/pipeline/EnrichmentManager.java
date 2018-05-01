package com.example.pipeline;

public class EnrichmentManager {
	public static CommunicationRequestEnricher getEnricher(String communicationRequestType){
		//Always need to perform domain validation and connect validation
		return new LinkEnricher();
	}

	public static CommunicationRequestEnricher getEnricher(CommunicationRequest communicationRequest){
		return getEnricher(communicationRequest.getCommunicationType());
	}
}
