package com.microservice.service;

import java.util.List;

import com.microservice.entity.ReviewDetails;

public interface ReviewDetailsService {
	
	List<ReviewDetails> getAll();
	
	ReviewDetails getById(int id);
	
	ReviewDetails createData(ReviewDetails review);
	
	ReviewDetails updateData(int id, ReviewDetails review);
	
	String deleteById(int id);
	
	String deleteAll();

}
