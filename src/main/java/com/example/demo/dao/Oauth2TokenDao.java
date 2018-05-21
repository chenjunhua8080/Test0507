package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.oauth2.Oauth2Token;

public interface Oauth2TokenDao extends JpaRepository<Oauth2Token, Integer>{

}
