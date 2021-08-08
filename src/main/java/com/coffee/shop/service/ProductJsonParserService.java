package com.coffee.shop.service;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.coffee.shop.model.Product;

public class ProductJsonParserService {

	@SuppressWarnings("unchecked")
	public HashMap<String, HashMap<String, Double>> productParser() {
		HashMap<String, HashMap<String, Double>> products = new HashMap<String, HashMap<String, Double>>();
		JSONParser parser = new JSONParser();
		try {
			File currentDirFile = new File("json-resources");
			String helper = currentDirFile.getAbsolutePath();
			Object obj = parser.parse(new FileReader(helper + "/products.json"));
			JSONArray productList = (JSONArray) obj;
			productList.forEach(product -> {
				Product x = parseProductObject((JSONObject) product);
				products.put(x.getDrinkName(), x.getPrices());
			});
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}
		return products;

	}

	private Product parseProductObject(JSONObject product) {
		Product productObj = new Product();
		HashMap<String, Double> prices = new HashMap<String, Double>();
		productObj.setDrinkName((String) product.get("drink_name"));
		JSONObject pricesObj = (JSONObject) product.get("prices");
		if (pricesObj.containsKey("small"))
			prices.put("small", (double) pricesObj.get("small"));
		if (pricesObj.containsKey("medium"))
			prices.put("medium", (double) pricesObj.get("medium"));
		if (pricesObj.containsKey("large"))
			prices.put("large", (double) pricesObj.get("large"));
		if (pricesObj.containsKey("huge"))
			prices.put("huge", (double) pricesObj.get("huge"));
		if (pricesObj.containsKey("mega"))
			prices.put("mega", (double) pricesObj.get("mega"));
		if (pricesObj.containsKey("ultra"))
			prices.put("ultra", (double) pricesObj.get("ultra"));
		productObj.setPrices(prices);
		return productObj;
	}
}
