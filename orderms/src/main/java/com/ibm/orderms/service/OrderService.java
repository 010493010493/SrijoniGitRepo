package com.ibm.orderms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.orderms.entity.Order;
import com.ibm.orderms.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	public Order createOrder(String userToken) {
		Order order = new Order();
		order.setUserToken(userToken);
		return orderRepo.save(order);
	}

}
