package com.example.pipeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunicationRequestProcessor {
	
	//Inbound channels
	public List<CommunicationRequest> getCommunicationRequests(Channel channel, ChannelContext channelContext){
		
		//Only get relevant potential communications 
		CommunicationRequestSelector communicationRequestSelector = SelectorManager.getSelector(channel, channelContext); 
		List<CommunicationRequest> possibleCommunicationRequests = communicationRequestSelector.get();
		
		//Filter out invalid requests
		List<CommunicationRequest> validatedRequests = new ArrayList<CommunicationRequest>();
		for (CommunicationRequest communicationRequest: possibleCommunicationRequests) {
			CommunicationRequestValidator communicationRequestValidator = ValidationManager.getValidator(communicationRequest);
			if (communicationRequestValidator.validate(communicationRequest)) {
				validatedRequests.add(communicationRequest);
			}
		}
		
		//Don't need to choose channels, it's inbound
		
		//Enrich them all
		List<CommunicationRequest> enrichedRequests = new ArrayList<CommunicationRequest>();
		for (CommunicationRequest communicationRequest: validatedRequests) {
			CommunicationRequestEnricher communicationRequestEnricher = EnrichmentManager.getEnricher(communicationRequest);
			enrichedRequests.add(communicationRequestEnricher.enrich(communicationRequest, channel));
		}
		
		//Filter for channel
		List<CommunicationRequest> filteredRequests = new ArrayList<CommunicationRequest>();
		for (CommunicationRequest communicationRequest: enrichedRequests) {
			CommunicationRequestFilter communicationRequestFilter = FilterManager.getFilter(channel, channelContext);
			if (!communicationRequestFilter.filter(communicationRequest)) {
				filteredRequests.add(communicationRequest);
			}
		}
		
		return filteredRequests;
		
	}

	//Batch Request
	//Selector must return communicationRequests of the same type, this allows
	// us to batch the validation, enrichment, and filter
	//
	public void process(SingleTypeCommunicationRequestSelector singleTypeCommunicationRequestSelector) {
		
		//Only get relevant potential communications 
		List<CommunicationRequest> requests = singleTypeCommunicationRequestSelector.get();
		String type = singleTypeCommunicationRequestSelector.getCommunicationRequestType();
		

		//Filter out invalid requests
		CommunicationRequestValidator communicationRequestValidator = ValidationManager.getValidator(type);
		List<CommunicationRequest> validatedRequests = communicationRequestValidator.validate(requests);

		
		//Choose channel
		Map<Channel, List<CommunicationRequest>> sortedByChannel = new HashMap<Channel, List<CommunicationRequest>>();
		ChannelSelector channelSelector = ChannelSelectorManager.get(type);
		for (CommunicationRequest communicationRequest : validatedRequests) {
			Channel chosenChannel = channelSelector.determineChannel(communicationRequest);
			
			if (!sortedByChannel.containsKey(chosenChannel)) {
				sortedByChannel.put(chosenChannel, new ArrayList<CommunicationRequest>());
			}
			sortedByChannel.get(chosenChannel).add(communicationRequest);
		}
		
		
		//Enrich them all
		CommunicationRequestEnricher communicationRequestEnricher = EnrichmentManager.getEnricher(type);
		for (Channel channel : sortedByChannel.keySet()) {
			List<CommunicationRequest> channelRequests = sortedByChannel.get(channel);
			sortedByChannel.put(channel, communicationRequestEnricher.enrich(channelRequests, channel));
		}
		
		//Deliver for channel
		for (Channel channel : sortedByChannel.keySet()) {
			List<CommunicationRequest> channelRequests = sortedByChannel.get(channel);
			CommunicationRequestDeliverer communicationRequestDeliverer = DelivererManager.getDeliverer(channel);
			communicationRequestDeliverer.deliver(channelRequests);
		}
		
	}

}
