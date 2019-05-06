package com.ease.boot;

import java.time.LocalDate;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ease.booking.model.BookingTxn;
import com.ease.booking.model.DeliveryCharges;
import com.ease.booking.repo.BookingRepositary;
import com.ease.booking.repo.DeliveryChargesRepositary;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EaseOnDeliveryApplicationTests {
	
	@Autowired
	BookingRepositary bookingRepositary;
	
	@Autowired
	DeliveryChargesRepositary deliveryChargesRepositary;

	@Test
	public void contextLoads() {
		
		BookingTxn account = bookingRepositary.save(new BookingTxn()
				.setCustomerID(Long.valueOf(123456))
				.setProviderID(Long.valueOf(22222222))
				.setVehicleID(Long.valueOf(3333333))
				.setPickUpLocation("Guiny")
				.setDropLocation("DLF")
				.setDeliverWhen("Today")
				.setItemType("Vegtables")
				.setItemTentativeWeight(1000.100)
				.setDeliveryDate(new Date())
				.setDeliveryTime(new Date())
				.setStorePersonName("Kumar")
				.setStorePersonContactNo("9710000234")
				.setBillAmount(1000)
				.setCommission(10)
				.setVat(5)
				.setTotalBillAmount(1015)
				.setBookingDate(new Date())
				.setDeliveryStatus("Initiated")
				.setCreatedAt(LocalDate.now()));
		
//		DeliveryCharges deliveryCharges = deliveryChargesRepositary.save(new DeliveryCharges()
//				.setFromDistance(1)
//				.setToDistance(5)
//				.setVehicleType("Two Wheeler")
//				.setVehicleModel("Bajaj Pulsar")
//				.setMinWeight(1.00)
//				.setMaxWeight(5.0)
//				.setCommission(50.00)
//				.setDeliveryCharge(100.00)		
//				);
	}
		
	
}
