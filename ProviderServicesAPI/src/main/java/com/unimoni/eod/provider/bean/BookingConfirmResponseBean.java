package com.unimoni.eod.provider.bean;


public class BookingConfirmResponseBean {

	private int bookingID;
	private int providerID;
	private String bookingStatus;
	private Long providerVehicleDetailsID;



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

	public Long getProviderVehicleDetailsID() {
		return providerVehicleDetailsID;
	}

	public void setProviderVehicleDetailsID(Long providerVehicleDetailsID) {
		this.providerVehicleDetailsID = providerVehicleDetailsID;
	}

	

}
