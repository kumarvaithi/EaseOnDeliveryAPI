package com.unimoni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.twilio.Twilio;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({ "com.unimoni" })
public class SmsServiceApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(SmsServiceApiApplication.class);
	
	private static final String ACCOUNT_SID = "AC4fb59d5df0b7976465c2c82066e2840e";
	private static final String AUTH_ID = "e454f912430b0ae44f455cae97b68397";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SmsServiceApiApplication.class, args);
		logger.info("*****SMS Serive API*****");
	}

}
