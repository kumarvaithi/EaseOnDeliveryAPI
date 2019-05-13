package com.unimoni.eod.booking.bean;

public class BookingRequestBean {
	
	private String pickupLocation;
	private String dropLocation;
	private String deliverWhen;
	private String itemType;
	private String itemTentativeWeight;
	private String deliveryDate;
	private String deliveryTime;
	private String storePersonName;
	private String storePersonContactNo;
	private String billAmount;
	private String vat;
	private String commsion;
	private String totalBillAmount;
	private String paymentMode;
	private int customerID;
	private int providerID;

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
	public String getItemTentativeWeight() {
		return itemTentativeWeight;
	}
	public BookingRequestBean setItemTentativeWeight(String itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public BookingRequestBean setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public BookingRequestBean setDeliveryTime(String deliveryTime) {
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
	public String getBillAmount() {
		return billAmount;
	}
	public BookingRequestBean setBillAmount(String billAmount) {
		this.billAmount = billAmount;
		return this;
	}
	public String getVat() {
		return vat;
	}
	public BookingRequestBean setVat(String vat) {
		this.vat = vat;
		return this;
	}
	public String getCommsion() {
		return commsion;
	}
	public BookingRequestBean setCommsion(String commsion) {
		this.commsion = commsion;
		return this;
	}
	public String getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingRequestBean setTotalBillAmount(String totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public BookingRequestBean setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
		return this;
	}
	public int getCustomerID() {
		return customerID;
	}
	public BookingRequestBean setCustomerID(int customerID) {
		this.customerID = customerID;
		return this;
	}
	public int getProviderID() {
		return providerID;
	}
	public BookingRequestBean setProviderID(int providerID) {
		this.providerID = providerID;
		return this;
	}
}