package com.ease.booking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ease.booking.model.BookingTxn;

public interface BookingRepositary extends CrudRepository<BookingTxn, Long> {

}
