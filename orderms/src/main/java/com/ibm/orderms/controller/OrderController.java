package com.ibm.orderms.controller;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.orderms.service.OrderService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RequestMapping("/order")
@RefreshScope
@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/{userToken}")
	public Long createOrder(@PathVariable(value="userToken") String userToken) {
		System.out.println("Srijoni Srijoni "+ userToken);
		Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("mySecretKey"))
                .parseClaimsJws(userToken).getBody();
        System.out.println("Srijoni 11 "+claims);
		return service.createOrder(userToken).getId();

}
}
