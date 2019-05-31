package com.unimoni.eod.provider.utils;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.unimoni.eod.provider.model.ProviderBookingMapping;
import com.unimoni.eod.provider.model.ProviderCheckIn;
import com.unimoni.eod.provider.repo.ProviderBookingMapRepository;
import com.unimoni.eod.provider.repo.ProviderCheckInRepository;

public class ProviderUtils {

	@Autowired
	ProviderBookingMapRepository providerBookingRepository;
	
	@Autowired
	ProviderCheckInRepository providerCheckInRepository;
	
	@Transactional
	public void mapBookingProvider(String strBookingID) {
		String status = "N";
		int bookingID = Integer.parseInt(strBookingID);
		List<ProviderCheckIn> providerCheckIn =  providerCheckInRepository.findByStatus(status);
		System.out.println("check in size is " + providerCheckIn.size());
		for(int i=0;i<providerCheckIn.size();i++) {
			providerBookingRepository.save(new ProviderBookingMapping()
					.setBookingDate(LocalDate.now())
					.setBookingID(bookingID)
					.setBookingResponseDate(LocalDate.now())
					.setProviderID(providerCheckIn.get(i).getProviderID())
					.setStatus(status));
		}
	}
}