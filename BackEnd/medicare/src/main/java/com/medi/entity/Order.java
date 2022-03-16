package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orderss")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="o_seq")
	@SequenceGenerator(name="o_seq",sequenceName="o_seq",allocationSize=1)
	
	@Column(name="order_id")
	private int sid;
	@Column(name="Order_Status")
	private String status;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int sid, String status) {
		super();
		this.sid = sid;
		this.status = status;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [sid=" + sid + ", status=" + status + "]";
	}
}
