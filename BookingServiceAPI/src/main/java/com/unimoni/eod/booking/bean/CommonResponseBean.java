package com.unimoni.eod.booking.bean;

public class CommonResponseBean {

	private String responseCode;
	private String responseMessage;
	private String reponseErrorType;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getReponseErrorType() {
		return reponseErrorType;
	}
	public void setReponseErrorType(String reponseErrorType) {
		this.reponseErrorType = reponseErrorType;
	}
}
