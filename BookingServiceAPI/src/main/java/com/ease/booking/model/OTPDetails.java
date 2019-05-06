	package com.ease.booking.model;

import javax.persistence.Column;

public class OTPDetails {
	
	@Column(name = "bookingID")
	private String bookingID;
	
	@Column(name = "customerOTP")
	private int customerOTP;
	
	@Column(name = "providerOTP")
	private int providerOTP;
	
	@Column(name = "storeOTP")
	private int storeOTP;
	
	@Column(name = "status")
	private String status;

	public String getBookingID() {
		return bookingID;
	}

	public OTPDetails setBookingID(String bookingID) {
		this.bookingID = bookingID;
		return this;
	}

	public int getCustomerOTP() {
		return customerOTP;
	}

	public OTPDetails setCustomerOTP(int customerOTP) {
		this.customerOTP = customerOTP;
		return this;
	}

	public int getProviderOTP() {
		return providerOTP;
	}

	public OTPDetails setProviderOTP(int providerOTP) {
		this.providerOTP = providerOTP;
		return this;
	}

	public int getStoreOTP() {
		return storeOTP;
	}

	public OTPDetails setStoreOTP(int storeOTP) {
		this.storeOTP = storeOTP;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OTPDetails setStatus(String status) {
		this.status = status;
		return this;
	}
	
	

}
