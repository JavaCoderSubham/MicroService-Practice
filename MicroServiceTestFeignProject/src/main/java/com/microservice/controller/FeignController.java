package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.microservice.entity.UserInfo;
import com.microservice.service.FeignService;

@RestController
@RequestMapping("/feign")
public class FeignController {

	@Autowired
	private FeignService service;
	
	@GetMapping("/userall")
	public ResponseEntity<List<UserInfo>> getAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.getAll());
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserInfo> getSingle(@RequestParam String id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.getSingleUser(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserInfo> create(@RequestBody UserInfo user) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.createData(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserInfo> update(@RequestParam String id, @RequestBody UserInfo user) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.updateData(id, user));
	}
	
	@DeleteMapping("/single")
	public ResponseEntity<String> deleteSingle(@RequestParam String id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteSingleUser(id));
	}
	
	@DeleteMapping("/delete") 
	public ResponseEntity<String> deleteAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteAll());
	}
	
	
	
	
}
