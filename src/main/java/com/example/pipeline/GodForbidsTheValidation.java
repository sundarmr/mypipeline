package com.example.pipeline;

public class GodForbidsTheValidation extends ValidationProcessor {

	@Override
	public boolean validate(CommunicationRequest request) {
		System.out.println("In "+GodForbidsTheValidation.class.getCanonicalName());
		return true;
	}

}
