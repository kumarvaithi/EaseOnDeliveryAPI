package com.ease.booking.impl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ease.booking.bean.BookingRequestBean;
import com.ease.booking.bean.BookingResponseBean;
import com.ease.booking.model.BookingTxn;
import com.ease.booking.repo.BookingRepositary;
import com.ease.booking.services.BookingServices;

public class BookingServicesImpl implements BookingServices{

	@Autowired
	BookingRepositary bookingRepositary;
	
	@Override
	public BookingResponseBean confirmBooking(BookingRequestBean request) {
		System.out.println("I am inside confirmBooking implementation");
		
		
		BookingTxn account = bookingRepositary.save(new BookingTxn()
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
