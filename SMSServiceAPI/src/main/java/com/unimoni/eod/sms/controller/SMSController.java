package com.unimoni.eod.sms.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.unimoni.eod.sms.bean.SMSBean;
import com.unimoni.eod.sms.bean.SMSRequestBean;

@RestController
@RequestMapping("/sms")
public class SMSController {

	private static final Logger logger = LoggerFactory.getLogger(SMSController.class);

	@PostConstruct
	public void init() {
		logger.info("Info SMSController calling...");
	}

	@PostMapping("/send")
	public String sendSMS(@RequestBody SMSRequestBean smsRequestBean) {

		try {
			
			String TWILIO_NUMBER = "+17048934034";
			// Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			List<SMSBean> list = smsRequestBean.getSmsBeanList();

			list.forEach(sms -> {

				logger.debug("Twilio :" + sms.getSmsMessageContent() + ", num : " + sms.getToMobileNumber());
				Message message = Message.creator(new PhoneNumber(sms.getToMobileNumber()),
						new PhoneNumber(TWILIO_NUMBER), sms.getSmsMessageContent()).create();
				logger.info("Twilio :" + message.getStatus().name());

			});

			/*
			 * Message message = Message.creator(new PhoneNumber("+919176680857"), new
			 * PhoneNumber(TWILIO_NUMBER), "Sample Twilio SMS using Java").create();
			 * System.out.println("Twilio :" + message.getStatus().name());
			 * logger.debug("Twilio :" + message.getStatus().name());
			 */

		} catch (Exception e) {
			logger.error("Error while process SMS API" + e);
		}

		return "Sucessfully SMS Processed";
	}

}
