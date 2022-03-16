package com.medi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="f_seqs")
	@SequenceGenerator(name="f_seqs",sequenceName="f_seqs",allocationSize=1)
	
	@Column(name="pay_id")
	private int pid;
	@Column(name="Paid_Amount")
	private double amt;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int pid, double amt) {
		super();
		this.pid = pid;
		this.amt = amt;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", amt=" + amt + "]";
	} 
}
