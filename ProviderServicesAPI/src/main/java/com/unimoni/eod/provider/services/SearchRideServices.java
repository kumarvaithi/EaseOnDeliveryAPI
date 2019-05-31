package com.unimoni.eod.provider.services;

import com.unimoni.eod.provider.bean.BookingDetailsListBean;
import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;

public interface SearchRideServices {
	public BookingDetailsListBean searchRide(int providerID, String status); 
}
