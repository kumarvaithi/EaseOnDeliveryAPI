package com.unimoni.eod.booking.bean;

import java.util.Date;

public class BookingHistoryResponseBean {
	
	private String deliveryProductType;
	private Double tentativeWeight;
	private Date deliveryDate;
	private String deliveryPersonName;
	private String deliveryPersonContactNo;
	private String paymentMode;
	private String vehicleType;
	private String vehicleName;
	private String vehicleRegNo;
	
	public String getDeliveryProductType() {
		return deliveryProductType;
	}
	public BookingHistoryResponseBean setDeliveryProductType(String deliveryProductType) {
		this.deliveryProductType = deliveryProductType;
		return this;
	}
	public Double getTentativeWeight() {
		return tentativeWeight;
	}
	public BookingHistoryResponseBean setTentativeWeight(Double tentativeWeight) {
		this.tentativeWeight = tentativeWeight;
		return this;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public BookingHistoryResponseBean setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}
	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}
	public BookingHistoryResponseBean setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
		return this;
	}
	public String getDeliveryPersonContactNo() {
		return deliveryPersonContactNo;
	}
	public BookingHistoryResponseBean setDeliveryPersonContactNo(String deliveryPersonContactNo) {
		this.deliveryPersonContactNo = deliveryPersonContactNo;
		return this;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public BookingHistoryResponseBean setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
		return this;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public BookingHistoryResponseBean setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public BookingHistoryResponseBean setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
		return this;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public BookingHistoryResponseBean setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
		return this;
	}
	
	
	

}
