package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.dto.ReviewDto;
import com.microservice.entity.ReviewDetails;

public class ReviewDetailsServiceImpl implements ReviewDetailsService{

	@Autowired
	private ReviewDto dto;
	
	@Override
	public List<ReviewDetails> getAll() {
		return dto.getAll();
	}

	@Override
	public ReviewDetails getById(int id) {
		return dto.getByIdReview(id);
	}

	@Override
	public ReviewDetails createData(ReviewDetails review) {
		return dto.createData(review);
	}

	@Override
	public ReviewDetails updateData(int id, ReviewDetails review) {
		
		ReviewDetails reviewDetails = getById(id);
		
		reviewDetails.setRating(review.getRating());
		reviewDetails.setFeedback(review.getFeedback());
		
		return dto.updateData(reviewDetails);
	}

	@Override
	public String deleteById(int id) {
		return dto.deleteByIdReview(id);
	}

	@Override
	public String deleteAll() {
		return dto.deleteAll();
	}

}
