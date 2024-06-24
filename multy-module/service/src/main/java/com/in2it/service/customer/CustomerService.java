package com.in2it.service.customer;

import java.util.List;

import com.in2it.core.entity.Customer;

public interface CustomerService {

	Customer registerCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(int id);
	Customer updateCustomer(int id, Customer customer);
	Customer deleteCustomer(int id);
}
