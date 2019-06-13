package com.unimoni.eod.booking.bean;

public class BookingConfirmRequestBean {

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
