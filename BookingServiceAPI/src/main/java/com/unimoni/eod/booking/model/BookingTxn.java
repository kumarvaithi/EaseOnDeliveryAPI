package com.unimoni.eod.booking.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "BookingTxn")
@JsonIgnoreProperties("createdAt")
public class BookingTxn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingID")
	private Long bookingID;
	
	@Column(name = "customerID")
	@NotEmpty
	private Long customerID;
	
	@Column(name = "providerID")
	private Long providerID;
	
	@Column(name = "vehicleID")
	private Long vehicleID;
	
	@Column(name = "pickUpLocation")
	@NotEmpty @Size(min=10, max=140, message="{booking.pickUpLocation.length}") 
	private String pickUpLocation;
	
	@Column(name = "dropLocation")
	@NotEmpty @Size(min=10, max=140, message="{booking.dropLocation.length}") 
	private String dropLocation;
	
	@Column(name = "deliverWhen")
	private String deliverWhen;
	
	@Column(name = "itemType")
	private String itemType;
	
	@Column(name = "itemTentativeWeight")
	private Double itemTentativeWeight;
	
	@Column(name = "deliveryDate")
	private Date deliveryDate;
	
	@Column(name = "deliveryTime")
	private Date deliveryTime;
	
	@Column(name = "storePersonName")
	private String storePersonName;
	
	@Column(name = "storePersonContactNo")
	private String storePersonContactNo;
	
	@Column(name = "billAmount")
	private Double billAmount;
	
	@Column(name = "commission")
	private Double commission;
	
	@Column(name = "vat")
	private Double vat;
	
	@Column(name = "totalBillAmount")
	private Double totalBillAmount;
	
	@Column(name = "bookingDate")
	private Date bookingDate;
	
	@Column(name = "deliveryStatus")
	private String deliveryStatus;
	
	@Column(name = "createdAt")
	private LocalDate createdAt;

	public Long getBookingID() {
		return bookingID;
	}

	public BookingTxn setBookingID(Long bookingID) {
		this.bookingID = bookingID;
		return this;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public BookingTxn setCustomerID(Long customerID) {
		this.customerID = customerID;
		return this;
	}

	public Long getProviderID() {
		return providerID;
	}

	public BookingTxn setProviderID(Long providerID) {
		this.providerID = providerID;
		return this;
	}

	public Long getVehicleID() {
		return vehicleID;
	}

	public BookingTxn setVehicleID(Long vehicleID) {
		this.vehicleID = vehicleID;
		return this;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public BookingTxn setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
		return this;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public BookingTxn setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
		return this;
	}

	public String getDeliverWhen() {
		return deliverWhen;
	}

	public BookingTxn setDeliverWhen(String deliverWhen) {
		this.deliverWhen = deliverWhen;
		return this;
	}


	public String getItemType() {
		return itemType;
	}

	public BookingTxn setItemType(String itemType) {
		this.itemType = itemType;
		return this;
	}

	public Double getItemTentativeWeight() {
		return itemTentativeWeight;
	}

	public BookingTxn setItemTentativeWeight(Double itemTentativeWeight) {
		this.itemTentativeWeight = itemTentativeWeight;
		return this;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public BookingTxn setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
		return this;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public BookingTxn setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
	}

	public String getStorePersonName() {
		return storePersonName;
	}

	public BookingTxn setStorePersonName(String storePersonName) {
		this.storePersonName = storePersonName;
		return this;
	}

	public String getStorePersonContactNo() {
		return storePersonContactNo;
	}

	public BookingTxn setStorePersonContactNo(String storePersonContactNo) {
		this.storePersonContactNo = storePersonContactNo;
		return this;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public BookingTxn setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
		System.out.println("this :::::"+this.billAmount);
		return this;
	}

	public Double getCommission() {
		return commission;
	}

	public BookingTxn setCommission(Double commission) {
		this.commission = commission;
		return this;
	}

	public Double getVat() {
		return vat;
	}

	public BookingTxn setVat(Double vat) {
		this.vat = vat;
		return this;
	}

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public BookingTxn setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
		return this;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public BookingTxn setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
		return this;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public BookingTxn setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
		return this;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public BookingTxn setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	@Override
	public String toString() {
		return "BookingTxn [bookingID=" + bookingID + ", customerID=" + customerID + ", providerID=" + providerID
				+ ", vehicleID=" + vehicleID + ", pickUpLocation=" + pickUpLocation + ", dropLocation=" + dropLocation
				+ ", deliverWhen=" + deliverWhen + ", itemType=" + itemType + ", itemTentativeWeight="
				+ itemTentativeWeight + ", deliveryDate=" + deliveryDate + ", deliveryTime=" + deliveryTime
				+ ", storePersonName=" + storePersonName + ", storePersonContactNo=" + storePersonContactNo
				+ ", billAmount=" + billAmount + ", commission=" + commission + ", vat=" + vat + ", totalBillAmount="
				+ totalBillAmount + ", bookingDate=" + bookingDate + ", deliveryStatus=" + deliveryStatus
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
