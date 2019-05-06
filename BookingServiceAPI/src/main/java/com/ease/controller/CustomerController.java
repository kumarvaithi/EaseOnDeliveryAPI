package com.ease.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ease.booking.bean.BookingRequestBean;
import com.ease.booking.bean.BookingResponseBean;
import com.ease.booking.impl.BookingServicesImpl;
import com.ease.customer.model.BookingHistoryRequestBean;
import com.ease.customer.model.BookingHistoryResponseBean;
import com.ease.customer.model.DeliveryChargesRequestBean;
import com.ease.customer.model.DeliveryChargesResponseBean;

@RestController()
@RequestMapping("/api/customer")
public class CustomerController {

	@PostMapping(value="/booking/confirm")
	private BookingResponseBean bookDelivery(@Valid @RequestBody BookingRequestBean request) {
		try {
			BookingServicesImpl impl = new BookingServicesImpl();
			impl.confirmBooking(request);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new BookingResponseBean();
	}
	
	@GetMapping(value="/deliveryCharges")
	private DeliveryChargesResponseBean getDeliveryCharges(@Valid @RequestBody DeliveryChargesRequestBean request) {
		return new DeliveryChargesResponseBean();
	}
	
	
	@GetMapping(value="/booking/history")
	private BookingHistoryResponseBean bookingHistory(@Valid @RequestBody BookingHistoryRequestBean request) {
		return new BookingHistoryResponseBean();
	}
}
