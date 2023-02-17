package com.microservice.controller;

import java.util.Arrays;
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
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.entity.UserInfo;

@RestController
@RequestMapping("/web")
public class WebClientController {
	
	@Autowired
	private WebClient webClient;

	@GetMapping
	public ResponseEntity<List<UserInfo>> getAll() {
		
		UserInfo[] get = webClient.get()
							.uri("http://localhost:8080/user")
							.retrieve()
							.bodyToMono(UserInfo[].class)
							.block();
		
		List<UserInfo> list = Arrays.stream(get).toList();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(list);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserInfo> getSingleUser(@PathVariable String id) {
		
		UserInfo getSingle = webClient.get()
							.uri("http://localhost:8080/user/"+id)
							.retrieve()
							.bodyToMono(UserInfo.class)
							.block();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(getSingle);
	}
	
	@PostMapping
	public ResponseEntity<UserInfo> create(@RequestBody UserInfo user) {
		
		UserInfo get = webClient.post()
						.uri("http://localhost:8080/user")
						.bodyValue(user)
						.retrieve()
						.bodyToMono(UserInfo.class)
						.block();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(get);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserInfo> update(@PathVariable String id,@RequestBody UserInfo user) {
		
		UserInfo get = webClient.put()
						.uri("http://localhost:8080/user/"+id)
						.bodyValue(user)
						.retrieve()
						.bodyToMono(UserInfo.class)
						.block();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(get);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSingle(@PathVariable String id) {
		
		String get = webClient.delete()
						.uri("http://localhost:8080/user/"+id)
						.retrieve()
						.bodyToMono(String.class)
						.block();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(get);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAll() {
		
		String get = webClient.delete()
						.uri("http://localhost:8080/user")
						.retrieve()
						.bodyToMono(String.class)
						.block();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(get);
	}
}
