package com.microservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.UserDetails;
import com.microservice.exception.UserDetailsNotFoundException;
import com.microservice.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDetailsRepository repository;		// Repository
	
//	Logger 
	private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

//	Get All UserDetails Methods
	@Override
	public List<UserDetails> getAll() {
		logger.info("getAll() -> | ");
		List<UserDetails> user = repository.findAll();
		logger.info("getAll() -> | User : {}",user);
		return user;
	}

//	Get By ID UserDetails Methods
	@Override
	public UserDetails getById(int id) {
		logger.info("getById() -> | id : {}" + id);
		UserDetails user = repository.findById(id)
				.orElseThrow(()-> new UserDetailsNotFoundException("User Details Not found : Id :" +id));
		logger.info("getById() -> | User : {}" + user);
		return user;
	}

//	Create UserDetails Methods
	@Override
	public UserDetails createUser(UserDetails user) {
		logger.info("createUser() -> | User : {}" + user);
		UserDetails save = repository.save(user);
		logger.info("createUser() -> | User : {}" + save);
		return save;
	}

//	Update UserDetails Methods
	@Override
	public UserDetails updateUser(int id,UserDetails user) {
		logger.info("updateUser() -> | id : {} | User : {}",id,user);
		UserDetails getUser = getById(id);
		logger.info("User Found User : {}",getUser);
		
		getUser.setName(user.getName());
		getUser.setEmail(user.getEmail());
		getUser.setPassword(user.getPassword());
		getUser.setAddress(user.getAddress());
		
		logger.info("updateUser() -> | After Update User : {}",getUser);
		
		return repository.save(getUser);
	}
	
//	Checking Id Present or Not
	private boolean isIdPresent(int id) {
		logger.info("isIdPresent() -> | id : {}",id);
		Optional<UserDetails> getUser = repository.findById(id);
		logger.info("User Present : " + getUser.isPresent());
		logger.info("isIdPresent() -> | id : {}",getUser.orElse(null));
		return getUser.isPresent();
	}

//	Delete By Id Method
	@Override
	public void deleteById(int id) {
		logger.info("deleteById() -> | id : {}" + id);
		if(isIdPresent(id)) {
			logger.info("Deleted... id : {}",id);
			repository.deleteById(id);
			logger.info("deleteById() -> | id : {}" + id);
		}
		else
			throw new UserDetailsNotFoundException("User Not Present Wrong id : "+id);
		
	}

}







