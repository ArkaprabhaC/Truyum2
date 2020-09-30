package com.cts.gateway.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.gateway.model.Cart;
import com.cts.gateway.model.ResponseMessage;

@FeignClient(name="CARTSERVICE", url="${CARTSERVICE:http://localhost:8080}")
@RequestMapping(value = "/cart")
public interface CartProxy {
	
	@GetMapping(value = "/viewcart/{userId}")
	public List<Cart> getItems(@PathVariable int userId);
	
	@PostMapping(value = "/add/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> addItem(@PathVariable int userId,@PathVariable int pid);
	
	@DeleteMapping(value = "/deleteitem/{userId}/{pid}")
	public ResponseEntity<ResponseMessage> deleteItem(@PathVariable int userId,@PathVariable int pid);

}
