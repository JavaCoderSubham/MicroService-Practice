package com.microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ReviewDetails {

	@Id
	@GeneratedValue
	private int reviewId;
	private String userId;
	private int hotelId;
	private int rating;
	private String feedback;
	
}
