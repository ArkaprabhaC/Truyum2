package com.cts.gateway.service;

import com.cts.gateway.model.ResponseMessage;
import com.cts.gateway.model.User;

/**
 * 
 * @author Arkaprabha
 *
 */
public interface UserService {

	/**
	 * Adds user to DB
	 * @param user
	 */
	ResponseMessage addUser(User user);
	
	/**
	 * Deletes user from DB
	 * @param user
	 */
	ResponseMessage deleteUser(final String username);

	/**
	 * Updates user in DB
	 * @param user
	 */
	ResponseMessage updateUser(final User user);
	
	public long getAuthUserID();
	
}
