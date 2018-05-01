package com.example.pipeline;

public class ValidationManager {
	public static CommunicationRequestValidator getValidator(CommunicationRequest communicationRequest){
		//Always need to perform domain validation and connect validation
		return new CompositeValidator(getDomainValidator(communicationRequest.getCommunicationType())
				, getConnectValidator(communicationRequest.getCommunicationType()));
	}
	
	public static CommunicationRequestValidator getValidator(String communicationRequestType){
		//Always need to perform domain validation and connect validation
		return new CompositeValidator(getDomainValidator(communicationRequestType)
				, getConnectValidator(communicationRequestType));
	}
	
	private static CommunicationRequestValidator getDomainValidator(String communicationRequest) {
		//Domain validator like payments or journey service 
		return new AlwaysYesValidator();
	}
	
	private static CommunicationRequestValidator getConnectValidator(String communicationRequest) {
		//Connect validators like Account status and global exclusion
		return new ListValidator(
				new AlwaysYesValidator(), 
				new AlwaysYesValidator());
	}
}
