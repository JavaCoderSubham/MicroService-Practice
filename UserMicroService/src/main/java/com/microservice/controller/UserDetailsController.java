package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.UserDetails;
import com.microservice.service.UserDetailsService;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

	@Autowired
	private UserDetailsService service;
	
	private final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);
	
	@GetMapping
	public ResponseEntity<List<UserDetails>> getAllUser() {
		logger.info("========== Start Get All ==========");
		logger.info("getAllUser() -> | ");
		List<UserDetails> all = service.getAll();
		logger.info("getAllUser() -> | after Return Users : {}",all);
		logger.info("========== End Get All ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable int id) {
		logger.info("========== Start Get By ID ==========");
		logger.info("getuserDetailsById() -> | id : {}",id);
		UserDetails byId = service.getById(id);
		logger.info("getuserDetailsById() -> | After Return User : {}",byId);
		logger.info("========== End Get By ID ==========");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(byId);
	}
	
	@PostMapping
	public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails user) {
		logger.info("========== Start Create User ==========");
		logger.info("createUserDetails() -> | User : {}",user);
		UserDetails createUser = service.createUser(user);
		logger.info("createUserDetails() -> | After Create User : {}",createUser);
		logger.info("========== End Create User ==========");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(createUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDetails> updateUserDetails(@PathVariable int id, @RequestBody UserDetails user) {
		logger.info("========== Start Update User ==========");
		logger.info("updateUserDetails() -> | id : {} | User : {}",id,user);
		UserDetails updateUser = service.updateUser(id, user);
		logger.info("updateUserDetails() -> | User : {}",updateUser);
		logger.info("========== End Update User ==========");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteByIDUserDetails(@PathVariable int id) {
		logger.info("========== Start Delete By ID ==========");	
		logger.info("deleteByIDUserDetails() -> | id : {}",id);
		service.deleteById(id);
		logger.info("deleteByIDUserDetails() -> | Delete... User id : {}",id);
		logger.info("========== End Delete By ID ==========");		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body("Deleted... | User id : " + id);
	}
	
}


















