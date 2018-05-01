package com.example.pipeline;

public class ChannelSelectorManager {
	
	public static ChannelSelector get(String type) {
		return new ChannelSelector();
	}

}
