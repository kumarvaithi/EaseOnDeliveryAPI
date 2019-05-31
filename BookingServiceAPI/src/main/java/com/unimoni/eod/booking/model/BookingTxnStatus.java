package com.unimoni.eod.booking.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "BookingTxnStatus")
public class BookingTxnStatus {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;
	
	@ManyToOne
	@JoinColumn(name="bookingid")
	private BookingTxn bookingTxn;
	private String status;
	private LocalDate modifiedAt;
	private String modifiedBy;
	
	public int getSerialNo() {
		return serialNo;
	}
	public BookingTxnStatus setSerialNo(int serialNo) {
		this.serialNo = serialNo;
		return this;
	}
	
	
	public BookingTxn getBookingTxn() {
		return bookingTxn;
	}
	
	public BookingTxnStatus setBookingTxn(BookingTxn bookingTxn) {
		this.bookingTxn = bookingTxn;
		return this;
	}
	
	public String getStatus() {
		return status;
	}
	public BookingTxnStatus setStatus(String status) {
		this.status = status;
		return this;
	}
	public LocalDate getModifiedAt() {
		return modifiedAt;
	}
	public BookingTxnStatus setModifiedAt(LocalDate modifiedAt) {
		this.modifiedAt = modifiedAt;
		return this;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public BookingTxnStatus setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
		return this;
	}
}
