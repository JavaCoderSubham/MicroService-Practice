package com.microservice.configuration.userdetailsservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.microservice.configuration.UserDetailsUserDetailsImpl;
import com.microservice.exception.UserDetailsNotFoundException;
import com.microservice.repository.UserDetailsRepository;

@Component
public class UserDetailsUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.microservice.entity.UserDetails> getUserDetails = 
				repository.findByEmail(username);
		
		return getUserDetails.map(UserDetailsUserDetailsImpl::new)
						.orElseThrow(()-> new UserDetailsNotFoundException("Wrong Email Try Again"));
					
	}

}
