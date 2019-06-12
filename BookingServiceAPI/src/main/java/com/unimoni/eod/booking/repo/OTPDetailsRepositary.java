package com.unimoni.eod.booking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.OTPDetails;


public interface OTPDetailsRepositary extends CrudRepository<OTPDetails, Long> {
	List<OTPDetails> findByOTPAndStatus(int otp,String status);
	List<OTPDetails> findByBookingIDAndOTPAndUserType(int bookingID,int otp,String userType);
}