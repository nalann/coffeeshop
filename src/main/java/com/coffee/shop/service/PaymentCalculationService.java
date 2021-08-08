package com.coffee.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.coffee.shop.model.Order;
import com.coffee.shop.model.Payment;

public class PaymentCalculationService {
	public static Map<String, Double> orderAmountCalculation(ArrayList<Order> orderList,
			HashMap<String, HashMap<String, Double>> productList) {
		Map<String, Double> userOrderMap = new HashMap<String, Double>();
		// calculation of order list by user
		orderList.forEach(order -> {
			if (userOrderMap.containsKey(order.getUser())) {
				double amount = userOrderMap.get(order.getUser())
						+ productList.get(order.getDrink()).get(order.getSize());
				userOrderMap.replace(order.getUser(), amount);
			} else {
				userOrderMap.put(order.getUser(), productList.get(order.getDrink()).get(order.getSize()));
			}
		});

		return userOrderMap;
	}

	public static Map<String, Double> paymentAmountCalculation(ArrayList<Payment> paymentList) {
		return paymentList.stream()
				.collect(Collectors.groupingBy(Payment::getUser, Collectors.summingDouble(Payment::getAmount)));
	}

	public static Map<String, Double> owesCalculation(Map<String, Double> paymentMap, Map<String, Double> orderMap) {
		Map<String, Double> owesMap = paymentMap.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						entry -> owesCount(entry.getValue(), orderMap.get(entry.getKey()))))
				.entrySet().stream().filter(map -> map.getValue() < 0)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		return owesMap;
	}

	private static double owesCount(double d1, double d2) {
		return d1 - d2;
	}
}
