package com.ease.customer.model;

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
	private double billAmount;
	private double tax;
	private double commsion;
	private double totalBillAmount;
	private String bookingDate;
	private String paymentMode;
	
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
	public double getBillAmount() {
		return billAmount;
	}
	public BookingRequestBean setBillAmount(double billAmount) {
		this.billAmount = billAmount;
		return this;
	}
	public double getTax() {
		return tax;
	}
	public BookingRequestBean setTax(double tax) {
		this.tax = tax;
		return this;
	}
	public double getCommsion() {
		return commsion;
	}
	public BookingRequestBean setCommsion(double commsion) {
		this.commsion = commsion;
		return this;
	}
	public double getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingRequestBean setTotalBillAmount(double totalBillAmount) {
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
	
	
}
