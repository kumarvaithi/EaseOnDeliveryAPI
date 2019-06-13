package com.unimoni.eod.provider.services;

import com.unimoni.eod.provider.bean.BookingConfirmResponseBean;
import com.unimoni.eod.provider.bean.ServiceProviderBean;

public interface BookingServices {
	
	public BookingConfirmResponseBean bookingConfirm(ServiceProviderBean serviceProviderBean);

}
