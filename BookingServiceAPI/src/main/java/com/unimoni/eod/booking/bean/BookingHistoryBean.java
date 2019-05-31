package com.unimoni.eod.booking.bean;

import java.time.LocalDate;
import java.util.Date;

public class BookingHistoryBean {

	private String deliveryProductType;
	private Double tentativeWeight;
	private Date deliveryDate;
	private String deliveryPersonName;
	private String deliveryPersonContactNo;
	private String paymentMode;
	private String vehicleType;
	private String vehicleName;
	private String vehicleRegNo;
	private LocalDate bookingDate;

	public String getDeliveryProductType() {
		return deliveryProductType;
	}

	public BookingHistoryBean setDeliveryProductType(String deliveryProductType) {
		this.deliveryProductType = deliveryProductType;
		return this;
	}

	public Double getTentativeWeight() {
		return tentativeWeight;
	}

	public BookingHistoryBean setTentativeWeight(Double tentativeWeight) {
		this.tentativeWeight = tentativeWeight;
		return this;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public BookingHistoryBean setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public BookingHistoryBean setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
		return this;
	}

	public String getDeliveryPersonContactNo() {
		return deliveryPersonContactNo;
	}

	public BookingHistoryBean setDeliveryPersonContactNo(String deliveryPersonContactNo) {
		this.deliveryPersonContactNo = deliveryPersonContactNo;
		return this;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public BookingHistoryBean setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
		return this;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public BookingHistoryBean setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public BookingHistoryBean setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
		return this;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public BookingHistoryBean setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
		return this;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	@Override
	public String toString() {
		return "BookingHistoryBean [deliveryProductType=" + deliveryProductType + ", tentativeWeight=" + tentativeWeight
				+ ", deliveryDate=" + deliveryDate + ", deliveryPersonName=" + deliveryPersonName
				+ ", deliveryPersonContactNo=" + deliveryPersonContactNo + ", paymentMode=" + paymentMode
				+ ", vehicleType=" + vehicleType + ", vehicleName=" + vehicleName + ", vehicleRegNo=" + vehicleRegNo
				+ "]";
	}

}
