	package com.unimoni.eod.booking.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "OTPDetails")
@JsonIgnoreProperties("generatedOn")
public class OTPDetails {
	
	@Id
	private int ID;
	
	@Column(name = "bookingID")
	private int bookingID;
	
	@Column(name = "OTP")
	private int OTP;
	
	@Column(name = "status") // I - Initial S - Sent V - Verified
	private String status;

	@Column(name = "userType") // C - Customer P - Provider
	private String userType;
	
	@Column(name = "generatedOn")
	private LocalDate generatedOn;

	public int getID() {
		return ID;
	}

	public OTPDetails setID(int iD) {
		ID = iD;
		return this;
	}

	public int getBookingID() {
		return bookingID;
	}

	public OTPDetails setBookingID(int bookingID) {
		this.bookingID = bookingID;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public OTPDetails setStatus(String status) {
		this.status = status;
		return this;
	}

	public int getOTP() {
		return OTP;
	}

	public OTPDetails setOTP(int oTP) {
		OTP = oTP;
		return this;
	}

	public String getUserType() {
		return userType;
	}

	public OTPDetails setUserType(String userType) {
		this.userType = userType;
		return this;
	}

	public LocalDate getGeneratedOn() {
		return generatedOn;
	}

	public OTPDetails setGeneratedOn(LocalDate generatedOn) {
		this.generatedOn = generatedOn;
		return this;
	}
}
