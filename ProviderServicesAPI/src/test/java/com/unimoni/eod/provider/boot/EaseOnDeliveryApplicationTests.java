package com.unimoni.eod.provider.boot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unimoni.eod.provider.model.ProviderCheckIn;
import com.unimoni.eod.provider.repo.ProviderCheckInRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EaseOnDeliveryApplicationTests {
	
	@Autowired
	ProviderCheckInRepository providerCheckInRepository;
	
	@Test
	public void contextLoads() {

		ProviderCheckIn checkIn = providerCheckInRepository.save(new ProviderCheckIn()
				.setCheckInTime(LocalDateTime.now())
				.setCurrentLocation("GUINDY")
				.setProviderCheckInID(Long.parseLong("001"))
				.setStatus("A"));  
	}
}
