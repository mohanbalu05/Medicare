package com.medi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medi.dao.ProductsDao;
import com.medi.entity.Products;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsDao productsdao;
	

	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productsdao.findAll();
	}		
	
	
	@PostMapping("/products")
	public Products createProducts(@RequestBody Products products) {
		return productsdao.save(products);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable int id) {
		Products products = productsdao.findById(id)
				.orElseThrow(null);
		return ResponseEntity.ok(products);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProducts(@PathVariable int id, @RequestBody Products productsDetails){
		Products products = productsdao.findById(id)
				.orElseThrow(null);
		
		products.setPname(productsDetails.getPname());
		products.setPdes(productsDetails.getPdes());
		products.setPtype(productsDetails.getPtype());
		products.setPrice(productsDetails.getPrice());
		
		Products updatedProducts = productsdao.save(products);
		return ResponseEntity.ok(updatedProducts);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProducts(@PathVariable int id){
		Products products = productsdao.findById(id)
				.orElseThrow(null);
		
		productsdao.delete(products);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
