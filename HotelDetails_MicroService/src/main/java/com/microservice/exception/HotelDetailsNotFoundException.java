package com.microservice.exception;


public class HotelDetailsNotFoundException extends RuntimeException {

	public HotelDetailsNotFoundException() {
		super("Hotel Details Not Found Exception");
	}
	
	public HotelDetailsNotFoundException(String message) {
		super(message);
	}
	
}
