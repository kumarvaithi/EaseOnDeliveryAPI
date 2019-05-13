package com.unimoni.eod.booking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.booking.model.DeliveryCharges;

public interface DeliveryChargesRepository extends CrudRepository<DeliveryCharges, Long> {

	//@Query(value="select * from deliverycharges d where d.to_distance > ?1 limit 1 ", nativeQuery = true)
	Optional<DeliveryCharges> findByToDistance(int toDistance);
	
}
