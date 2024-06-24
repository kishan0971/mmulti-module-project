package com.in2it.web.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in2it.core.entity.Product;
import com.in2it.service.product.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		
		Product rspProduct = service.addProduct(product);
		return ResponseEntity.ok(rspProduct);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		
		return service.getAllProducts();
	}
	
	
	@GetMapping("/customer/{id}")
	public List<Product> getProductsByCustomerId(@PathVariable int id) {
		
		return service.getProductsByCustomerId(id);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		
		return service.getProductById(id);
	}


	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PatchMapping
	public Product updateProductWithPatch(@RequestBody Product product) {
		return service.updateProductWithPatch(product);
	}

}
