package com.unimoni.eod.provider.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProviderVehicleDetails {

	@Id
	private int providerVehicleDetailsID;
	
	@ManyToOne
	@JoinColumn(name = "providerID")
	private ProviderDetails providerDetails;
	private String vehicleType; // Two or Four wheeler
	private String vehicleModel; // Mahindra Van, Pulsar
	private String vehicleRegNo;
	private String vehicleEngineNo;
	private String status;

	public int getProviderVehicleDetailsID() {
		return providerVehicleDetailsID;
	}

	public void setProviderVehicleDetailsID(int providerVehicleDetailsID) {
		this.providerVehicleDetailsID = providerVehicleDetailsID;
	}

	public ProviderDetails getProviderDetails() {
		return providerDetails;
	}

	public void setProviderDetails(ProviderDetails providerDetails) {
		this.providerDetails = providerDetails;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

	public String getVehicleEngineNo() {
		return vehicleEngineNo;
	}

	public void setVehicleEngineNo(String vehicleEngineNo) {
		this.vehicleEngineNo = vehicleEngineNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * */

}
