package com.in2it.client.product;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.in2it.core.entity.Product;

@FeignClient(name = "product", url = "http://localhost:9999", path = "products")
public interface ProductClient {
	
	@PostMapping
	public Product addProduct(@RequestBody Product product);

	@GetMapping
	public List<Product> getAllProducts();
		
	@GetMapping("/customer/{id}")
	public List<Product> getProductsByCustomerId(@PathVariable int id);
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id);
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product);

	@DeleteMapping("/id")
	public Product deleteProduct(@PathVariable int id);
	
	@PatchMapping
	public Product updateProductWithPatch(@RequestBody Product product);
	
//	@GetMapping("/customer/{id}")
//	public ResponseEntity<List<Product>> getProductsByCustomerId(@PathVariable int id);
//	
}
