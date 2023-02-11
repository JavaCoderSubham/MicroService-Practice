package com.microservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.HotelDetails;
import com.microservice.repository.HotelDetailsRepository;


@Service
public class HotelDetailsServiceImpl implements HotelDetailsService{
	
	@Autowired
	private HotelDetailsRepository repository;
	
	private final Logger logger = LoggerFactory.getLogger(HotelDetailsServiceImpl.class); 

	@Override
	public List<HotelDetails> getAll() {
		
		List<HotelDetails> list = repository.findAll();
		
		return null;
	}

	@Override
	public HotelDetails getById(int id) {
		return null;
	}

	@Override
	public HotelDetails createHotel(HotelDetails hotelDetails) {
		return null;
	}

	@Override
	public String deleteById(int id) {
		return null;
	}
	
	private boolean isPresentInDb(int id) {
		
		Optional<HotelDetails> get = repository.findById(id);
		
		return get.isPresent();
	}

}









