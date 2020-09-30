package com.cts.gateway.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.gateway.model.ResponseMessage;
import com.cts.gateway.model.User;

@FeignClient(name="USERDBSERVICE", url="${USERDBSERVICE:http://localhost:9000}")
public interface UserDBProxy {
	
	@GetMapping("/userdbservice/{username}")
	Optional<User> findByUsername(@PathVariable final String username);

	@PostMapping("/userdbservice")
	ResponseMessage addUser(@RequestBody final User user);
	
	@PutMapping("/userdbservice")
	ResponseMessage updateUser(@RequestBody final User user);
	
	@DeleteMapping("/userdbservice/{username}")
	ResponseMessage deleteUser(@PathVariable final String username);
}
