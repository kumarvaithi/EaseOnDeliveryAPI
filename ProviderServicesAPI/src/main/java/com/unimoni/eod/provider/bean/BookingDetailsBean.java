package com.unimoni.eod.provider.bean;

import java.util.List;

public class BookingDetailsBean {
	
	private int bookingID;
	private String pickupLocation;
	private String dropLocation;
	private String deliverWhen;
	private String itemType;
	private String itemTentativeWeight;
	private String deliveryDate;
	private String storePersonName;
	private String storePersonContactNo;
	private double billAmount;
	private double tax;
	private double commsion;
	private double totalBillAmount;
	private String bookingDate;
	private String paymentMode;
	private String vehicleModel;
	private String vehicleNo;
	private String vehicleType;
	private String providerContactNo;
	private String providerName;
	private String estimatedPickupTime;
	private List<BookingTxnStatusBean> bookingTxnStatus;
	private BookingCustomerDetailsBean bookingCustomerDetails;
	
	public int getBookingID() {
		return bookingID;
	}
	public BookingDetailsBean setBookingID(int bookingID) {
		this.bookingID = bookingID;
		return this;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public BookingDetailsBean setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public BookingDetailsBean setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
		return this;
	}
	public String getDeliverWhen() {
		return deliverWhen;
	}
	public BookingDetailsBean setDeliverWhen(String deliverWhen) {
		this.deliverWhen = deliverWhen;
		return this;
	}
	public String getItemType() {
		return itemType;
	}
	public BookingDetailsBean setItemType(String itemType) {
		this.itemType = itemType;
		return this;
	}
	public String getItemTentativeWeight() {
		return itemTentativeWeight;
	}
	public BookingDetailsBean setItemTentativeWeight(String itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public BookingDetailsBean setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public String getStorePersonName() {
		return storePersonName;
	}
	public BookingDetailsBean setStorePersonName(String storePersonName) {
		this.storePersonName = storePersonName;
		return this;
	}
	public String getStorePersonContactNo() {
		return storePersonContactNo;
	}
	public BookingDetailsBean setStorePersonContactNo(String storePersonContactNo) {
		this.storePersonContactNo = storePersonContactNo;
		return this;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public BookingDetailsBean setBillAmount(double billAmount) {
		this.billAmount = billAmount;
		return this;
	}
	public double getTax() {
		return tax;
	}
	public BookingDetailsBean setTax(double tax) {
		this.tax = tax;
		return this;
	}
	public double getCommsion() {
		return commsion;
	}
	public BookingDetailsBean setCommsion(double commsion) {
		this.commsion = commsion;
		return this;
	}
	public double getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingDetailsBean setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public BookingDetailsBean setBookingDate(String bookingDate) {
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
	public BookingDetailsBean setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
		return this;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public BookingDetailsBean setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
		return this;
	}
	public String getProviderContactNo() {
		return providerContactNo;
	}
	public BookingDetailsBean setProviderContactNo(String providerContactNo) {
		this.providerContactNo = providerContactNo;
		return this;
	}
	public String getProviderName() {
		return providerName;
	}
	public BookingDetailsBean setProviderName(String providerName) {
		this.providerName = providerName;
		return this;
	}
	public String getEstimatedPickupTime() {
		return estimatedPickupTime;
	}
	public BookingDetailsBean setEstimatedPickupTime(String estimatedPickupTime) {
		this.estimatedPickupTime = estimatedPickupTime;
		return this;
	}
	public List<BookingTxnStatusBean> getBookingTxnStatus() {
		return bookingTxnStatus;
	}
	public void setBookingTxnStatus(List<BookingTxnStatusBean> bookingTxnStatus) {
		this.bookingTxnStatus = bookingTxnStatus;
	}
	public BookingCustomerDetailsBean getBookingCustomerDetails() {
		return bookingCustomerDetails;
	}
	public void setBookingCustomerDetails(BookingCustomerDetailsBean bookingCustomerDetails) {
		this.bookingCustomerDetails = bookingCustomerDetails;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}
