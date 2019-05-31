package com.unimoni.eod.booking.apps;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unimoni.eod.booking.model.BookingCustomerDetails;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.BookingTxnStatus;
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
		
//		deliveryChargesRepositary.save(new DeliveryCharges().setFromDistance(5)
//				.setToDistance(10)
//				.setMinWeight(10.00)
//				.setMaxWeight(50.00)
//				.setVehicleType("Two Wheeler")
//				.setDeliveryCharge(250.00)
//				.setCommission(25.00));
		List<BookingTxnStatus> bookingStatus = null;
		BookingTxnStatus bookingTxnStatus = new BookingTxnStatus();
		
		bookingTxnStatus.setStatus("Initiates");
		bookingTxnStatus.setModifiedAt(LocalDate.now());
		bookingTxnStatus.setModifiedBy("thameem");
		bookingStatus.add(bookingTxnStatus);
		
//		bookingTxnRepository.save(new BookingTxn()
//				.setBillAmount(100.00)
//				.setBookingDate(LocalDate.now())
//				.setCommission(10.00)
//				.setCreatedAt(LocalDate.now())
//				.setCustomerID(1)
//				.setDeliverWhen("NOW")
//				.setDeliveryDate(new Date())
//				.setDeliveryTime(new Timestamp(1120))
//				.setDropLocation("Perambur")
//				.setItemTentativeWeight(100.00)
//				.setItemType("Vegetables and Fruits")
//				.setPickUpLocation("DLF")
//				.setProviderID(1)
//				.setStorePersonContactNo("1232131")
//				.setStorePersonName("thameem")
//				.setTotalBillAmount(112.25)
//				.setVat(2.25)
//				.setVehicleID(1)
//				.setBookingCustomerDetails(new BookingCustomerDetails()
//						.setAddress("test")
//						.setAlternativeMobileNo("912312311")
//						.setCustomerID(1)
//						.setEmailID("asdfasd@gmail.com")
//						.setMobileNo("123123213")
//						.setName("thameem")));
////				.setBookingTxnStatus(bookingStatus));
	}
}
