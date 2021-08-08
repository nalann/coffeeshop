package com.coffee.shop.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.coffee.shop.model.Order;
import com.coffee.shop.model.Payment;
import com.coffee.shop.service.OrderJsonParserService;
import com.coffee.shop.service.PaymentCalculationService;
import com.coffee.shop.service.PaymentJsonParserService;
import com.coffee.shop.service.ProductJsonParserService;

public class CoffeeShopApp {
	public static void main(String[] args) 
    {
		OrderJsonParserService orderService = new OrderJsonParserService();
		ArrayList<Order> orderList = orderService.orderParser();
		
		ProductJsonParserService productService = new ProductJsonParserService();
		HashMap<String, HashMap<String, Double>> productList = productService.productParser();
		
		PaymentJsonParserService paymentService = new PaymentJsonParserService();
		ArrayList<Payment> paymentList = paymentService.paymentParser();
		
		Map<String,Double> orderMap = PaymentCalculationService.orderAmountCalculation(orderList, productList);
		Map<String, Double> paymentMap = PaymentCalculationService.paymentAmountCalculation(paymentList);
		Map<String,Double> owesMap = PaymentCalculationService.owesCalculation(paymentMap, orderMap);
		
		paymentMap.forEach((key , value) -> {
			System.out.println("Payment of " + key + " : " + value);
		});
		
		System.out.println("---------------");
		
		owesMap.forEach((key , value) -> {
			System.out.println("Owe of " + key + " : " + value);
		});
    }
}
