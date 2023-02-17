package com.microservice.service;

import java.util.List;

import com.microservice.entity.UserInfo;

public interface FeignService {
	
	List<UserInfo> getAll();

	UserInfo getSingleUser(String id);

	UserInfo createData(UserInfo user);
	
	UserInfo updateData(String id, UserInfo user);
	
	String deleteSingleUser(String id);
	
	String deleteAll();
	
}







