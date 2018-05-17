package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.NewsMedia;

public interface NewsMediaDao extends JpaRepository<NewsMedia, Integer>{

}
