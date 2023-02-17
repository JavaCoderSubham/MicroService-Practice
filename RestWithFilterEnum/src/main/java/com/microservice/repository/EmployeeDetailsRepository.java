package com.microservice.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservice.entity.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, String>{
	

	List<EmployeeDetails> findByEmployeeEmail(String employeeEmail);
	
	List<EmployeeDetails> findByEmployeeName(String employeeName);
	
	List<EmployeeDetails> findByEmployeePassword(String employeePassword);
	
	List<EmployeeDetails> findByEmployeeNameStartingWith(String name);
	
	List<EmployeeDetails> findByEmployeeNameEndingWith(String name);
	
	List<EmployeeDetails> findByEmployeeNameContaining(String name);
	
	List<EmployeeDetails> findByEmployeeNameNot(String name);
	
	List<EmployeeDetails> findByEmployeeNameLike(String name);
	
	@Query("select e from EmployeeDetails e where e.employeeName LIKE CONCAT('%',:name,'%')"
			+ "or e.employeeEmail LIKE CONCAT('%',:name,'%')"
			+ "or e.employeePassword Like CONCAT('%',:name,'%')")
	List<EmployeeDetails> searchingMethod(@Param("name") String name);
	
	
	
}












