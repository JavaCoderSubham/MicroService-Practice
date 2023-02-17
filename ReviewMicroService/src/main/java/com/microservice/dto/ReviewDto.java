package com.microservice.dto;

import java.util.List;

import com.microservice.entity.ReviewDetails;

public interface ReviewDto {

	List<ReviewDetails> getAll();
	
	ReviewDetails getByIdReview(int id);
	
	ReviewDetails createData(ReviewDetails review);
	
	ReviewDetails updateData(ReviewDetails review);
	
	String deleteByIdReview(int id);
	
	String deleteAll();
	
}
