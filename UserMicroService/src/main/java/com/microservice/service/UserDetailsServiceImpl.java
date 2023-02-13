package com.microservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.entity.HotelDetails;
import com.microservice.entity.UserDetails;
import com.microservice.exception.UserDetailsNotFoundException;
import com.microservice.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
// Repository
	
	@Autowired
	private UserDetailsRepository repository;		
	
//	Logger 
	
	private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

//	RestTemplate
	
	@Autowired
	public RestTemplate restTemplate;
	
//	Password Encoder
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//	Get All UserDetails With HotelDetails
	
	@Override
	public List<UserDetails> getAll() {
		logger.info("getAll() -> | ");
		List<UserDetails> user = repository.findAll();
		logger.info("getAll() -> | User : {}",user);
		
		logger.info("Rest Template -> | ");
		
//		Using Rest Template Send Request for Hotel Details
		
		for(UserDetails userDetails : user) {
			int userId = userDetails.getUserId();
			logger.info("get User ID | id : {}",userId);
			HotelDetails[] hotel = restTemplate.getForObject("http://localhost:8081/hotel/userid/"+userId, HotelDetails[].class);
			List<HotelDetails> hotelDetails = Arrays.stream(hotel).toList();
			logger.info("Get Hotels List | Hotels : {}",hotelDetails);
			userDetails.setHotel(hotelDetails);
		}
		
		return user;
	}

//	Get By ID UserDetails With HotelDetails
	
	@Override
	public UserDetails getById(int id) {
		logger.info("getById() -> | id : {}" + id);
		UserDetails user = repository.findById(id)
				.orElseThrow(()-> new UserDetailsNotFoundException("User Details Not found : Id :" +id));
		logger.info("RestTemplate -> ");
		HotelDetails[] hotel = restTemplate.getForObject("http://localhost:8081/hotel/userid/"+user.getUserId(), HotelDetails[].class);
		List<HotelDetails> hotelList = Arrays.stream(hotel).toList();
		user.setHotel(hotelList);
		logger.info("getById() -> | User : {}" + user);
		return user;
	}

//	Create UserDetails Methods
	
	@Override
	public UserDetails createUser(UserDetails user) {
		logger.info("createUser() -> | User : {}" + user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		logger.info("Password : Encode : {}",user.getPassword());
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
	
//	Delete All

	@Override
	public void deleteAll() {
		logger.info("deleteAll() -> ");
		repository.deleteAll();
	}

}







