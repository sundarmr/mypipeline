package com.example.pipeline;

public class ChannelSelector {
	
	public Channel determineChannel(CommunicationRequest communicationRequest) {
		//Write or call subroutines to get the actual Channel Value
		System.out.println("Determined the channel as SMS");
		return Channel.SMS;
	}

}
