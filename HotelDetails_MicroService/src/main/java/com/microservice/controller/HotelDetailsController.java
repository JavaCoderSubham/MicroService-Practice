package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.HotelDetails;
import com.microservice.service.HotelDetailsService;

@RestController
@RequestMapping("/hotel")
public class HotelDetailsController {

	@Autowired
	private HotelDetailsService service;
	
	private final Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);
	
	@GetMapping
	public ResponseEntity<List<HotelDetails>> getAll() {
		logger.info("========== Start Get All ==========");
		logger.info("getAll() -> | ");
		List<HotelDetails> list = service.getAll();
		logger.info("getAll() -> | Hotel List : {}",list);
		logger.info("========== End Get All ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelDetails> getByIdHotelDetails(@PathVariable int id) {
		logger.info("========== Start Get By ID ==========");		
		logger.info("getByIdHotelDetails() -> | id : {}",id);
		HotelDetails hotelDetails = service.getById(id);
		logger.info("getByIdHotelDetails() -> | User : {}",hotelDetails);
		logger.info("========== Start Get By ID ==========");	
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(hotelDetails);
	}
	
	
	
	
}











