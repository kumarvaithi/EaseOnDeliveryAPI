package com.unimoni.eod.booking.bean;

public class CommonResponseBean {

	private String responseCode;
	private String responseMessage;
	private String reponseErrorType;
	
	public String getResponseCode() {
		return responseCode;
	}
	public CommonResponseBean setResponseCode(String responseCode) {
		this.responseCode = responseCode;
		return this;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public CommonResponseBean setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
		return this;
	}
	public String getReponseErrorType() {
		return reponseErrorType;
	}
	public CommonResponseBean setReponseErrorType(String reponseErrorType) {
		this.reponseErrorType = reponseErrorType;
		return this;
	}
}
