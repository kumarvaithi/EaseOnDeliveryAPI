package com.unimoni.eod.provider.services;

import com.unimoni.eod.provider.bean.BookingDetailsListBean;
import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;
import com.unimoni.eod.provider.bean.CommonResponseBean;

public interface SearchRideServices {
	public BookingDetailsListBean searchRide(int providerID, String status);

	public BookingDetailsListBean viewBooking(int bookingID); 
	
	public CommonResponseBean verifyPIN(String userType, int bookingID, int pin);
}
