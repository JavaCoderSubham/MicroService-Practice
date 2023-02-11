package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	
	

}
