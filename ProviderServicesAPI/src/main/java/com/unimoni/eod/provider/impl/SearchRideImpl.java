package com.unimoni.eod.provider.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.unimoni.eod.provider.bean.BookingDetailsBean;
import com.unimoni.eod.provider.bean.BookingDetailsListBean;
import com.unimoni.eod.provider.bean.SearchBookingBean;
import com.unimoni.eod.provider.model.ProviderBookingMapping;
import com.unimoni.eod.provider.repo.ProviderBookingMapRepository;
import com.unimoni.eod.provider.services.SearchRideServices;

@Service("searchRide")
public class SearchRideImpl implements SearchRideServices {

	@Autowired
	ProviderBookingMapRepository providerBookingMapRepo;

	@Autowired
	RestTemplate restTemplate;
	@Override
	public void searchRide(int providerID) {
		String status = "I";
		List<ProviderBookingMapping> providerBookingMap = providerBookingMapRepo.findByProviderIDAndStatus(providerID, status);
		List bookingIDList = new ArrayList();
		for(int i=0;i<providerBookingMap.size();i++) {
			bookingIDList.add(providerBookingMap.get(0).getBookingID());
		}
		SearchBookingBean searchBooking = new SearchBookingBean();
		searchBooking.setBookingID(bookingIDList);
		
		BookingDetailsListBean response = restTemplate.postForObject("http://localhost:8081/bookings/search", searchBooking, BookingDetailsListBean.class);
		System.out.println("Response size is " + response.getBookingDetailsList().size());
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}