insert into customer
	(customerid
	,address
	,alternative_mobile_no
	,created_at
	,emailid
	,mobile_no
	,modified_at
	,name)
values
	(1
	,'Test'
	,'+919176680857'
	,NOW()
	,'thamme@gmail.com'
	,'912312321'
	,NOW()
	,'thameem'
	);
	

INSERT INTO `provider_details` (`providerid`, `address`, `alternate_mobile_no`, `created_at`, `emailid`, `location`, `mobile_no`, `name`, `status`, `updated_at`) VALUES (1, 'Ashok Nagar', '123131313', '2019-06-11', 'test@gmail.com', 'Ashok Nagar', '223424234', 'Kumar', 'Active', '2019-06-11');

INSERT INTO `provider_vehicle_details` (`provider_vehicle_detailsid`, `status`, `vehicle_engine_no`, `vehicle_model`, `vehicle_reg_no`, `vehicle_type`, `providerid`) VALUES (1, 'Active', '68768G23SE23', 'Two Wheeler', 'TN-50-V-2342', 'Two Wheeler', 1);