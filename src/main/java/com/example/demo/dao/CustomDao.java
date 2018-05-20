package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.custom.Custom;

public interface CustomDao  extends JpaRepository<Custom, Integer>{

}
