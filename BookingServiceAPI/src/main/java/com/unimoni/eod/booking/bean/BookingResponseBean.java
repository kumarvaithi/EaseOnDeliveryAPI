package com.unimoni.eod.booking.bean;

import java.util.List;

import com.unimoni.eod.booking.model.BookingCustomerDetails;
import com.unimoni.eod.booking.model.BookingTxnStatus;


public class BookingResponseBean {
	
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
	private String vehicleModel;
	private String vehicleNo;
	private String providerContactNo;
	private String providerName;
	private String estimatedPickupTime;
	private String vehicleType;
	private String paymentMode;
	private String bookingStatus;
	private List<BookingTxnStatus> bookingTxnStatus;
	private BookingCustomerDetails bookingCustomerDetails;
	private CommonResponseBean resultData;
	
	public int getBookingID() {
		return bookingID;
	}
	public BookingResponseBean setBookingID(int bookingID) {
		this.bookingID = bookingID;
		return this;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public BookingResponseBean setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
		return this;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public BookingResponseBean setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
		return this;
	}
	public String getDeliverWhen() {
		return deliverWhen;
	}
	public BookingResponseBean setDeliverWhen(String deliverWhen) {
		this.deliverWhen = deliverWhen;
		return this;
	}
	public String getItemType() {
		return itemType;
	}
	public BookingResponseBean setItemType(String itemType) {
		this.itemType = itemType;
		return this;
	}
	public String getItemTentativeWeight() {
		return itemTentativeWeight;
	}
	public BookingResponseBean setItemTentativeWeight(String itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public BookingResponseBean setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public String getStorePersonName() {
		return storePersonName;
	}
	public BookingResponseBean setStorePersonName(String storePersonName) {
		this.storePersonName = storePersonName;
		return this;
	}
	public String getStorePersonContactNo() {
		return storePersonContactNo;
	}
	public BookingResponseBean setStorePersonContactNo(String storePersonContactNo) {
		this.storePersonContactNo = storePersonContactNo;
		return this;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public BookingResponseBean setBillAmount(double billAmount) {
		this.billAmount = billAmount;
		return this;
	}
	public double getTax() {
		return tax;
	}
	public BookingResponseBean setTax(double tax) {
		this.tax = tax;
		return this;
	}
	public double getCommsion() {
		return commsion;
	}
	public BookingResponseBean setCommsion(double commsion) {
		this.commsion = commsion;
		return this;
	}
	public double getTotalBillAmount() {
		return totalBillAmount;
	}
	public BookingResponseBean setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public BookingResponseBean setBookingDate(String bookingDate) {
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
	public BookingResponseBean setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
		return this;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public BookingResponseBean setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
		return this;
	}
	public String getProviderContactNo() {
		return providerContactNo;
	}
	public BookingResponseBean setProviderContactNo(String providerContactNo) {
		this.providerContactNo = providerContactNo;
		return this;
	}
	public String getProviderName() {
		return providerName;
	}
	public BookingResponseBean setProviderName(String providerName) {
		this.providerName = providerName;
		return this;
	}
	public String getEstimatedPickupTime() {
		return estimatedPickupTime;
	}
	public BookingResponseBean setEstimatedPickupTime(String estimatedPickupTime) {
		this.estimatedPickupTime = estimatedPickupTime;
		return this;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	public BookingResponseBean setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	
	public CommonResponseBean getResultData() {
		return resultData;
	}
	public BookingResponseBean setResultData(CommonResponseBean resultData) {
		this.resultData = resultData;
		return this;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public BookingResponseBean setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
		return this;
	}
	public List<BookingTxnStatus> getBookingTxnStatus() {
		return bookingTxnStatus;
	}
	public BookingResponseBean setBookingTxnStatus(List<BookingTxnStatus> bookingTxnStatus) {
		this.bookingTxnStatus = bookingTxnStatus;
		return this;
	}
	public BookingCustomerDetails getBookingCustomerDetails() {
		return bookingCustomerDetails;
	}
	public BookingResponseBean setBookingCustomerDetails(BookingCustomerDetails bookingCustomerDetails) {
		this.bookingCustomerDetails = bookingCustomerDetails;
		return this;
	}
}
