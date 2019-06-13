package com.unimoni.eod.provider.repo;

import org.springframework.data.repository.CrudRepository;

import com.unimoni.eod.provider.model.ProviderDetails;

public interface ProviderDetailsRepository extends CrudRepository<ProviderDetails, Long> {
	
	ProviderDetails findByProviderID(int providerID);
	
}
