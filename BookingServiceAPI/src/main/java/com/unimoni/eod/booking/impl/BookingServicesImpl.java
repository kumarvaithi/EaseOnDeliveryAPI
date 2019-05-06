package com.unimoni.eod.booking.impl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.DeliveryCharges;
import com.unimoni.eod.booking.repo.BookingTxnRepository;
import com.unimoni.eod.booking.repo.DeliveryChargesRepository;
import com.unimoni.eod.booking.service.BookingService;

@Service
public class BookingServicesImpl implements BookingService {

	@Autowired
	BookingTxnRepository bookingTxnRepository;
	
	@Autowired
	DeliveryChargesRepository deliveryChrgRepository;
	
	@Override
	public DeliveryCharges findDeliveryCharges(int distance,  String vehicleType) {
		System.out.println("Coming from bookinservices....!!!");		
		return new DeliveryCharges().setFromDistance(distance)
				.setVehicleType(vehicleType);
		
	}
	
	
	@Override
	public BookingResponseBean confirmBooking(BookingRequestBean request) {
		
		System.out.println("I am inside confirmBooking implementation");
		
		BookingTxn account = bookingTxnRepository.save(new BookingTxn()
				.setCustomerID(Long.valueOf(request.getCustomerID()))
				.setProviderID(Long.valueOf(request.getProviderID()))
				.setVehicleID(Long.valueOf(3333333))
				.setPickUpLocation(request.getPickupLocation())
				.setDropLocation(request.getDropLocation())
				.setDeliverWhen(request.getDeliverWhen())
				.setItemType(request.getItemType())
				.setItemTentativeWeight(request.getItemTentativeWeight())
				.setDeliveryDate(request.getDeliveryDate()))
				.setDeliveryTime(request.getDeliveryTime())
				.setStorePersonName(request.getStorePersonName())
				.setStorePersonContactNo(request.getStorePersonContactNo())
				.setBillAmount(request.getBillAmount())
				.setCommission(request.getCommsion())
				.setVat(request.getVat())
				.setTotalBillAmount(request.getTotalBillAmount())
				.setBookingDate(new Date())
				.setDeliveryStatus("Initiated")
				.setCreatedAt(LocalDate.now());
		
		return null;
	}

}
