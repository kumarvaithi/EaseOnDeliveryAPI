package com.unimoni.eod.provider.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.eod.provider.bean.CheckInRequestBean;
import com.unimoni.eod.provider.bean.CheckInResponseBean;
import com.unimoni.eod.provider.impl.CheckInImpl;

@RestController
@RequestMapping("/api/provider")
public class ProviderContoller {

	@Autowired
	@Qualifier("checkIn")
	CheckInImpl checkin;
	
	@PostMapping(value="/accept")
	private String accept() {
		return "Electronic Items waiting for delivery, kindly confirm";
	}
	
	@PostMapping(value="/reject")
	private String reject() {
		return "Electronic Items waiting for delivery, kindly confirm";
	}
	
	
	@PostMapping(value="/checkin")
	private CheckInResponseBean checkin(@Valid @RequestBody CheckInRequestBean request) {
		checkin.checkIn(request);
		return null;
	}
}