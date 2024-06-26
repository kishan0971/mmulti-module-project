package com.in2it.web.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.in2it.client.product.ProductClient;
import com.in2it.core.entity.Customer;
import com.in2it.service.customer.CustomerService;



@RestController
@RequestMapping("/customers")
public class CustomerController {
	

	
	@Autowired
	CustomerService service;

	@PostMapping
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
//		ResponseEntity.status(HttpStatus.CREATED).body(null);
//		return service.registerCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registerCustomer(customer));
		
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		
//		return service.getAllCustomers();
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		
//		return service.getCustomerById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getCustomerById(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customer) {
//		return service.updateCustomer(id, customer);
		return ResponseEntity.ok(service.updateCustomer(id, customer));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
//		return service.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.deleteCustomer(id));
	}

}
