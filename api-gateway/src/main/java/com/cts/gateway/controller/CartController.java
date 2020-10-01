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
import com.cts.gateway.service.UserService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
	
	@Autowired
	CartProxy cartProxy;

	@Autowired
	private UserService service;
	


	@GetMapping("/viewcart")
	public List<Cart> getItems() {
		long uid = service.getAuthUserID();
		return cartProxy.getItems(uid);		
		
	}
	
	@PostMapping("/add/{pid}")
	public ResponseEntity<ResponseMessage> addItem(@PathVariable int pid) {
		long uid = service.getAuthUserID();
		return cartProxy.addItem(uid, pid);
	}
	
	@DeleteMapping("/deleteitem/{pid}")
	public ResponseEntity<ResponseMessage> deleteItem(@PathVariable int pid) {
		long uid = service.getAuthUserID();
		return cartProxy.deleteItem(uid, pid);
	}

}
