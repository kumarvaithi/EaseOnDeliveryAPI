package com.unimoni.eod.booking.service;

import org.springframework.stereotype.Service;

import com.unimoni.eod.booking.bean.BookingHistoryResponseBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.model.DeliveryCharges;

@Service
public interface BookingService {
	
	public DeliveryCharges findDeliveryCharges(int distance,  String vehicleType);
	
	public BookingResponseBean confirmBooking(BookingRequestBean request); 
	
	public BookingHistoryResponseBean bookingHistory(String customerID);
	
}
