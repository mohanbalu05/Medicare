package com.medi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medi.entity.Products;

@Repository
public interface ProductsDao extends JpaRepository<Products, Integer>{

}
