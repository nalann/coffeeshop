package com.coffee.shop.service;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.coffee.shop.model.Order;

public class OrderJsonParserService {
	
	public ArrayList<Order> orderParser() {
		ArrayList<Order> orders = new ArrayList<Order>();
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/orders.json"));
			JSONArray orderList = (JSONArray) obj;
			orderList.forEach(order -> orders.add(parseOrderObject((JSONObject) order)));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orders;
	}
	
	private Order parseOrderObject(JSONObject order) {
		Order orderObj = new Order();
		orderObj.setUser((String) order.get("user"));
		orderObj.setSize((String) order.get("size"));
		orderObj.setDrink((String) order.get("drink"));
		return orderObj;
	}

}
