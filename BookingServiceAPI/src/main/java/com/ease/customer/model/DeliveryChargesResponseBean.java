package com.ease.customer.model;

import java.util.List;

import com.ease.bean.CommonResponseBean;

public class DeliveryChargesResponseBean {

	private double estimatedAount;
	private double estimatedTax;
	private double estimatedCommission;
	private double estimatedTotalAmount;
	private List<CommonResponseBean> resultData;
	
	public double getEstimatedAount() {
		return estimatedAount;
	}
	public DeliveryChargesResponseBean setEstimatedAount(double estimatedAount) {
		this.estimatedAount = estimatedAount;
		return this;
	}
	public double getEstimatedTax() {
		return estimatedTax;
	}
	public DeliveryChargesResponseBean setEstimatedTax(double estimatedTax) {
		this.estimatedTax = estimatedTax;
		return this;
	}
	public double getEstimatedCommission() {
		return estimatedCommission;
	}
	public DeliveryChargesResponseBean setEstimatedCommission(double estimatedCommission) {
		this.estimatedCommission = estimatedCommission;
		return this;
	}
	public double getEstimatedTotalAmount() {
		return estimatedTotalAmount;
	}
	public DeliveryChargesResponseBean setEstimatedTotalAmount(double estimatedTotalAmount) {
		this.estimatedTotalAmount = estimatedTotalAmount;
		return this;
	}
	public List<CommonResponseBean> getResultData() {
		return resultData;
	}
	public void setResultData(List<CommonResponseBean> resultData) {
		this.resultData = resultData;
	}
}