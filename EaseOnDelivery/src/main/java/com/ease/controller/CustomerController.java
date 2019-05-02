package com.ease.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ease.customer.model.BookingHistoryRequestBean;
import com.ease.customer.model.BookingHistoryResponseBean;
import com.ease.customer.model.BookingRequestBean;
import com.ease.customer.model.BookingResponseBean;
import com.ease.customer.model.DeliveryChargesRequestBean;
import com.ease.customer.model.DeliveryChargesResponseBean;

@RestController()
@RequestMapping("/api/customer")
public class CustomerController {

	@PostMapping(value="/booking/confirm")
	private BookingResponseBean bookDelivery(@Valid @RequestBody BookingRequestBean request) {
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
