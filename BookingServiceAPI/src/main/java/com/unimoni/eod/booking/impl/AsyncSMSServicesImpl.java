package com.unimoni.eod.booking.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.unimoni.eod.booking.bean.SMSRequestBean;
import com.unimoni.eod.booking.service.AsyncSMSService;

@Service
public class AsyncSMSServicesImpl implements AsyncSMSService {
	
	private static final Logger logger = LoggerFactory.getLogger(AsyncSMSServicesImpl.class);
	
	@Autowired
	RestTemplate restTemplate;

	@Async
	public String asyncSMS(SMSRequestBean smsRequest) {
		String msgResponse = restTemplate.postForObject("http://localhost:8088/sms/send/", smsRequest ,String.class);
		logger.info("AsyncSMSServicesImpl.asyncSMS()");
		return msgResponse;
	}
}
