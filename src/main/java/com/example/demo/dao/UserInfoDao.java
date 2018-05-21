package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.oauth2.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{

}
