package com.unimoni.eod.provider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.unimoni.eod.provider.bean.BookingConfirmResponseBean;
import com.unimoni.eod.provider.bean.BookingDetailsListBean;
import com.unimoni.eod.provider.bean.ServiceProviderBean;
import com.unimoni.eod.provider.model.ProviderBookingMapping;
import com.unimoni.eod.provider.model.ProviderDetails;
import com.unimoni.eod.provider.repo.ProviderBookingMapRepository;
import com.unimoni.eod.provider.repo.ProviderDetailsRepository;
import com.unimoni.eod.provider.services.BookingServices;

@Service("booking")
public class BookingImpl implements BookingServices {


	@Autowired
	ProviderDetailsRepository providerDetailsRepository;
	
	@Autowired
	ProviderBookingMapRepository providerBookingMapRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public BookingConfirmResponseBean bookingConfirm(ServiceProviderBean serviceProviderBean) {
		// TODO Auto-generated method stub
		ProviderDetails providerDetails;
		/* Fetching Service provider details */
		if(serviceProviderBean.getProviderID()!= 0) {
			
			ProviderBookingMapping providerBookingMapping = providerBookingMapRepository.findByProviderIDAndBookingID(serviceProviderBean.getProviderID(), serviceProviderBean.getBookingID());
			providerBookingMapping.setStatus("A");
			
			providerBookingMapRepository.save(providerBookingMapping);
			providerDetails = providerDetailsRepository.findByProviderID(serviceProviderBean.getProviderID());
			serviceProviderBean.setProviderVehicleDetailsID(providerDetails.getProviderVehicleDetails().get(0).getProviderVehicleDetailsID());
		}
		
		BookingConfirmResponseBean bookingConfirmResponseBean = restTemplate.postForObject("http://localhost:8081/bookings/orderConfirmation", serviceProviderBean, BookingConfirmResponseBean.class);
		
		return bookingConfirmResponseBean;
//		return new BookingConfirmResponseBean();
	}

}
