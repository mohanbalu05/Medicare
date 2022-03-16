package com.medi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

}
