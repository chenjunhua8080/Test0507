package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.send.Send;

public interface SendDao extends JpaRepository<Send, Integer>{

}
