package com.unimoni.eod.booking.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "BookingTxn")
@JsonIgnoreProperties("createdAt")
public class BookingTxn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingID")
	private int bookingID;

	@OneToMany(mappedBy="bookingTxn", cascade = CascadeType.PERSIST)
	private List<BookingTxnStatus> bookingTxnStatus;
	
	@OneToOne(mappedBy = "bookingTxn",cascade = CascadeType.ALL)
	@JoinColumn(name="bookingID")
	private BookingCustomerDetails bookingCustomerDetails;
	
	@Column(name = "customerID")
	private int customerID;
	
	@Column(name = "providerID")
	private int providerID;
	
	@Column(name = "vehicleID")
	private int vehicleID;
	
	private String pickUpLocation;
	
	private String dropLocation;
	
	@Column(name = "deliverWhen")
	private String deliverWhen;
	
	@Column(name = "itemType")
	private String itemType;
	
	@Column(name = "itemTentativeWeight")
	private Double itemTentativeWeight;
	
	@Column(name = "deliveryDate")
	private Timestamp deliveryDate;
	
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
	private LocalDate bookingDate;
	
	
	@Column(name = "createdAt")
	private LocalDate createdAt;
	
	@Column(name = "bookingStatus")
	private String bookingStatus;
	
	public BookingTxn( ) {
		
	}
	
//	public BookingTxn(Long i, String pickUpLocation) {
//		this.bookingID = i;
//		this.pickUpLocation = pickUpLocation;
//	}
	
	public int getBookingID() {
		return bookingID;
	}

	public BookingTxn setBookingID(int bookingID) {
		this.bookingID = bookingID;
		return this;
	}

	public int getCustomerID() {
		return customerID;
	}

	public BookingTxn setCustomerID(int customerID) {
		this.customerID = customerID;
		return this;
	}

	public int getProviderID() {
		return providerID;
	}

	public BookingTxn setProviderID(int providerID) {
		this.providerID = providerID;
		return this;
	}

	public List<BookingTxnStatus> getBookingTxnStatus() {
		return bookingTxnStatus;
	}

	public BookingTxn setBookingTxnStatus(List<BookingTxnStatus> bookingTxnStatus) {
		this.bookingTxnStatus = bookingTxnStatus;
		return this;
	}

	
	public BookingCustomerDetails getBookingCustomerDetails() {
		return bookingCustomerDetails;
	}

	public BookingTxn setBookingCustomerDetails(BookingCustomerDetails bookingCustomerDetails) {
		this.bookingCustomerDetails = bookingCustomerDetails;
		return this;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public BookingTxn setVehicleID(int vehicleID) {
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

	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public BookingTxn setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public BookingTxn setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
		return this;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public BookingTxn setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public BookingTxn setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
		return this;
	}

	@Override
	public String toString() {
		return "BookingTxn [bookingID=" + bookingID + ", customerID=" + customerID + ", providerID=" + providerID
				+ ", vehicleID=" + vehicleID + ", pickUpLocation=" + pickUpLocation + ", dropLocation=" + dropLocation
				+ ", deliverWhen=" + deliverWhen + ", itemType=" + itemType + ", itemTentativeWeight="
				+ itemTentativeWeight + ", storePersonName=" + storePersonName + ", storePersonContactNo=" + storePersonContactNo
				+ ", billAmount=" + billAmount + ", commission=" + commission + ", vat=" + vat + ", totalBillAmount="
				+ totalBillAmount + ", bookingDate=" + bookingDate
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
}
