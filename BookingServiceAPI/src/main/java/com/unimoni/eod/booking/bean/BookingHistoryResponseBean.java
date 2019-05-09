package com.unimoni.eod.booking.bean;

import java.util.Date;
import java.util.List;

public class BookingHistoryResponseBean {
	
	private List<BookingHistoryBean> historyList;

	public List<BookingHistoryBean> getHistoryList() {
		return historyList;
	}

	public BookingHistoryResponseBean setHistoryList(List<BookingHistoryBean> historyList) {
		this.historyList = historyList;
		return this;
	} 
}
