package com.cts.project101.userdbservice.exception;

public class UsernameExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2730851164183909495L;

	public UsernameExistException(String error) {
		
		super(error);
	}

}
