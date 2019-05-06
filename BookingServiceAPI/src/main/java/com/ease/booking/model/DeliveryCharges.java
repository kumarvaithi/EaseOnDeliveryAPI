package com.ease.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deliverycharges")
public class DeliveryCharges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deliveryChargesID")
	private Long deliveryChargesID;
	
	@Column(name = "fromDistance")
	private int fromDistance;
	
	@Column(name = "toDistance")
	private int toDistance;
	
	@Column(name = "vehicleType")
	private String vehicleType;
	
	@Column(name = "vehicleModel")
	private String vehicleModel;
	
	@Column(name = "minWeight")
	private Double minWeight;
	
	@Column(name = "maxWeight")
	private Double maxWeight;
	
	@Column(name = "commission")
	private Double commission;
	
	@Column(name = "deliveryCharge")
	private Double deliveryCharge;
	
	

	public Long getDeliveryChargesID() {
		return deliveryChargesID;
	}

	public DeliveryCharges setDeliveryChargesID(Long deliveryChargesID) {
		this.deliveryChargesID = deliveryChargesID;
		return this;
	}

	public int getFromDistance() {
		return fromDistance;
	}

	public DeliveryCharges setFromDistance(int fromDistance) {
		this.fromDistance = fromDistance;
		return this;
	}

	public int getToDistance() {
		return toDistance;
	}

	public DeliveryCharges setToDistance(int toDistance) {
		this.toDistance = toDistance;
		return this;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public DeliveryCharges setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public DeliveryCharges setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
		return this;
	}

	public Double getMinWeight() {
		return minWeight;
	}

	public DeliveryCharges setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
		return this;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public DeliveryCharges setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
		return this;
	}

	public Double getCommission() {
		return commission;
	}

	public DeliveryCharges setCommission(Double commission) {
		this.commission = commission;
		return this;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public DeliveryCharges setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
		return this;
	}
	
	

}
