package com.unimoni.eod.booking.bean;

import java.util.List;

import com.unimoni.eod.booking.model.BookingCustomerDetails;
import com.unimoni.eod.booking.model.BookingTxnStatus;


public class BookingResponseListBean {
	
	private List<BookingResponseBean> bookingResponsBean;

	public List<BookingResponseBean> getBookingResponsBean() {
		return bookingResponsBean;
	}

	public void setBookingResponsBean(List<BookingResponseBean> bookingResponsBean) {
		this.bookingResponsBean = bookingResponsBean;
	}
	
}
