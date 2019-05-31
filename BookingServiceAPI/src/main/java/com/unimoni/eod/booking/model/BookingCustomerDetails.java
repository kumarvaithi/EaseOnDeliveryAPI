package com.unimoni.eod.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BookingCustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	private int customerID;
	private String name;
	private String address;
	private String mobileNo;
	private String alternativeMobileNo;
	private String emailID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bookingID")
	private BookingTxn bookingTxn;

	public BookingTxn getBookingTxn() {
		return bookingTxn;
	}

	public BookingCustomerDetails setBookingTxn(BookingTxn bookingTxn) {
		this.bookingTxn = bookingTxn;
		return this;
	}

	public int getSerialNo() {
		return serialNo;
	}
	
	public BookingCustomerDetails setSerialNo(int serialNo) {
		this.serialNo = serialNo;
		return this;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public BookingCustomerDetails setCustomerID(int customerID) {
		this.customerID = customerID;
		return this;
	}
	public String getName() {
		return name;
	}
	public BookingCustomerDetails setName(String name) {
		this.name = name;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public BookingCustomerDetails setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public BookingCustomerDetails setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}
	public String getAlternativeMobileNo() {
		return alternativeMobileNo;
	}
	public BookingCustomerDetails setAlternativeMobileNo(String alternativeMobileNo) {
		this.alternativeMobileNo = alternativeMobileNo;
		return this;
	}
	public String getEmailID() {
		return emailID;
	}
	public BookingCustomerDetails setEmailID(String emailID) {
		this.emailID = emailID;
		return this;
	}
}