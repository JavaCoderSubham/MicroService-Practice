package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{

}
