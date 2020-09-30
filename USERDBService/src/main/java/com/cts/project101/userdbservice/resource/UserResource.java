package com.cts.project101.userdbservice.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project101.userdbservice.model.ResponseMessage;
import com.cts.project101.userdbservice.model.User;
import com.cts.project101.userdbservice.service.UserService;

@RestController
@RequestMapping("/userdbservice")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{username}")
	User getUserByUsername(@PathVariable("username") String username) {
		
		return userService.getUserByUsername(username);		
	}
	
	@PostMapping
	ResponseMessage register(@Valid @RequestBody User user) {
	
		return userService.registerUser(user);		
		
	}
	
	//User is using username to query the the database for updation.
	//Please populate username field in user.
	
	@PutMapping
	ResponseMessage updateUser(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{username}")
	ResponseMessage deleteUserByUsername(@PathVariable("username") String username) {
		
		return userService.deleteUserByUsername(username);
		
	}

}
