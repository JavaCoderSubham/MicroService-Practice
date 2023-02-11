package com.microservice.service;

import java.util.List;

import com.microservice.entity.HotelDetails;

public interface HotelDetailsService {
	
//	Get All Method
	List<HotelDetails> getAll();
	
//	Get By Id Method
	HotelDetails getById(int id);
	
//	Create Method
	HotelDetails createHotel(HotelDetails hotelDetails);
	
//	Delete By Id Method
	String deleteById(int id);
	
}










