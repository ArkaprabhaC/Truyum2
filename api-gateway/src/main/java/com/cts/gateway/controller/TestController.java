package com.cts.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/product/all")
	public String getProducts() {
		return "Getting all products .... [ADMIN only] ";
	}
	
	@GetMapping("/cart/all")
	public String getcart() {
		return "Getting all cart items .... [USER only] ";
	}
}
