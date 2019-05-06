package com.ease.customer.model;

import java.time.LocalDate;

import javax.persistence.Column;

public class CustomerDetails {
	
	@Column(name = "customerID")
	private Long customerID;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobileNo")
	private String mobileNo;
	
	@Column(name = "alternateMobileNo")
	private String alternateMobileNo;
	
	@Column(name = "emailID")
	private String emailID;
	
	@Column(name = "pendingAmount")
	private Double pendingAmount;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "createdAt")
	private LocalDate createdAt;
	
	@Column(name = "updatedAt")
	private LocalDate updatedAt;
	
	

}
