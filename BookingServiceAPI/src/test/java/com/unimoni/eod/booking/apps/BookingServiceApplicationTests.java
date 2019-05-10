package com.unimoni.eod.booking.apps;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.repo.BookingTxnRepository;
import com.unimoni.eod.booking.repo.DeliveryChargesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceApplicationTests {
	
	@Autowired
	BookingTxnRepository bookingTxnRepository;
	
	@Autowired
	DeliveryChargesRepository deliveryChargesRepositary;

	@Test
	public void contextLoads() {
		
		deliveryChargesRepositary.save(new DeliveryCharges().setFromDistance(5)
				.setToDistance(10)
				.setMinWeight(10.00)
				.setMaxWeight(50.00)
				.setVehicleType("Two Wheeler")
				.setDeliveryCharge(250.00)
				.setCommission(25.00));
	}
}
