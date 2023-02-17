package com.microservice.controller;

import java.util.List;

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

import com.microservice.entity.UserInfo;
import com.microservice.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	private UserInfoService service;

	@GetMapping
	public List<UserInfo> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public UserInfo getSingleUser(@PathVariable String id) {
		return service.getSingleUser(id);
	}
	
	@PostMapping
	public UserInfo create(@RequestBody UserInfo user) {
		return service.createUserInfo(user);
	}
	
	@PutMapping("/{id}")
	public UserInfo update(@PathVariable String id, @RequestBody UserInfo user) {
		return service.updateUserImfo(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteSingle(@PathVariable String id) {
		return service.deleteSingleUserInfo(id);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return service.deleteAll();
	}
	
	
}







