package com.microservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.microservice.dto.EmployeeDetailsDto;
import com.microservice.entity.EmployeeDetails;
import com.microservice.filter.FilterEmployee;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	private EmployeeDetailsDto dto;

	@Override
	public List<EmployeeDetails> getAll() {
		return dto.getAll();
	}

	@Override
	public EmployeeDetails getSingleEmployee(String id) {
		return dto.getSingleEmployee(id);
	}

	@Override
	public EmployeeDetails createEmployee(EmployeeDetails employee) {
		
		String uuid = UUID.randomUUID().toString();
		
		employee.setEmployeeId(uuid);
		
		return dto.createEmployee(employee);
	}

	@Override
	public String deleteSingleEmployee(String id) {
		return dto.deleteSingleEmployee(id);
	}

	@Override
	public List<EmployeeDetails> filterEmployee(String filter, String value) {
		
		List<EmployeeDetails> list = null;
		
		FilterEmployee filterValue = FilterEmployee.valueOf(filter);
		
		switch (filterValue) {
		case startwith: {
			list = dto.findByEmployeeNameStartingWith(value);
			break;
		}
		case endwith: {
			list = dto.findByEmployeeNameEndingWith(value);
			break;
		}
		case name:
			list = dto.findByEmployeeName(value);
			break;
		case email:
			list = dto.findByEmployeeEmail(value);
			break;
		case password:
			list = dto.findByEmployeePassword(value);
			break;
		case contain:
			list = dto.findByEmployeeNameContaining(value);
			break;
		case not:
			list = dto.findByEmployeeNameNot(value);
			break;
		case like:
			list = dto.findByEmployeeNameLike(value);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + filterValue);
		}
		
		
		return list;
	}

	@Override
	public List<EmployeeDetails> searchingFields(String name) {
		return dto.searchingFields(name);
	}
	
	
//	public Page<List<EmployeeDetails>> paging() {
//		Page<List<EmployeeDetails>> pageList = dto.getAll().;
//	}

}
