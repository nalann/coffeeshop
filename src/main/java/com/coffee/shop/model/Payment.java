package com.coffee.shop.model;

public class Payment {
	private String user;
	private long amount;
	public Payment() {}
	
	public Payment(String user, long amount) {
		this.user = user;
		this.amount = amount;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
