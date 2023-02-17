package com.microservice.service;

import java.util.List;

import com.microservice.entity.UserInfo;

public interface UserInfoService {
	
	List<UserInfo> getAll();
	
	UserInfo getSingleUser(String id);
	
	UserInfo createUserInfo(UserInfo user);
	
	UserInfo updateUserImfo(String id, UserInfo user);
	
	String deleteSingleUserInfo(String id);
	
	String deleteAll();

}
