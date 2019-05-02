package com.ease.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/location")
public class LocationController {

	@GetMapping(value="/searchLocation")
	private String getLocation() {
		return "Your are in Egmore";
	}
	
	@GetMapping(value="/searchCurrentLocation")
	private String getCurrentLocation() {
		return "You are in Marina";
	}
	
}
