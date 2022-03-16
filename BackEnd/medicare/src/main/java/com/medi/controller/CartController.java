package com.medi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.CartDao;
import com.medi.entity.Cart;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/carts")
public class CartController {
	
	
	@Autowired
	private CartDao cartdao;
	
	@GetMapping("/carts")
	public List<Cart> getAllCarts(){
		return cartdao.findAll();
	}		
	
	
	@PostMapping("/carts")
	public Cart createCarts(@RequestBody Cart cart) {
		return cartdao.save(cart);
	}

}
