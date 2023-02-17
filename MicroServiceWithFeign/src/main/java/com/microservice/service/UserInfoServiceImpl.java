package com.microservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserInfoDto;
import com.microservice.entity.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDto dto;

	@Override
	public List<UserInfo> getAll() {
		return dto.getAll();
	}

	@Override
	public UserInfo getSingleUser(String id) {
		return dto.getSingleUser(id);
	}

	@Override
	public UserInfo createUserInfo(UserInfo user) {
		
		String uuid = UUID.randomUUID().toString();
		
		user.setUserId(uuid);
		
		return dto.createUserInfo(user);
	}

	@Override
	public UserInfo updateUserImfo(String id, UserInfo user) {
		return dto.updateUserImfo(id, user);
	}

	@Override
	public String deleteSingleUserInfo(String id) {
		return dto.deleteSingleUserInfo(id);
	}

	@Override
	public String deleteAll() {
		return dto.deleteAll();
	}

}
