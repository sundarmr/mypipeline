package com.example.pipeline;

import java.util.List;

public class AlwaysYesValidator implements CommunicationRequestValidator{
	public boolean validate(CommunicationRequest communicationRequest) {
		return true;
	}

	public List<CommunicationRequest> validate(List<CommunicationRequest> communicationRequests) {
		return communicationRequests;
	}

}
