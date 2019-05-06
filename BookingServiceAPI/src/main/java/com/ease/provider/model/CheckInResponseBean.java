package com.ease.provider.model;

import java.util.List;

import com.ease.bean.CommonResponseBean;

public class CheckInResponseBean {

	private String currentLocation;
	private String checkinDateTime;
	private List<CommonResponseBean> resultData;
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public CheckInResponseBean setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		return this;
	}
	public String getCheckinDateTime() {
		return checkinDateTime;
	}
	public CheckInResponseBean setCheckinDateTime(String checkinDateTime) {
		this.checkinDateTime = checkinDateTime;
		return this;
	}
	public List<CommonResponseBean> getResultData() {
		return resultData;
	}
	public void setResultData(List<CommonResponseBean> resultData) {
		this.resultData = resultData;
	}
}
