package com.unimoni.eod.booking.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.repo.BookingHistoryRepositary;
import com.unimoni.eod.booking.repo.BookingTxnRepository;
import com.unimoni.eod.booking.repo.DeliveryChargesRepository;
import com.unimoni.eod.booking.service.BookingService;


@Service
public class BookingServicesImpl implements BookingService {

	private static final Logger logger = LoggerFactory.getLogger(BookingServicesImpl.class);
	
	@Autowired
	BookingTxnRepository bookingTxnRepository;
	
	@Autowired
	BookingHistoryRepositary bookingHistoryRepository;
	
	@Autowired
	DeliveryChargesRepository deliveryChrgRepository;
	
	@Autowired
    private KafkaTemplate<String, BookingResponseBean> kafkaTemplate;
	
	private static final String TOPIC = "Kafka_Example_json";
	
	
	@Override
	public DeliveryCharges findDeliveryCharges(int distance,  String vehicleType) {
		System.out.println("Coming from bookinservices....!!!");	
		logger.debug("findDeliveryCharges : " + distance);
		return new DeliveryCharges().setFromDistance(distance)
				.setVehicleType(vehicleType);
		
	}
	
	
	@Override
	public BookingResponseBean confirmBooking(BookingRequestBean request) {
		
		try {
			System.out.println("Request is " + request.toString());
			System.out.println("BillAmt==> "+request.getBillAmount());
			System.out.println("Request is " + request.toString());
			BookingTxn account = bookingTxnRepository.save(new BookingTxn()
					.setStorePersonName(request.getStorePersonName())
					.setStorePersonContactNo(request.getStorePersonContactNo())
					.setBillAmount(100.0)
					.setCommission(10.00)
					.setVat(2.25)
					.setCustomerID(request.getCustomerID())
					.setTotalBillAmount(112.25)
					.setDeliveryStatus("Initiated")
					.setBookingDate(new Date())
					.setCreatedAt(LocalDate.now())
					.setProviderID(request.getProviderID())
					.setVehicleID(1234567890l)
					.setPickUpLocation(request.getPickupLocation())
					.setDropLocation(request.getDropLocation())
					.setDeliverWhen(request.getDeliverWhen())
					.setItemType(request.getItemType())
					.setItemTentativeWeight(request.getItemTentativeWeight())
					.setDeliveryTime(request.getDeliveryTime())
					.setDeliveryDate(request.getDeliveryDate()));
			
			System.out.println("I am inside confirmBooking implementation  END" + account);

		}catch (Exception e) {
			e.printStackTrace();
		}
				
		return null;
	}
	
	
	@Override
	public List<BookingHistoryBean> bookingHistory(Long customerID) {
		System.out.println("I am inside bookingHistoryRepositary implementation" + customerID);
		List<BookingHistoryBean> response = new ArrayList();
		try {
			List<BookingTxn> history = bookingHistoryRepository.findByCustomerID(customerID);

			System.out.println("++++++HISTORY DATA++++++" + history.toString());
			
			for(int i=0;i<history.size();i++) {
				BookingHistoryBean temp = new BookingHistoryBean();
				
				temp.setDeliveryDate(history.get(i).getDeliveryDate());
				temp.setDeliveryPersonContactNo(history.get(i).getStorePersonContactNo());
				temp.setDeliveryPersonName(history.get(i).getStorePersonName());
				temp.setDeliveryProductType(history.get(i).getItemType());
				temp.setTentativeWeight(history.get(i).getItemTentativeWeight());
				
				response.add(temp);
			}
			System.out.println("++++++ Final Response ++++++" + response.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	@Override
	public String publishBookingDetail(Long bookingID) {
		//Optional<BookingTxn> bookingDet = bookingTxnRepository.findByBookingID(bookingID);
		BookingResponseBean book = new BookingResponseBean();
		kafkaTemplate.send(TOPIC, book);
		return "Hello booking published";
	}
	
	//-------------- Publish the booking information ---------------
	
	/*@GetMapping("/publish/{booking}")
    public String post(@PathVariable("booking") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
*/
}
