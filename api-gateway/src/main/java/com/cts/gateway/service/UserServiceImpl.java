package com.cts.gateway.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.gateway.feign.UserDBproxy;
import com.cts.gateway.model.ResponseMessage;
import com.cts.gateway.model.User;

import lombok.AllArgsConstructor;

/**
 * User Service Implementation
 * @author Arkaprabha
 *
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDBproxy proxy;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ResponseMessage addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return proxy.addUser(user);
	}

	@Override
	public ResponseMessage deleteUser(String username) {
		return proxy.deleteUser(username);
	}

	@Override
	public ResponseMessage updateUser(User user) {
		return proxy.updateUser(user);
	}

	
	
}
