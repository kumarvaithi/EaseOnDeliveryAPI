package com.unimoni.eod.provider.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProviderCheckIn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long providerCheckInID;
	private int providerID;
	private String currentLocation;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	private String status;
	
	public Long getProviderCheckInID() {
		return providerCheckInID;
	}
	public ProviderCheckIn setProviderCheckInID(Long providerCheckInID) {
		this.providerCheckInID = providerCheckInID;
		return this;
	}
	public int getProviderID() {
		return providerID;
	}
	public ProviderCheckIn setProviderID(int providerID) {
		this.providerID = providerID;
		return this;
	}
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public ProviderCheckIn setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		return this;
	}
	public LocalDateTime getCheckInTime() {
		return checkInTime;
	}
	public ProviderCheckIn setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
		return this;
	}
	public LocalDateTime getCheckOutTime() {
		return checkOutTime;
	}
	public ProviderCheckIn setCheckOutTime(LocalDateTime checkOutTime) {
		this.checkOutTime = checkOutTime;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public ProviderCheckIn setStatus(String status) {
		this.status = status;
		return this;
	}
}
