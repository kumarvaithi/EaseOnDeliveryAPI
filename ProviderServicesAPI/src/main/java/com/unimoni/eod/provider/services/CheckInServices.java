package com.unimoni.eod.provider.services;

import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;

public interface CheckInServices {
	public CheckInResponseBean checkIn(CheckInRequestBean request); 
}
