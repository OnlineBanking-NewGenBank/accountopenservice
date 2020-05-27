package com.ibm.accountopenservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.accountopenservice.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findCustomerBycustomerId(String customerId);
	
	public void deleteCustomerBycustomerId(String customerId);
}
