package com.in2it.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2it.core.entity.Product;
import com.in2it.repository.product.ProductRepository;
import com.in2it.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	
	@Override
	public Product addProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return repository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public List<Product> getProductsByCustomerId(int id) {
		
		return repository.findByCustomerId(id);
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product exstProduct = repository.findById(id).get();
		if(exstProduct!=null) {
			exstProduct.setColor(product.getColor());
			exstProduct.setName(product.getName());
			return repository.save(exstProduct);
		}
		return null;
	}

	@Override
	public Product deleteProduct(int id) {
		Product exstProduct = repository.findById(id).get();
		if(exstProduct!=null) {
			repository.delete(exstProduct);
			return exstProduct;
		}
		return null;
	}

	@Override
	public Product updateProductWithPatch(Product product) {
		Product exstProduct = repository.findById(product.getId()).get();
		if(exstProduct!=null) {
			exstProduct.setColor(product.getColor());
			exstProduct.setName(product.getName());
			return repository.save(exstProduct);
		}
		return null;
	}

	
	

}
