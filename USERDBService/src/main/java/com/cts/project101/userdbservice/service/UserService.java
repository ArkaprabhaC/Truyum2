package com.cts.project101.userdbservice.service;

import com.cts.project101.userdbservice.model.ResponseMessage;
import com.cts.project101.userdbservice.model.User;


public interface UserService {
	
	ResponseMessage registerUser(User user);
	
	User getUserByUsername(String username);
	
	User getUserByEmailId(String emailId);
	
	ResponseMessage updateUser(User user);
	
	ResponseMessage deleteUserByUsername(String username);
	
	ResponseMessage deleteUserByEmailId(String emailId);

}
