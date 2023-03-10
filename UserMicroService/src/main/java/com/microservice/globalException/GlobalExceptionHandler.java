package com.microservice.globalException;

import java.net.ConnectException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservice.exception.UserDetailsNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
//	User Not Found Exception
	
	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<String> UserNotFound(UserDetailsNotFoundException ex) {
		logger.error("UserDetailsNotFoundException Class | Exception Message : {} | Exception Cause : {}",ex.getMessage(),ex.getCause());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<String> microServiceConnection(ConnectException ex) {
		logger.error("Connect Exception Class | Exception Message : {} | Exception Cause : {}",ex.getMessage(),ex.getCause());
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
				.body("Connection Problem With Your MicroServices");
	}
	
	
}









