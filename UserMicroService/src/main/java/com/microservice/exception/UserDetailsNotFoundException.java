package com.microservice.exception;

public class UserDetailsNotFoundException extends RuntimeException{
	
	public UserDetailsNotFoundException() {
		super("UserDetails Not Found Exception");
	}
	
	public UserDetailsNotFoundException(String message) {
		super(message);
	}

}
