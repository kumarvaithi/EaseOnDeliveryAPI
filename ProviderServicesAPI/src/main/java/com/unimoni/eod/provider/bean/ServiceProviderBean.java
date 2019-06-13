package com.unimoni.eod.provider.bean;

import java.io.Serializable;

import com.unimoni.eod.provider.model.ProviderDetails;

public class ServiceProviderBean implements Serializable {

	private int bookingID;
	private int providerID;
	private String bookingStatus;
	private int providerVehicleDetailsID;

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getProviderID() {
		return providerID;
	}

	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getProviderVehicleDetailsID() {
		return providerVehicleDetailsID;
	}

	public void setProviderVehicleDetailsID(int providerVehicleDetailsID) {
		this.providerVehicleDetailsID = providerVehicleDetailsID;
	}

}
