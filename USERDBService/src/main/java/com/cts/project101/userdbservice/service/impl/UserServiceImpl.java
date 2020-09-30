package com.cts.project101.userdbservice.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.project101.userdbservice.exception.EmailIDExistException;
import com.cts.project101.userdbservice.exception.EmailIDNotFoundException;
import com.cts.project101.userdbservice.exception.UsernameExistException;
import com.cts.project101.userdbservice.exception.UsernameNotFoundException;
import com.cts.project101.userdbservice.model.ResponseMessage;
import com.cts.project101.userdbservice.model.User;
import com.cts.project101.userdbservice.repository.UserRepository;
import com.cts.project101.userdbservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseMessage registerUser(User user) {
		
		if(userRepository.findByUsername(user.getUsername()).isPresent())
			throw new UsernameExistException("Username: "+user.getUsername()+" already exist.");
		
		else if(userRepository.findByEmailId(user.getEmailId()).isPresent())
			throw new EmailIDExistException("Email ID: "+user.getEmailId()+" already exist.");
		
		else
			userRepository.save(user);
		
		return new ResponseMessage(LocalDateTime.now(),HttpStatus.CREATED,"New User has been created.");
	}

	@Override
	public User getUserByUsername(String username) {
		
		User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username: "+username+" doesnt exist."));
		return user;
	}

	@Override
	public User getUserByEmailId(String emailId) {
		
		User user = userRepository.findByUsername(emailId).orElseThrow(()->new EmailIDNotFoundException("Email ID: "+emailId+" doesnt exist."));
		return user;
		
	}

	@Override
	public ResponseMessage updateUser(User user) {
		
		User oldUser = userRepository.findByUsername(user.getUsername()).orElseThrow(()->new UsernameNotFoundException("Username: "+user.getUsername()+" doesnt exist."));
		
		if(user.getEmailId()!=null)
			oldUser.setEmailId(user.getEmailId());
		
		if(user.getFirstName()!=null)
			oldUser.setFirstName(user.getFirstName());
		
		if(user.getLastName()!=null)
			oldUser.setLastName(user.getLastName());
		
		if(user.getPassword()!=null)
			oldUser.setPassword(user.getPassword());
		
		if(user.getRole()!=null)
			oldUser.setRole(user.getRole());
		
		if(user.getUsername()!=null)		
			oldUser.setUsername(user.getUsername());
			
		userRepository.save(oldUser);
		
		return new ResponseMessage(LocalDateTime.now(),HttpStatus.OK,"User has been updated.");
	}

	@Transactional
	@Override	
	public ResponseMessage deleteUserByUsername(String username) {
		
		userRepository.findByUsername(username)
			.orElseThrow(()->new UsernameNotFoundException("Username: "+username+" doesnt exist."));
		
		userRepository.deleteByUsername(username);
		
		return new ResponseMessage(LocalDateTime.now(),HttpStatus.NO_CONTENT,"User has been deleted.");
		
	}

	@Transactional
	@Override
	public ResponseMessage deleteUserByEmailId(String emailId) {

		userRepository.deleteByUsername(emailId);
		
		return new ResponseMessage(LocalDateTime.now(),HttpStatus.NO_CONTENT,"User has been deleted.");
	}
	

}
