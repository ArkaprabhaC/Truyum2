package com.cts.project101.userdbservice.exception;

public class UsernameNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4262852451399928914L;

	public UsernameNotFoundException(String error) {
		
		super(error);
	}

}
