package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	Get All
	
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
	
//	Get By Id
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelDetails> getByIdHotelDetails(@PathVariable int id) {
		logger.info("========== Start Get By ID ==========");				
		logger.info("getByIdHotelDetails() -> | id : {}",id);
		HotelDetails hotelDetails = service.getById(id);
		logger.info("getByIdHotelDetails() -> | User : {}",hotelDetails);
		logger.info("========== End Get By ID ==========");	
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(hotelDetails);
	}
	
//	Create Hotel
	
	@PostMapping
	public ResponseEntity<HotelDetails> createHotelDetails(@RequestBody HotelDetails hotel) {
		logger.info("========== Start Create Hotel Details ==========");		
		logger.info("createHotelDetails() -> | Hotel Details : {}",hotel);
		HotelDetails hotelDetails = service.createHotel(hotel);		
		logger.info("createHotelDetails() -> | Hotel Details : {}",hotelDetails);
		logger.info("========== End Create Hotel Details ==========");		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(hotelDetails);
	}
	
//	Update Hotel
	
	@PutMapping("/{id}")
	public ResponseEntity<HotelDetails> updateHotelDetails(@PathVariable int id, @RequestBody HotelDetails hotel) {
		logger.info("========== Start Update Hotel Details ==========");
		logger.info("updateHotelDetails() -> | id : {} | HotelDetails : {}",id,hotel);
		HotelDetails hotelDetails = service.updateHotel(id, hotel);
		logger.info("updateHotelDetails() -> | id : {} | HotelDetails : {}",id,hotelDetails);
		logger.info("========== End Update Hotel Details ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(hotelDetails);
	}
	
//	Delete 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteByIdHotelDetails(@PathVariable int id) {
		logger.info("========== Start Delete By ID ==========");
		logger.info("deleteByIdHotelDetails() -> | id : {}",id);
		String str = service.deleteById(id);
		logger.info("deleteByIdHotelDetails() -> | Deleted. id : {}",id);
		logger.info("========== End Delete By ID ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(str);
	}
	
//	Find By UserId
	
	@GetMapping("/userid/{userId}")
	public ResponseEntity<List<HotelDetails>> getByUserId(@PathVariable int userId) {
		logger.info("========== Start Get By UserID ==========");
		logger.info("getByUserId() -> | UserId : {}",userId);
		List<HotelDetails> hotel = service.findByUserId(userId);
		logger.info("getByUserId() -> HotelDetails : {}",hotel);
		logger.info("========== End Get By UserID ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(hotel);
	}
	
}











