package com.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.LoginDao;
import com.medi.entity.Login;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/logins")
public class LoginController {

	@Autowired
	private LoginDao logindao;
	
	@GetMapping("/logins")
	public List<Login> getAllCarts(){
		return logindao.findAll();
	}		
	
	
	@PostMapping("/logins")
	public Login createCarts(@RequestBody Login cart) {
		return logindao.save(cart);
	}
}
