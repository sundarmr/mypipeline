package com.example.pipeline;

import java.time.LocalDate;
import java.util.Map;

public class CommunicationRequest {
	
	private String communicationType;
	private String communicationDate;
	private int successfulDeliveries;
	private String overrideValue;
	private String overrideChannel;
	private LocalDate expirationDate;
	private int priority;
	private Map<String,String> messageProperties;
	private RequestMetaData requestMetaData;
	private boolean isValid;
	
	public String getCommunicationType() {
		return communicationType;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public String getCommunicationDate() {
		return communicationDate;
	}
	public void setCommunicationDate(String communicationDate) {
		this.communicationDate = communicationDate;
	}
	public int getSuccessfulDeliveries() {
		return successfulDeliveries;
	}
	public void setSuccessfulDeliveries(int successfulDeliveries) {
		this.successfulDeliveries = successfulDeliveries;
	}
	public String getOverrideValue() {
		return overrideValue;
	}
	public void setOverrideValue(String overrideValue) {
		this.overrideValue = overrideValue;
	}
	public String getOverrideChannel() {
		return overrideChannel;
	}
	public void setOverrideChannel(String overrideChannel) {
		this.overrideChannel = overrideChannel;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Map<String, String> getMessageProperties() {
		return messageProperties;
	}
	public void setMessageProperties(Map<String, String> messageProperties) {
		this.messageProperties = messageProperties;
	}
	public RequestMetaData getRequestMetaData() {
		return requestMetaData;
	}
	public void setRequestMetaData(RequestMetaData requestMetaData) {
		this.requestMetaData = requestMetaData;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

}
