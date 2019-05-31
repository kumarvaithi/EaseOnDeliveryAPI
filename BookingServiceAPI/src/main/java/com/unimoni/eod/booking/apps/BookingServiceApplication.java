package com.unimoni.eod.booking.apps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("com.unimoni")
@ComponentScan({"com.unimoni"})	
@EntityScan("com.unimoni")
public class BookingServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
		logger.info("*****Booking Serive Application*****");
	}

}
