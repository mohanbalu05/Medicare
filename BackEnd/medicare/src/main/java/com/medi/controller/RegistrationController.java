package com.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.RegistrationDao;
import com.medi.entity.Registration;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class RegistrationController {

	@Autowired
	private RegistrationDao registerdao;
	
	@GetMapping("/users")
	public List<Registration> getAllUsers(){
		return registerdao.findAll();
	}		
	
	
	@PostMapping("/users")
	public Registration createUsers(@RequestBody Registration registration) {
		return registerdao.save(registration);
	}
}
