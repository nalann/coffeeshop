package com.coffee.shop.model;

import java.util.HashMap;

public class Product {
	private String drinkName;
	private HashMap<String, Double> prices;
	public Product() {}
	public Product(String drinkName, HashMap<String,Double> prices) {
		this.drinkName = drinkName;
		this.prices = prices;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public HashMap<String, Double> getPrices() {
		return prices;
	}
	public void setPrices(HashMap<String, Double> prices) {
		this.prices = prices;
	}
}
