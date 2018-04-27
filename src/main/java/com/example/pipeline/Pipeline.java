package com.example.pipeline;

import java.util.List;

public class Pipeline {

	private final List<ValidationProcessor> pipes;

	public Pipeline(List<ValidationProcessor> pipes) {
		this.pipes = pipes;
	}

	public boolean validate(CommunicationRequest input) {
		boolean processed = true;
		for (ValidationProcessor pipe : pipes) {
			processed = pipe.validate(input);
			if(processed==false) {
				return processed;
			}
		}
		return processed;
	}
}
