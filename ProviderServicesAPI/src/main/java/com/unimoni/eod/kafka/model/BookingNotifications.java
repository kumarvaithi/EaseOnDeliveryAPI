package com.unimoni.eod.kafka.model;

public class BookingNotifications {

    private String bookingID;


    

	public String getBookingID() {
		return bookingID;
	}

	public BookingNotifications setBookingID(String bookingID) {
		this.bookingID = bookingID;
		return this;
	}

	public BookingNotifications() {
    }

    public BookingNotifications(String bookingID) {

        this.bookingID = bookingID;
    }

	@Override
	public String toString() {
		return "BookingNotifications [bookingID=" + bookingID + "]";
	}
}
