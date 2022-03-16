package com.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.OrderDao;
import com.medi.entity.Order;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderDao orderdao;
	
	@GetMapping("/orders")
	public List<Order> getAllPayments(){
		return orderdao.findAll();
	}		
	
	
	@PostMapping("/orders")
	public Order createPayments(@RequestBody Order pay) {
		return orderdao.save(pay);
	}
}
