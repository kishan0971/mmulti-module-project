package com.in2it.service.product;

import java.util.List;

import com.in2it.core.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(int id);
	List<Product> getProductsByCustomerId(int id);
	Product updateProduct(int id, Product product);
	Product updateProductWithPatch(Product product);
	Product deleteProduct(int id);
	

}
