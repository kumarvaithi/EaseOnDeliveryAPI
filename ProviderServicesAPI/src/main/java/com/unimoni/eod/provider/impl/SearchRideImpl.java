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
import com.unimoni.eod.provider.bean.CommonResponseBean;
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
	
	@Autowired
	ProviderBookingMapRepository providerBookingMapRepository;
	
	@Override
	public BookingDetailsListBean searchRide(int providerID,String status) {
		List<ProviderBookingMapping> providerBookingMap = providerBookingMapRepo.findByProviderIDAndStatus(providerID, status);
		List bookingIDList = new ArrayList();
		
		for(int i=0;i<providerBookingMap.size();i++) {
			bookingIDList.add(providerBookingMap.get(i).getBookingID());
			if(status.equals("N")) {
				providerBookingMap.get(i).setStatus("I");
				providerBookingMapRepo.save(providerBookingMap.get(i));
			}
		}
		
		SearchBookingBean searchBooking = new SearchBookingBean();
		searchBooking.setBookingID(bookingIDList);
		BookingDetailsListBean response = restTemplate.postForObject("http://localhost:8081/bookings/search", searchBooking, BookingDetailsListBean.class);
		return response;
	}

	@Override
	public BookingDetailsListBean viewBooking(int bookingID) {
		List bookingIDList = new ArrayList();
		bookingIDList.add(bookingID);
		SearchBookingBean searchBooking = new SearchBookingBean();
		searchBooking.setBookingID(bookingIDList);
		BookingDetailsListBean response = restTemplate.postForObject("http://localhost:8081/bookings/search", searchBooking, BookingDetailsListBean.class);
		return response;
	}
	
	@Override
	public CommonResponseBean verifyPIN(String userType, int providerID, int bookingID, int pin) {
		String status = "D";
		
		CommonResponseBean commonResponse = restTemplate.exchange("http://localhost:8081/bookings/verify/"+bookingID + "/" + userType + "/" + pin, HttpMethod.GET, null, new ParameterizedTypeReference<CommonResponseBean>() {
		}, CommonResponseBean.class).getBody();

		ProviderBookingMapping providerBookingMapping = providerBookingMapRepository.findByProviderIDAndBookingID(providerID, bookingID);

		if(userType.equals("C")) {
			providerBookingMapping.setStatus(status);
			providerBookingMapRepository.save(providerBookingMapping);
		}
			
		return commonResponse;
	}
}