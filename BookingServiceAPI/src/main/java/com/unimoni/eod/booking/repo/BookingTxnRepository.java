package com.unimoni.eod.booking.repo;

import org.springframework.data.repository.CrudRepository;
import com.unimoni.eod.booking.model.BookingTxn;

public interface BookingTxnRepository extends CrudRepository<BookingTxn, Long> {
	

}
