package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="b_seqs")
	@SequenceGenerator(name="b_seqs",sequenceName="b_seqs",allocationSize=1)
	
	private int pid;
	
	@Column(name="product_name")
	private String pname;
	
	@Column(name="product_type")
	private String ptype;
	
	@Column(name="product_description")
	private String pdes;
	
	@Column(name="price")
	private double price;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(int pid, String pname, String pdes, String ptype, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdes = pdes;
		this.ptype = ptype;
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

	public String getPdes() {
		return pdes;
	}

	public void setPdes(String pdes) {
		this.pdes = pdes;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", pdes=" + pdes + ", ptype=" + ptype + ", price=" + price
				+ "]";
	}
}
