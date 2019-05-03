package com.ease.booking.services;

import com.ease.booking.bean.BookingRequestBean;
import com.ease.booking.bean.BookingResponseBean;

public interface BookingServices {
	public BookingResponseBean confirmBooking(BookingRequestBean request); 
}
