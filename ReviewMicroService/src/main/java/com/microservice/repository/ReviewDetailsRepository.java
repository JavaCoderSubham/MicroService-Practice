package com.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.ReviewDetails;

public interface ReviewDetailsRepository extends JpaRepository<ReviewDetails, Integer>{

	
	
}
