package com.unimoni.eod.booking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.BookingTxnStatus;

public interface BookingTxnRepository extends CrudRepository<BookingTxn, Long> {
	
	BookingTxn findByBookingID(int bookingID);

	BookingTxn save(BookingTxn bookingTxn);
	
}
