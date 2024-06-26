package com.in2it.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.client.product.ProductClient;
import com.in2it.core.entity.Customer;
import com.in2it.core.entity.Product;
import com.in2it.exception.ResourceNotFoundException;
import com.in2it.repository.customer.CustomerRepository;
import com.in2it.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	ProductClient productClient;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = repository.findAll();
		for (Customer customer : customers) {
			System.out.println(productClient.getProductsByCustomerId(customer.getId()));
//			customer.setProducts(productClient.getProductsByCustomerId(customer.getId()).getBody());
			customer.setProducts(productClient.getProductsByCustomerId(customer.getId()));
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
//		List<Product> products = productClient.getProductsByCustomerId(id).getBody();
		List<Product> products = productClient.getProductsByCustomerId(id);
		Customer customer = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer dosen't exist with given id please give an valid id"));
		if(products.size()!=0) {
			customer.setProducts(products);
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(int id,Customer customer) {
		Customer exstCustomer = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer dosen't exist with given id please give an valid id"));
		
		if(exstCustomer!=null) {
			exstCustomer.setEmail(customer.getEmail());
			exstCustomer.setName(customer.getName());
			
			List<Product> products = customer.getProducts();
			if(products.size()!=0) {
				for (Product product : products) {
					Product exstProduct = productClient.getProductById(product.getId());
					if(exstProduct != null) {
						exstProduct.setColor(product.getColor());
						exstProduct.setName(product.getName());
//						productClient.updateProduct(product.getId(),product);
						productClient.updateProductWithPatch(exstProduct);
					}
				}
			}
			Customer savedCustomer = repository.save(exstCustomer);
			savedCustomer.setProducts(products);
			
			return savedCustomer;
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(int id) {
		Customer exstCustomer = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer dosen't exist with given id please give an valid id"));
		if(exstCustomer!=null) {
			repository.delete(exstCustomer);
			return exstCustomer;
		}
		return null;
	}

}
