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

import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.repo.BookingHistoryRepositary;
import com.unimoni.eod.booking.model.User;
import com.unimoni.eod.booking.repo.BookingTxnRepository;
import com.unimoni.eod.booking.repo.DeliveryChargesRepository;
import com.unimoni.eod.booking.service.BookingService;


@Service
public class BookingServicesImpl implements BookingService {

	@Autowired
	BookingTxnRepository bookingTxnRepository;
	
	@Autowired
	BookingHistoryRepositary bookingHistoryRepository;
	
	@Autowired
	DeliveryChargesRepository deliveryChrgRepository;
	

	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

	
	private static final Logger logger = LoggerFactory.getLogger(BookingServicesImpl.class);
	
	@Override
	public DeliveryCharges findDeliveryCharges(int distance,  String vehicleType) {
		System.out.println("Coming from bookinservices....!!!");	
		logger.debug("findDeliveryCharges : " + distance);
		return new DeliveryCharges().setFromDistance(distance)
				.setVehicleType(vehicleType);
		
	}
	
	
	@Override
	public BookingResponseBean confirmBooking(BookingRequestBean request) {
		
		System.out.println("I am inside confirmBooking implementation");
		System.out.println("BillAmt==> "+request.getBillAmount());
		BookingTxn account = bookingTxnRepository.save(new BookingTxn()
				
				.setStorePersonName(request.getStorePersonName())
				.setStorePersonContactNo(request.getStorePersonContactNo())
				.setBillAmount(10001.0)
				.setCommission(request.getCommsion())
				.setVat(request.getVat())
				.setCustomerID(request.getCustomerID())
				.setTotalBillAmount(request.getTotalBillAmount())
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

}
