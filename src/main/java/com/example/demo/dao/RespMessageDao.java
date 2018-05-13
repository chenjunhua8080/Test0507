package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.message.resp.Message;

public interface RespMessageDao extends JpaRepository<Message, Integer>{

}
