package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "logins")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "g_seqs")
	@SequenceGenerator(name = "g_seqs", sequenceName = "g_seqs", allocationSize = 1)

	@Column(name = "lid")
	private int lid;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int lid, String email, String password) {
		super();
		this.lid = lid;
		this.email = email;
		this.password = password;
	}

	public long getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [lid=" + lid + ", email=" + email + ", password=" + password + "]";
	}
}
