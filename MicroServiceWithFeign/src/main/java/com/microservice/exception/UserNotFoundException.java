package com.microservice.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User Not Found Exception.");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
}
