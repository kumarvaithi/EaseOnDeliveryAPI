package com.ease.customer.model;

import java.util.Date;

public class DeliveryChargesRequestBean {

	private int tentativeWeight;
	private int distance;
	private String vehicleType;
	private Date deliveryDateTime;
	
	public int getTentativeWeight() {
		return tentativeWeight;
	}
	public DeliveryChargesRequestBean setTentativeWeight(int tentativeWeight) {
		this.tentativeWeight = tentativeWeight;
		return this;
	}
	public int getDistance() {
		return distance;
	}
	public DeliveryChargesRequestBean setDistance(int distance) {
		this.distance = distance;
		return this;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public DeliveryChargesRequestBean setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public DeliveryChargesRequestBean setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
		return this;
	}
}