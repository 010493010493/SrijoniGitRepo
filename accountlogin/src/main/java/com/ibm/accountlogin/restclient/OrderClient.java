package com.ibm.accountlogin.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "order-service")
public interface OrderClient {

	@PostMapping("/order/{userToken}")
	public Long createOrder(@PathVariable(value="userToken") String userToken);
}
