package com.microservice.dto;

import java.util.List;

import com.microservice.entity.UserInfo;

public interface UserInfoDto {

	List<UserInfo> getAll();
	
	UserInfo getSingleUser(String id);
	
	UserInfo createUserInfo(UserInfo user);
	
	UserInfo updateUserImfo(String id, UserInfo user);
	
	String deleteSingleUserInfo(String id);
	
	String deleteAll();
	
}
