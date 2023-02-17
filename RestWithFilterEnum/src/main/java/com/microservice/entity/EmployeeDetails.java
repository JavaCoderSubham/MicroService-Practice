package com.microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeDetails {

	@Id
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePassword;
	
}











