package com.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.PaymentDao;
import com.medi.entity.Payment;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentDao paydao;
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paydao.findAll();
	}		
	
	
	@PostMapping("/payments")
	public Payment createPayments(@RequestBody Payment pay) {
		return paydao.save(pay);
	}
}
