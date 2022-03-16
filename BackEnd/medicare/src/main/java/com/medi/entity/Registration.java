package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Registration {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="h_seqs")
	@SequenceGenerator(name="h_seqs",sequenceName="h_seqs",allocationSize=1)
	
	private int rid;
	
	@Column(name="name")
	private String cname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="address")
	private String address;
	
	@Column(name="gender")
	private String gender;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(int rid, String cname, String email, String password, long mobile, String address,
			String gender) {
		super();
		this.rid = rid;
		this.cname = cname;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.gender = gender;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Registration [rid=" + rid + ", cname=" + cname + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", address=" + address + ", gender=" + gender + "]";
	}
}
