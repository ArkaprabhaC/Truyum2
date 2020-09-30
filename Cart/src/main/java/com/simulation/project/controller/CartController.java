package com.simulation.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simulation.project.clients.ProductClient;
import com.simulation.project.exception.ResponseMessage;
import com.simulation.project.model.Cart;
import com.simulation.project.services.CartService;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@Autowired
	ProductClient client;
	
	@GetMapping("/viewcart/{userId}")
	public List<Cart> getItems(@PathVariable int userId)
	{	
		log.debug("inside getItems() method");
		return cartService.getItems(userId);
	}
	
	@PostMapping("/add/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> addItem(@PathVariable int userId,@PathVariable int pid)
	{
			log.debug("inside deleteItem() method");
			return ResponseEntity.ok(cartService.addItem(userId,pid));
	}
	
	
	@DeleteMapping("/deleteitem/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> deleteItem(@PathVariable int userId,@PathVariable int pid)
	{
			log.debug("inside deleteItem() method");
			return ResponseEntity.ok(cartService.removeItem(userId,pid));
	}
	
	
	
	
	
}
