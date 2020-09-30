package com.cts.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gateway.feign.CartProxy;
import com.cts.gateway.model.Cart;
import com.cts.gateway.model.ResponseMessage;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartProxy cartProxy;
	
	@GetMapping("/viewcart/{userId}")
	public List<Cart> getItems(@PathVariable int userId) {
		
		return cartProxy.getItems(userId);		
		
	}
	
	@PostMapping("/add/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> addItem(@PathVariable int userId,@PathVariable int pid) {
		
		return cartProxy.addItem(userId, pid);
	}
	
	@DeleteMapping("/deleteitem/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> deleteItem(@PathVariable int userId,@PathVariable int pid) {
		
		return cartProxy.deleteItem(userId, pid);
	}

}
