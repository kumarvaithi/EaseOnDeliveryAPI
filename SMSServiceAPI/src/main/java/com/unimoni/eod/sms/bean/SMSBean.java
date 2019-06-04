package com.unimoni.eod.sms.bean;

import java.io.Serializable;

public class SMSBean implements Serializable {
	
	private String toMobileNumber;
	
	private String smsMessageContent;
	
	public String getToMobileNumber() {
		return toMobileNumber;
	}

	public void setToMobileNumber(String toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}

	public String getSmsMessageContent() {
		return smsMessageContent;
	}

	public void setSmsMessageContent(String smsMessageContent) {
		this.smsMessageContent = smsMessageContent;
	}

	
}
