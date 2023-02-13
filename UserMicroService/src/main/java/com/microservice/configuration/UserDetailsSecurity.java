package com.microservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.microservice.configuration.userdetailsservice.UserDetailsUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class UserDetailsSecurity {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
					.authorizeHttpRequests()
					.requestMatchers("/user/create").permitAll()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/user/**").authenticated()
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/user/**").hasRole("ADMIN")
					.and()
					.authorizeHttpRequests()
					.requestMatchers("/user/id/","/user/delete/id/").hasAnyRole("USER","ADMIN")
					.and().httpBasic()
					.and().logout()
					.and().build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return daoAuthenticationProvider;
	}

}
