package com.unimoni.eod.provider.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;
import com.unimoni.eod.provider.model.ProviderCheckIn;
import com.unimoni.eod.provider.repo.ProviderCheckInRepository;
import com.unimoni.eod.provider.services.CheckInServices;

@Service("checkIn")
public class CheckInImpl implements CheckInServices {

	@Autowired
	ProviderCheckInRepository providerCheckInRepository;
	
	@Override
	public CheckInResponseBean checkIn(CheckInRequestBean request) {
		// TODO Auto-generated method stub
		
		ProviderCheckIn checkIn = providerCheckInRepository.save(new ProviderCheckIn()
				.setCheckInTime(LocalDateTime.now())
				.setCheckOutTime(LocalDateTime.now())
				.setCurrentLocation(request.getCurrentLocation())
				.setProviderID(request.getProviderID())
				.setStatus(request.getProviderStatus())); 
		return new CheckInResponseBean();
	}

}
