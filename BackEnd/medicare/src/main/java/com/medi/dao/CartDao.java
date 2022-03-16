package com.medi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
