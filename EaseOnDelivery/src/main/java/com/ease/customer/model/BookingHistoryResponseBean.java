package com.ease.customer.model;

import java.util.List;

import com.ease.bean.CommonResponseBean;

public class BookingHistoryResponseBean {

	private String pickupLocation;
	private String dropLocation;
	private String itemType;
	private String itemTentativeWeight;
	private String deliveryDate;
	private String deliveryTime;
	private String storePersonName;
	private String storePersonContactNo;
	private double totalBillAmount;
	private String bookingDate;
	private String paymentMode;
	private String vehicleModel;
	private String vehicleNo;
	private String providerContactNo;
	private String providerName;
	private List<CommonResponseBean> resultData;
	
	public String getPickupLocation() {
		return pickupLocation;
	}
	public BookingHistoryResponseBean setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public BookingHistoryResponseBean setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
		return this;
	}
	
	public String getItemType() {
		return itemType;
	}
	public BookingHistoryResponseBean setItemType(String itemType) {
		this.itemType = itemType;
		return this;
	}
	public String getItemTentativeWeight() {
		return itemTentativeWeight;
	}
	public BookingHistoryResponseBean setItemTentativeWeight(String itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public BookingHistoryResponseBean setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public BookingHistoryResponseBean setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}
	public String getStorePersonName() {
		return storePersonName;
	}
	public BookingHistoryResponseBean setStorePersonName(String storePersonName) {
		this.storePersonName = storePersonName;
		return this;
	}
	public String getStorePersonContactNo() {
		return storePersonContactNo;
	}
	public BookingHistoryResponseBean setStorePersonContactNo(String storePersonContactNo) {
		this.storePersonContactNo = storePersonContactNo;
		return this;
	}
	public double getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingHistoryResponseBean setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public BookingHistoryResponseBean setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
		return this;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public BookingHistoryResponseBean setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
		return this;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public BookingHistoryResponseBean setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
		return this;
	}
	public String getProviderContactNo() {
		return providerContactNo;
	}
	public BookingHistoryResponseBean setProviderContactNo(String providerContactNo) {
		this.providerContactNo = providerContactNo;
		return this;
	}
	public String getProviderName() {
		return providerName;
	}
	public BookingHistoryResponseBean setProviderName(String providerName) {
		this.providerName = providerName;
		return this;
	}
	public List<CommonResponseBean> getResultData() {
		return resultData;
	}
	public BookingHistoryResponseBean setResultData(List<CommonResponseBean> resultData) {
		this.resultData = resultData;
		return this;
	}
}
