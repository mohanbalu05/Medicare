package com.medi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.entity.Registration;

@Repository
public interface RegistrationDao extends JpaRepository<Registration, Integer>{

}
