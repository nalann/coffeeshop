package com.coffee.shop.service;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.coffee.shop.model.Payment;

public class PaymentJsonParserService {
	@SuppressWarnings("unchecked")
	public ArrayList<Payment> paymentParser() {
		ArrayList<Payment> payments = new ArrayList<Payment>();
		JSONParser parser = new JSONParser();
		try {
			File currentDirFile = new File("json-resources");
			String helper = currentDirFile.getAbsolutePath();
			Object obj = parser.parse(new FileReader(helper + "/payments.json"));
			JSONArray paymentList = (JSONArray) obj;
			paymentList.forEach(payment -> payments.add(parsePaymentObject((JSONObject) payment)));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return payments;
	}
	
	private Payment parsePaymentObject(JSONObject payment) {
		Payment paymentObj = new Payment();
		paymentObj.setUser((String) payment.get("user"));
		paymentObj.setAmount((long) payment.get("amount"));
		return paymentObj;
	}
}
