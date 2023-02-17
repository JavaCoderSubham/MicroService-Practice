package com.microservice.exception;

public class ReviewNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException() {
		super("Review Not Found Exception");
	}
	
	public ReviewNotFoundException(String message) {
		super(message);
	}
	
}
