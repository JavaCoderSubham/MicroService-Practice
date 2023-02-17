package com.microservice.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.entity.UserInfo;
import com.microservice.exception.UserNotFoundException;
import com.microservice.repository.UserInfoRepository;

@Repository
public class UserInfoDtoImpl implements UserInfoDto {
	
	@Autowired
	private UserInfoRepository repository;

	@Override
	public List<UserInfo> getAll() {
		return repository.findAll();
	}

	@Override
	public UserInfo getSingleUser(String id) {
		return repository.findById(id).orElseThrow(()->new UserNotFoundException("Repository User Not Found"));
	}

	@Override
	public UserInfo createUserInfo(UserInfo user) {
		return repository.save(user);
	}

	@Override
	public UserInfo updateUserImfo(String id, UserInfo user) {
		
		UserInfo getUser = getSingleUser(id);
		
		getUser.setName(user.getName());
		getUser.setEmail(user.getEmail());
		getUser.setPassword(user.getPassword());
		
		return repository.save(getUser);
	}

	@Override
	public String deleteSingleUserInfo(String id) {
		
		UserInfo getUser = getSingleUser(id);
		
		repository.deleteById(id);
		
		return "Deleted... | id : " + id;
	}

	@Override
	public String deleteAll() {
		repository.deleteAll();
		return "All Deleted...";
	}

}
