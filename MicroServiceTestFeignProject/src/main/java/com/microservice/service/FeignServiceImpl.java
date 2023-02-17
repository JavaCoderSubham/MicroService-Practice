package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.UserInfo;
import com.microservice.feignconfig.Feign;

@Service
public class FeignServiceImpl implements FeignService{

	@Autowired
	private Feign feign;
	
	@Override
	public List<UserInfo> getAll() {
		return feign.getAll();
	}

	@Override
	public UserInfo getSingleUser(String id) {
		return feign.getSingleUser(id);
	}

	@Override
	public UserInfo createData(UserInfo user) {
		return feign.create(user);
	}

	@Override
	public UserInfo updateData(String id, UserInfo user) {
		return feign.update(id, user);
	}

	@Override
	public String deleteSingleUser(String id) {
		return feign.deleteSingle(id);
	}

	@Override
	public String deleteAll() {
		return feign.deleteAll();
	}
	
	

}
