package com.cts.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gateway.feign.ProductProxy;
import com.cts.gateway.model.Product;
import com.cts.gateway.model.ResponseMessage;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	ProductProxy productProxy;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseMessage> addProduct(@RequestBody Product product) {
		
		return productProxy.createProduct(product);
	}
	
	@GetMapping("/{id}")
	public Product getProductByID(@PathVariable("id") int id) {
		
		return productProxy.getProductByID(id);
	}
	
	@GetMapping(value="/all" )
	public List<Product> getAllProducts() {
		
		return productProxy.getAllProducts();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteProduct(  @PathVariable("id") int id) {
		
		return productProxy.deleteProduct(id);	
	}
	
}
