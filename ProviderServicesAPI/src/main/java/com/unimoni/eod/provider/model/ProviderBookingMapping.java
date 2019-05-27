package com.unimoni.eod.provider.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProviderBookingMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private int bookingID;
	private int providerID;
	private String status;
	private LocalDate bookingDate;
	private LocalDate bookingResponseDate;
	
	public int getID() {
		return ID;
	}
	public ProviderBookingMapping setID(int iD) {
		ID = iD;
		return this;
	}
	public int getBookingID() {
		return bookingID;
	}
	public ProviderBookingMapping setBookingID(int bookingID) {
		this.bookingID = bookingID;
		return this;
	}
	public int getProviderID() {
		return providerID;
	}
	public ProviderBookingMapping setProviderID(int providerID) {
		this.providerID = providerID;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public ProviderBookingMapping setStatus(String status) {
		this.status = status;
		return this;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public ProviderBookingMapping setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
		return this;
	}
	public LocalDate getBookingResponseDate() {
		return bookingResponseDate;
	}
	public ProviderBookingMapping setBookingResponseDate(LocalDate bookingResponseDate) {
		this.bookingResponseDate = bookingResponseDate;
		return this;
	}
}