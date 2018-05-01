package com.example.pipeline;

public class FilterManager {
	public static CommunicationRequestFilter getFilter(Channel channel, ChannelContext channelContext){
		//Dependending on the context, filter out irrelevant requests
		return new DontFilterAny();
	}

}
