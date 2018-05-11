package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.A;

public interface ADao extends JpaRepository<A, Integer>{

	public List<A> findAllByOrderById();

	public List<A> findAllByOrderByHref();
	
}
