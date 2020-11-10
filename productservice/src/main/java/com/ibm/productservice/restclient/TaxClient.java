package com.ibm.productservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tax-service")
public interface TaxClient {
	
	@GetMapping("/tax/{id}")
	public Double tax(@PathVariable(value="id") Long id);

}
