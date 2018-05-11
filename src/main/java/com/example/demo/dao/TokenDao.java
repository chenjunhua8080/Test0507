package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Token;

public interface TokenDao extends JpaRepository<Token, Integer>{

	@Query("select t from Token t where t.id=(select max(id) from Token)")
	public Token findByIdMax();

}
