package com.ease.provider.model;

public class CheckInRequestBean {

	private String currentLocation;
	private String checkinDateTime;

	public String getCurrentLocation() {
		return currentLocation;
	}
	public CheckInRequestBean setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		return this;
	}
	public String getCheckinDateTime() {
		return checkinDateTime;
	}
	public CheckInRequestBean setCheckinDateTime(String checkinDateTime) {
		this.checkinDateTime = checkinDateTime;
		return this;
	}
	
}
