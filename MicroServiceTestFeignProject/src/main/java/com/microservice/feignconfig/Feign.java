package com.microservice.feignconfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.entity.UserInfo;

@FeignClient(value = "userInfo", url = "http://localhost:8080/user")
public interface Feign {

	@GetMapping
	public List<UserInfo> getAll();

	@GetMapping("/{id}")
	public UserInfo getSingleUser(@PathVariable String id);
	
	@PostMapping
	public UserInfo create(@RequestBody UserInfo user);
	
	@PutMapping("/{id}")
	public UserInfo update(@PathVariable String id, @RequestBody UserInfo user);
	
	@DeleteMapping("/{id}")
	public String deleteSingle(@PathVariable String id);
	
	@DeleteMapping("/deleteAll")
	public String deleteAll();
	
	
	
}







