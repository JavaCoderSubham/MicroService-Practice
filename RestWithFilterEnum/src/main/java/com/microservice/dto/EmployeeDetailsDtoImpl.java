package com.microservice.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.entity.EmployeeDetails;
import com.microservice.exception.EmployeeNotFoundException;
import com.microservice.repository.EmployeeDetailsRepository;

@Repository
public class EmployeeDetailsDtoImpl implements EmployeeDetailsDto{

	@Autowired
	private EmployeeDetailsRepository repository;

	@Override
	public List<EmployeeDetails> getAll() {
		return repository.findAll();
	}

	@Override
	public EmployeeDetails getSingleEmployee(String id) {
		return repository.findById(id).orElseThrow(()-> new EmployeeNotFoundException());
	}

	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employee) {
		return repository.save(employee);
	}

	@Override
	public String deleteSingleEmployee(String id) {
		repository.deleteById(id);
		return "Deleted... id : "+id;
	}

	
//	Custom Finding Methods
	
	@Override
	public List<EmployeeDetails> findByEmployeeEmail(String employeeEmail) {
		return repository.findByEmployeeEmail(employeeEmail);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeName(String employeeName) {
		return repository.findByEmployeeName(employeeName);
	}

	@Override
	public List<EmployeeDetails> findByEmployeePassword(String employeePassword) {
		return repository.findByEmployeePassword(employeePassword);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeNameStartingWith(String name) {
		return repository.findByEmployeeNameStartingWith(name);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeNameEndingWith(String name) {
		return repository.findByEmployeeNameEndingWith(name);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeNameContaining(String name) {
		return repository.findByEmployeeNameContaining(name);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeNameNot(String name) {
		return repository.findByEmployeeNameNot(name);
	}

	@Override
	public List<EmployeeDetails> findByEmployeeNameLike(String name) {
		return repository.findByEmployeeNameLike(name);
	}

	@Override
	public List<EmployeeDetails> searchingFields(String name) {
		return repository.searchingMethod(name);
	}
	
	
	
}
