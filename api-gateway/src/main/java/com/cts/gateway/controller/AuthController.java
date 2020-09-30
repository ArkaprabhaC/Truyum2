package com.cts.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
<<<<<<< HEAD
=======

>>>>>>> 6478e879f79610720ea29eea7c3f4ecfcbd64824
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gateway.model.ResponseMessage;
import com.cts.gateway.model.Role;
import com.cts.gateway.model.User;
import com.cts.gateway.service.UserService;

import lombok.AllArgsConstructor;

/**
 * Auth Controller
 * @author Arkaprabha
 *
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

	/**
	 * 
	 */
	@Autowired
	private UserService service;
	
	
	
	/**
	 * Add user to auth system
	 * Only to be used for syncing DB
	 * @param user
	 */
	@PostMapping("/add/customer")
	public ResponseEntity<ResponseMessage> addUser_Customer(@RequestBody final User user) {
		
		user.setRole(Role.ROLE_CUSTOMER);
		return new ResponseEntity<ResponseMessage>(service.addUser(user), HttpStatus.OK);
	}
	
	/**
	 * Add user to auth system
	 * Only to be used for syncing DB
	 * @param user
	 */
	@PostMapping("/add/admin")
	public ResponseEntity<ResponseMessage> addUser_Admin(@RequestBody final User user) {
		user.setRole(Role.ROLE_ADMIN);
		return new ResponseEntity<ResponseMessage>(service.addUser(user), HttpStatus.OK);
	}
	
	/**
	 * Delete user to auth system
	 * Only to be used for syncing DB
	 * @param user
	 */
	@DeleteMapping("/delete/{username}")
	public ResponseEntity<ResponseMessage> deleteUser(@RequestBody final String username) {
		return new ResponseEntity<ResponseMessage>(service.deleteUser(username), HttpStatus.OK);
	}
	
	/**
	 * Updates user in the auth system
	 * Only to be used for syncing DB
	 * @param user
	 */
	@PutMapping("/update")
	public ResponseEntity<ResponseMessage> updateUser(@RequestBody final User user) {
		return new ResponseEntity<ResponseMessage>(service.updateUser(user), HttpStatus.OK);
	}
	
	
}
