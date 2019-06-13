package com.unimoni.eod.booking.service;

import org.springframework.stereotype.Service;

import com.unimoni.eod.booking.bean.SMSRequestBean;

@Service
public interface AsyncSMSService {
	
	public String asyncSMS(SMSRequestBean smsRequest);

}
