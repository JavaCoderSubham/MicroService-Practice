package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.EmployeeDetails;
import com.microservice.service.EmployeeDetailsService;

@RestController
@RequestMapping("/employee")
public class EmployeeDetailsController {

	@Autowired
	private EmployeeDetailsService service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDetails>> getAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDetails> getSingleEmployee(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.getSingleEmployee(id));
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDetails> createEmployee(@RequestBody EmployeeDetails employee) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.createEmployee(employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSingleEmployee(@PathVariable String message) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.deleteSingleEmployee(message));
	}
	
	@GetMapping("/filter")
	public ResponseEntity<List<EmployeeDetails>> filterEmployee(@RequestParam String filter, 
										@RequestParam String value) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.filterEmployee(filter, value));
	}
	
	@GetMapping("/searching")
	public ResponseEntity<List<EmployeeDetails>> searchingMethod(@RequestParam String name) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(service.searchingFields(name));
	}
	
}







