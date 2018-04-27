package com.example.pipeline;

public class RequestMetaData {
	
	private boolean isValidationRequiredForNBA;
	private boolean isNBA;
	private String[] blackListAccountCodes;
	private String[] blaclListReasonCodes;
	private int maxSuccesfulDeliveries;
	private String communicationType;
	private boolean fusionUrlNeeded;
	private boolean doesExpire;
	
	public boolean isValidationRequiredForNBA() {
		return isValidationRequiredForNBA;
	}
	public void setValidationRequiredForNBA(boolean isValidationRequiredForNBA) {
		this.isValidationRequiredForNBA = isValidationRequiredForNBA;
	}
	public boolean isNBA() {
		return isNBA;
	}
	public void setNBA(boolean isNBA) {
		this.isNBA = isNBA;
	}
	public String[] getBlackListAccountCodes() {
		return blackListAccountCodes;
	}
	public void setBlackListAccountCodes(String[] blackListAccountCodes) {
		this.blackListAccountCodes = blackListAccountCodes;
	}
	public String[] getBlaclListReasonCodes() {
		return blaclListReasonCodes;
	}
	public void setBlaclListReasonCodes(String[] blaclListReasonCodes) {
		this.blaclListReasonCodes = blaclListReasonCodes;
	}
	public int getMaxSuccesfulDeliveries() {
		return maxSuccesfulDeliveries;
	}
	public void setMaxSuccesfulDeliveries(int maxSuccesfulDeliveries) {
		this.maxSuccesfulDeliveries = maxSuccesfulDeliveries;
	}
	public String getCommunicationType() {
		return communicationType;
	}
	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}
	public boolean isFusionUrlNeeded() {
		return fusionUrlNeeded;
	}
	public void setFusionUrlNeeded(boolean fusionUrlNeeded) {
		this.fusionUrlNeeded = fusionUrlNeeded;
	}
	public boolean isDoesExpire() {
		return doesExpire;
	}
	public void setDoesExpire(boolean doesExpire) {
		this.doesExpire = doesExpire;
	}

}
