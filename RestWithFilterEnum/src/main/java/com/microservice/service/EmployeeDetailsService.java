package com.microservice.service;

import java.util.List;

import com.microservice.entity.EmployeeDetails;

public interface EmployeeDetailsService {

	List<EmployeeDetails> getAll();
	
	EmployeeDetails getSingleEmployee(String id);
	
	EmployeeDetails createEmployee(EmployeeDetails employee);
	
	String deleteSingleEmployee(String id);
	
	
	List<EmployeeDetails> filterEmployee(String filter, String value);
	
	
//	Searching Methods
	List<EmployeeDetails> searchingFields(String name);
	
	
}












