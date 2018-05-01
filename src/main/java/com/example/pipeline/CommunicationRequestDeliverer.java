package com.example.pipeline;

import java.util.List;

public interface CommunicationRequestDeliverer {
	public void deliver(List<CommunicationRequest> communicationRequest);
}
