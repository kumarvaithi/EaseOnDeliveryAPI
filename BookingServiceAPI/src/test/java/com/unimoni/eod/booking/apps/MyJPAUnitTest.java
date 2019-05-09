package com.unimoni.eod.booking.apps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.unimoni.eod.booking.model.BookingTxn;
import com.unimoni.eod.booking.repo.BookingTxnRepository;


public class MyJPAUnitTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BookingTxnRepository bookingTxnRepository;
	
	
	
	@Test
	public void should_delete_all_booking() {
		entityManager.persist(new BookingTxn());
	}
	
}
