package com.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.HotelDetails;

public interface HotelDetailsRepository extends JpaRepository<HotelDetails, Integer>{

	List<HotelDetails> findByUserId(int id);
	
}
