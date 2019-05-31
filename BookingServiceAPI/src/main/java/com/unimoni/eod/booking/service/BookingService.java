package com.unimoni.eod.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unimoni.eod.booking.bean.BookingHistoryBean;
import com.unimoni.eod.booking.bean.BookingRequestBean;
import com.unimoni.eod.booking.bean.BookingResponseBean;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.DeliveryCharges;

@Service
public interface BookingService {
	
	public DeliveryCharges findDeliveryCharges(DeliveryCharges deliveryChrgs);
	
	public BookingResponseBean confirmBooking(BookingRequestBean request); 

	public BookingResponseBean retrieveBookingsDetails(int bookingID);
	
	public List<BookingHistoryBean> bookingHistory(int customerID);
	
	public String publishBookingDetail(Long bookingID);
	
}
