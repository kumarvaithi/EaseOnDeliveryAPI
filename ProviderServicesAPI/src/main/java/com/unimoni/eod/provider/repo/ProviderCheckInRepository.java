package com.unimoni.eod.provider.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.provider.model.ProviderCheckIn;


public interface ProviderCheckInRepository extends CrudRepository<ProviderCheckIn, Long> {
	
	List<ProviderCheckIn> findByStatus(String status);

}
