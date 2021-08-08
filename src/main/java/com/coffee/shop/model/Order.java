package com.coffee.shop.model;

public class Order {
	private String user;
	private String drink;
	private String size;
	
	public Order() {}
	
	public Order(String user, String drink, String size) {
		this.drink = drink;
		this.size = size;
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
