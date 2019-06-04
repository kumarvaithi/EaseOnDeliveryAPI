package com.unimoni.eod.booking.bean;

import java.util.List;

import com.unimoni.eod.booking.model.BookingCustomerDetails;
import com.unimoni.eod.booking.model.BookingTxnStatus;


public class BookingResponseListBean {
	
	private List<BookingResponseBean> bookingDetails;

	public List<BookingResponseBean> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingResponseBean> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
}
