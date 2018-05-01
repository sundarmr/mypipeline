package com.example.pipeline;

import java.util.List;

public class SelectorManager {
	public static CommunicationRequestSelector getSelector(Channel channel, ChannelContext channelContext){
		//Pull from the DB probably
		return new CommunicationRequestSelector() {
			
			public List<CommunicationRequest> get() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
