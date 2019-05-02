package com.ease.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/provider")
public class ProviderContoller {

	@PostMapping(value="/accept")
	private String accept() {
		return "Electronic Items waiting for delivery, kindly confirm";
	}
	
	@PostMapping(value="/reject")
	private String reject() {
		return "Electronic Items waiting for delivery, kindly confirm";
	}
	
	@PutMapping(value="/checkin")
	private String checkin() {
		return "Your Online now";
	}
}