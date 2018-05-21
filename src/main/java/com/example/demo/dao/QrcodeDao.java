package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.qrcode.Qrcode;

public interface QrcodeDao extends JpaRepository<Qrcode, Integer>{

}
