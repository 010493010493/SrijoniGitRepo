package com.ibm.orderms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderms.entity.Order;
import com.ibm.orderms.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@GetMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestParam(value="userToken")String userToken) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(userToken));

}
}
