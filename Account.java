package com.RestApi.SpringRestApi.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@Column(name="accno")
	 private int accno;
	 private String accnm;
	 private String acctype;
	 private float balance;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getAccnm() {
		return accnm;
	}
	public void setAccnm(String accnm) {
		this.accnm = accnm;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", accnm=" + accnm + ", acctype=" + acctype + ", balance=" + balance + "]";
	}
	 	
	
}
