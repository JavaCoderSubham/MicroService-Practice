package com.microservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue
	private int userId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String roles;
	
	@Transient
	List<HotelDetails> Hotel = new ArrayList<>();

}
