package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.entity.ReviewDetails;
import com.microservice.repository.ReviewDetailsRepository;

public class ReviewDetailsServiceImpl implements ReviewDetailsService{

	@Autowired
	private ReviewDetailsRepository repository;
	
	@Override
	public List<ReviewDetails> getAll() {
		return null;
	}

	@Override
	public ReviewDetails getById(int id) {
		return null;
	}

	@Override
	public ReviewDetails createData(ReviewDetails review) {
		return null;
	}

	@Override
	public ReviewDetails updateData(int id, ReviewDetails review) {
		return null;
	}

	@Override
	public ReviewDetails deleteById(int id) {
		return null;
	}

	@Override
	public ReviewDetails deleteAll() {
		return null;
	}

}
