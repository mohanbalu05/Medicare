package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "d_seqs")
	@SequenceGenerator(name = "d_seqs", sequenceName = "d_seqs", allocationSize = 1)

	@Column(name = "cid")
	private int pid;

	@Column(name = "product_name")
	private String pname;

	@Column(name = "product_type")
	private String ptype;
	
	@Column(name="product_description")
	private String pdes;

	@Column(name = "price")
	private double price;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int pid, String pname, String ptype, String pdes, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pdes = pdes;
		this.price = price;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPdes() {
		return pdes;
	}

	public void setPdes(String pdes) {
		this.pdes = pdes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pdes=" + pdes + ", price=" + price
				+ "]";
	}
}
