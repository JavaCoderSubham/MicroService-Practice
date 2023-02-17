package com.microservice.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.entity.ReviewDetails;
import com.microservice.exception.ReviewNotFoundException;
import com.microservice.repository.ReviewDetailsRepository;

@Repository
public class ReviewDtoImpl implements ReviewDto {
	
	@Autowired
	private ReviewDetailsRepository repository;

	@Override
	public List<ReviewDetails> getAll() {
		return repository.findAll();
	}

	@Override
	public ReviewDetails getByIdReview(int id) {
		return repository.findById(id)
				.orElseThrow(()-> new ReviewNotFoundException("Review Id Not Found : " + id));
	}

	@Override
	public ReviewDetails createData(ReviewDetails review) {
		return repository.save(review);
	}

	@Override
	public ReviewDetails updateData(ReviewDetails review) {
		return repository.save(review);
	}

	@Override
	public String deleteByIdReview(int id) {
		repository.deleteById(id);
		return "Delete Completed... id : " + id;
	}

	@Override
	public String deleteAll() {
		repository.deleteAll();
		return "All Deleted...";
	}

}
