package com.example.pipeline;

import java.util.List;

public class NoOpDeliverer implements CommunicationRequestDeliverer{
	public void deliver(CommunicationRequest communicationRequest, Channel channel){
		//real time i guess
	}

	public void deliver(List<CommunicationRequest> communicationRequest) {
		//Batch it up
	}
}
