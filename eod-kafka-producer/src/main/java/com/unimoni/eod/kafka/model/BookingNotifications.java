package com.unimoni.eod.kafka.model;

public class BookingNotifications {

    private String bookingID;
    
    public BookingNotifications(String bookingID) {
        this.bookingID = bookingID;
    }

	public String getBookingID() {
		return bookingID;
	}

	public BookingNotifications setBookingID(String bookingID) {
		this.bookingID = bookingID;
		return this;
	}


}
