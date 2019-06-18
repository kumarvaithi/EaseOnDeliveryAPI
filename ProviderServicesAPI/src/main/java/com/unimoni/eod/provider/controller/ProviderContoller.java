package com.unimoni.eod.provider.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.eod.provider.bean.BookingConfirmResponseBean;
import com.unimoni.eod.provider.bean.BookingDetailsListBean;
import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;
import com.unimoni.eod.provider.bean.CommonResponseBean;
import com.unimoni.eod.provider.bean.ServiceProviderBean;
import com.unimoni.eod.provider.impl.BookingImpl;
import com.unimoni.eod.provider.impl.CheckInImpl;
import com.unimoni.eod.provider.impl.SearchRideImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("provider")
public class ProviderContoller {

	@Autowired
	@Qualifier("checkIn")
	CheckInImpl checkin;
	
	@Autowired
	@Qualifier("booking")
	BookingImpl bookingImpl;

	@Autowired
	@Qualifier("searchRide")
	SearchRideImpl searchRide;
	
	@PostMapping(value="/accept")
	private BookingConfirmResponseBean accept(@RequestBody ServiceProviderBean serviceProviderBean) {
		BookingConfirmResponseBean response = bookingImpl.bookingConfirm(serviceProviderBean);
		return response;
	}

	@PostMapping(value="/reject")
	private String reject() {
		return "Electronic Items waiting for delivery, kindly confirm";
	}
	
	@GetMapping(value="/searchRide/{providerID}/{status}")
	private BookingDetailsListBean searchRide(@PathVariable int providerID,@PathVariable String status) {
		System.out.println("provider id is " + providerID + " status is " + status);
		BookingDetailsListBean response = searchRide.searchRide(providerID,status);
		return response;
	}
	
	@GetMapping(value="/view/{bookingID}")
	private BookingDetailsListBean viewBooking(@PathVariable int bookingID) {
		BookingDetailsListBean response = searchRide.viewBooking(bookingID);
		return response;
	}
	
	
	@PostMapping(value="/checkin")
	private CheckInResponseBean checkin(@Valid @RequestBody CheckInRequestBean request) {
		checkin.checkIn(request);
		return null;
	}
	
	@GetMapping(value="/verify/{providerID}/{bookingID}/{userType}/{pin}")
	private CommonResponseBean verifyOTP(@PathVariable String userType,@PathVariable int providerID,@PathVariable int bookingID,@PathVariable int pin) {
		System.out.println("User Type - " + userType + "otp - " + pin);
		CommonResponseBean commonResponse = searchRide.verifyPIN(userType, providerID,bookingID, pin);
		return commonResponse;
	}
}