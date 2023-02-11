package com.microservice.service;

import java.util.List;

import com.microservice.entity.UserDetails;

public interface UserDetailsService {

//	Get All Methods
	List<UserDetails> getAll();
	
//	Get By Id Methods
	UserDetails getById(int id);
	
//	Create UserDetails Methods
	UserDetails createUser(UserDetails user);
	
//	Update UserDetails Methods
	UserDetails updateUser(int id,UserDetails user);
	
//	delete UserDetails Methods
	void deleteById(int id);
	
}







