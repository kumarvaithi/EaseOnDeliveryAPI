package com.unimoni.eod.booking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.OTPDetails;


public interface OTPDetailsRepositary extends CrudRepository<OTPDetails, Integer> {
	Optional<OTPDetails> findByOtpAndStatus(int otp,String status);
	OTPDetails findByBookingIDAndOtpAndUserType(int bookingID,int otp,String userType);
	void save(Optional<OTPDetails> otpDetails);
}