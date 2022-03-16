package com.medi;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medi.dao.CartDao;
import com.medi.dao.LoginDao;
import com.medi.dao.PaymentDao;
import com.medi.dao.ProductsDao;
import com.medi.dao.RegistrationDao;
import com.medi.entity.Cart;
import com.medi.entity.Login;
import com.medi.entity.Payment;
import com.medi.entity.Products;
import com.medi.entity.Registration;

@SpringBootTest
class MediApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	RegistrationDao regdao;
	ProductsDao prodao;
	LoginDao logdao;
	CartDao cartdao;
	PaymentDao paydao;
	
	
	@Test
	public void addUsers() {
		Registration reg = new Registration();
		
		reg.setCname("");
		reg.setEmail("B");
		reg.setPassword("B");
		reg.setMobile(1);
		reg.setAddress("");
		reg.setGender("");
		regdao.save(reg);
		assertNotNull(regdao.findById(3).get());
	}
	
	@Test
	public void showAllUser() {
		List<Registration> list = regdao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void findUser() {
		Registration reg = regdao.findById(2).get();
		assertEquals(2, reg.getRid());
	}
	
	@Test
	public void deleteUser() {
		regdao.deleteById(5);
		assertThat(regdao.existsById(5)).isFalse();
	}
	
	@Test
	public void addProducts() {
		Products reg = new Products();
		

		reg.setPname("");
		reg.setPdes("B");
		reg.setPtype("B");
		reg.setPrice(1);
		prodao.save(reg);
		assertNotNull(prodao.findById(3).get());
	}
	
	@Test
	public void showAllProducts() {
		List<Products> list = prodao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void findProducts() {
		Products pro = prodao.findById(2).get();
		assertEquals(2, pro.getPid());
	}
	
	@Test
	public void deleteProduct() {
		prodao.deleteById(3);
		assertThat(prodao.existsById(3)).isFalse();
	}
	
	@Test
	public void addCarts() {
		Cart cart = new Cart();
		

		cart.setPname("");
		cart.setPdes("B");
		cart.setPtype("B");
		cart.setPrice(1);
		cartdao.save(cart);
		assertNotNull(cartdao.findById(2).get());
	}
	
	@Test
	public void showAllCarts() {
		List<Cart> list = cartdao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void addPay() {
		Payment pay = new Payment();
		

		pay.setAmt(500);
		paydao.save(pay);
		assertNotNull(paydao.findById(2).get());
	}
	
	@Test
	public void showAllPay() {
		List<Payment> list = paydao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void addLogins() {
		Login log = new Login();
		
		log.setEmail("B");
		log.setPassword("B");
		logdao.save(log);
		assertNotNull(logdao.findById(2).get());
	}
	
	@Test
	public void showAllLogins() {
		List<Login> list = logdao.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
}
