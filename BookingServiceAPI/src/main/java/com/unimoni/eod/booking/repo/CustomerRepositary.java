package com.unimoni.eod.booking.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.model.Customer;


public interface CustomerRepositary extends CrudRepository<Customer, Long> {

	Customer findByCustomerID(int customerID);
}
