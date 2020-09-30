package com.simulation.project.exception;

public class CartEmptyException  extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public CartEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartEmptyException(String message) {
		super(message);
	}

	public CartEmptyException(Throwable cause) {
		super(cause);
	}
	
	

}
