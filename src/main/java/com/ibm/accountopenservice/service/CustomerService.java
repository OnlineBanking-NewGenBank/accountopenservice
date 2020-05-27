package com.ibm.accountopenservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.accountopenservice.model.Customer;
import com.ibm.accountopenservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer findCustomer(String customerId) {
		return customerRepository.findCustomerBycustomerId(customerId);
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteCustomer(String customerId) {
		customerRepository.deleteCustomerBycustomerId(customerId);
	}

}
