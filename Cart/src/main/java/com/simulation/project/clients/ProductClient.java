package com.simulation.project.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simulation.project.model.Cart;

@FeignClient(name="PRODUCTS", url="${PRODUCTS:http://localhost:8081}")
public interface ProductClient {
	@GetMapping("/products/getproduct")
	public Optional<Cart> addToCart();
	
	@GetMapping("/products/{pid}")
	Cart getProductByID(@PathVariable int pid);
}
