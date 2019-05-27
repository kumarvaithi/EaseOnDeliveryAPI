package com.unimoni.eod.provider.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.provider.model.ProviderBookingMapping;


public interface ProviderBookingMapRepository extends CrudRepository<ProviderBookingMapping, Long> {

	List<ProviderBookingMapping> findByProviderIDAndStatus(int providerID,String status);
}
