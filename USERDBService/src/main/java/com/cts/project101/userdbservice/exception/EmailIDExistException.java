package com.cts.project101.userdbservice.exception;

public class EmailIDExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6253042136338034264L;

	public EmailIDExistException(String error) {
		
		super(error);
	}

}
