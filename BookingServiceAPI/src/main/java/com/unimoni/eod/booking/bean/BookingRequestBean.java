package com.unimoni.eod.booking.bean;

import java.util.Date;

public class BookingRequestBean {
	
	private String pickupLocation;
	private String dropLocation;
	private String deliverWhen;
	private String itemType;
	private Double itemTentativeWeight;
	private Date deliveryDate;
	private Date deliveryTime;
	private String storePersonName;
	private String storePersonContactNo;
	private Double billAmount;
	private Double vat;
	private Double commsion;
	private Double totalBillAmount;
	private String bookingDate;
	private String paymentMode;
	private Long customerID;
	private Long providerID;

	public String getPickupLocation() {
		return pickupLocation;
	}
	public BookingRequestBean setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public BookingRequestBean setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
		return this;
	}
	public String getDeliverWhen() {
		return deliverWhen;
	}
	public BookingRequestBean setDeliverWhen(String deliverWhen) {
		this.deliverWhen = deliverWhen;
		return this;
	}
	public String getItemType() {
		return itemType;
	}
	public BookingRequestBean setItemType(String itemType) {
		this.itemType = itemType;
		return this;
	}

	public Double getItemTentativeWeight() {
		return itemTentativeWeight;
	}
	public BookingRequestBean setItemTentativeWeight(Double itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public BookingRequestBean setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}
	
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public BookingRequestBean setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}
	public String getStorePersonName() {
		return storePersonName;
	}
	public BookingRequestBean setStorePersonName(String storePersonName) {
		this.storePersonName = storePersonName;
		return this;
	}
	public String getStorePersonContactNo() {
		return storePersonContactNo;
	}
	public BookingRequestBean setStorePersonContactNo(String storePersonContactNo) {
		this.storePersonContactNo = storePersonContactNo;
		return this;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public BookingRequestBean setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
		return this;
	}
	public Double getVat() {
		return vat;
	}
	public BookingRequestBean setVat(Double vat) {
		this.vat = vat;
		return this;
	}
	public Double getCommsion() {
		return commsion;
	}
	public BookingRequestBean setCommsion(Double commsion) {
		this.commsion = commsion;
		return this;
	}
	public Double getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingRequestBean setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public BookingRequestBean setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
		return this;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public BookingRequestBean setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
		return this;
	}
	
	public Long getCustomerID() {
		return customerID;
	}
	public BookingRequestBean setCustomerID(Long customerID) {
		this.customerID = customerID;
		return this;
	}
	public Long getProviderID() {
		return providerID;
	}
	public BookingRequestBean setProviderID(Long providerID) {
		this.providerID = providerID;
		return this;
	}
}
