package com.ibm.accountopenservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.accountopenservice.model.Customer;
import com.ibm.accountopenservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}

	@GetMapping("/find/{customerId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable String customerId) {
		Customer customer = new Customer();
		customer = customerService.findCustomer(customerId);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer cust = new Customer();
		cust = customerService.findCustomer(customer.getCustomerId());
		if (cust == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		} else {
			customerService.updateCustomer(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String customerId) {
		Customer customer = new Customer();
		customer = customerService.findCustomer(customerId);
		if (customer == null) {
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		} else {
			customerService.deleteCustomer(customer.getCustomerId());
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}

	}

}
