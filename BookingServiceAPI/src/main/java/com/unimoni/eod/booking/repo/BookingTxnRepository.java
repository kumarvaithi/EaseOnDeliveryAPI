package com.unimoni.eod.booking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unimoni.eod.booking.model.BookingTxn;

public interface BookingTxnRepository extends CrudRepository<BookingTxn, Long> {
	
	Optional<BookingTxn> findByBookingID(Long bookingID);
	
}
