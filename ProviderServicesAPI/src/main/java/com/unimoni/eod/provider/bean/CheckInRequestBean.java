package com.unimoni.eod.provider.bean;

public class CheckInRequestBean {

	private int providerID;
	private String currentLocation;
	private String providerStatus;

	public int getProviderID() {
		return providerID;
	}

	public CheckInRequestBean setProviderID(int providerID) {
		this.providerID = providerID;
		return this;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}
	
	public CheckInRequestBean setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		return this;
	}

	public String getProviderStatus() {
		return providerStatus;
	}

	public CheckInRequestBean setProviderStatus(String providerStatus) {
		this.providerStatus = providerStatus;
		return this;
	}
}