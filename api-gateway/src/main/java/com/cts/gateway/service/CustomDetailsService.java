package com.cts.gateway.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.gateway.feign.UserDBProxy;
import com.cts.gateway.model.AuthUserDetails;
import com.cts.gateway.model.User;

import lombok.AllArgsConstructor;

/**
 * Custom User Details Service
 * @author Arkaprabha
 *
 */
@Service
@AllArgsConstructor
public class CustomDetailsService implements UserDetailsService{

	@Autowired
	private UserDBProxy proxy;
	
	/**
	 * loads AuthUser from Database
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Optional<User> user = proxy.findByUsername(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		return new AuthUserDetails(user.get());
	}

}
