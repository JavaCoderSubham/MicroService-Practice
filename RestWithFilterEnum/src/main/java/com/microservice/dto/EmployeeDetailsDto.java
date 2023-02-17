package com.microservice.dto;

import java.util.List;

import com.microservice.entity.EmployeeDetails;

public interface EmployeeDetailsDto {

	List<EmployeeDetails> getAll();
	
	EmployeeDetails getSingleEmployee(String id);
	
	EmployeeDetails createEmployee(EmployeeDetails employee);
	
	String deleteSingleEmployee(String id);
	
//	Searching Methods
	List<EmployeeDetails> searchingFields(String name);
	
	
	
//	Custom Finding Method
	
	List<EmployeeDetails> findByEmployeeEmail(String employeeEmail);
	
	List<EmployeeDetails> findByEmployeeName(String employeeName);
	
	List<EmployeeDetails> findByEmployeePassword(String employeePassword);
	
	List<EmployeeDetails> findByEmployeeNameStartingWith(String name);
	
	List<EmployeeDetails> findByEmployeeNameEndingWith(String name);
	
	List<EmployeeDetails> findByEmployeeNameContaining(String name);
	
	List<EmployeeDetails> findByEmployeeNameNot(String name);
	
	List<EmployeeDetails> findByEmployeeNameLike(String name);
	
}
