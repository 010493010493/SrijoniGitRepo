package com.ibm.accountlogin.service;

import org.springframework.stereotype.Service;

import com.ibm.accountlogin.restclient.OrderClient;

@Service
public class AccountLoginService {
	
	final OrderClient client;
	
	public AccountLoginService(OrderClient client) {
		this.client=client;
	}
	
	public Long getOrder(String token) {
		
		Long id=client.createOrder(token);
		
		return id;
	}
	

}
