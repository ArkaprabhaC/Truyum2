package com.cts.gateway.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.gateway.feign.UserDBProxy;
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
	private UserDBProxy proxy;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public long getAuthUserID() {
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}else {
			username = principal.toString();
		}
		
		Optional<User> user = proxy.findByUsername(username);
		return user.get().getUserId();
	}
	
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
