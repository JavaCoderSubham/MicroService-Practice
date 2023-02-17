package com.microservice.exception;

public class EmployeeNotFoundException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {
		super("Employee Not Found Exception");
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
