package com.medi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.entity.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer>{

}
