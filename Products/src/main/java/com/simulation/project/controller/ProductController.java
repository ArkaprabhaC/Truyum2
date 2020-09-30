package com.simulation.project.controller;


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

import com.simulation.project.DAO.ProductDAO;
import com.simulation.project.exception.ResponseMessage;
import com.simulation.project.model.Product;

import com.simulation.project.services.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	ProductDAO dao;
	
	
	
	@PostMapping(value="/add" )
	public ResponseEntity<ResponseMessage> createProduct(@RequestBody Product product)
	{
		log.debug("inside createProduct() method");
		return ResponseEntity.ok(productService.addProduct(product)); //make chnages in CART ms
	}
	

	@GetMapping("/{id}")
	public Product getProductByID(@PathVariable("id") int id)
	{
		log.debug("inside addToCart() method");
		return productService.getProduct(id);
		
	}
	
	@GetMapping(value="/all" )
	public List<Product> getAllProducts()
	{
		log.debug("inside createProduct() method");
		return productService.getProducts();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteProduct(  @PathVariable("id") int id) {
		log.debug("inside deleteProduct() method");
		log.info((Integer.valueOf(id)).toString());
		return ResponseEntity.ok(productService.removeProduct(id));
	
	}

	

}
