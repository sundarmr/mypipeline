package com.example.pipeline;

public class CheckOut {

	public static void main(String[] args) {
		CommunicationRequest request = new CommunicationRequest();
		RequestMetaData metaData = new RequestMetaData();
		metaData.setMaxSuccesfulDeliveries(2);
		metaData.setDoesExpire(true);
		request.setRequestMetaData(metaData);
		request.setCommunicationType("official");
		PipeLineManager pipeLine = new PipeLineManager();
		//Reuse the same concept and we can write up a Manager for managing pipelines
		//The use case would be where when a certain type of request needs a set of rules
		//and other can skip them completely
		try {
			if(pipeLine.validate(request)) {
				Channel determineChannel = (new ChannelSelector()).determineChannel(request);
				switch(determineChannel) {
				case EMAIL:
						//do someting as simple as sending the email 
						//running it through another set of pileine
					System.out.println("Sending EMAIL.....");
				case SMS:
					//do someting as simple as sending the sms 
					//running it through another set of pipeline
					System.out.println("Sending SMS.....");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
