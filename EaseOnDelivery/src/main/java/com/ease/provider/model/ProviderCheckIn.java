package com.ease.provider.model;

import java.time.LocalDate;

public class ProviderCheckIn {
	
	private Long providerCheckInID;
	private Long providerID;
	private String currentLocation;
	private LocalDate checkInTime;
	private LocalDate checkOutTime;
	private String status;
}
