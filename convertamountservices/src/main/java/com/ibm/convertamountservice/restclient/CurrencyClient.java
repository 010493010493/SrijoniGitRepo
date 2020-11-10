package com.ibm.convertamountservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="currency-service")
public interface CurrencyClient {
	
	@GetMapping("/currency/{id}")
	public Double getConversionFactor(@PathVariable(value = "id") Long id, @RequestParam(value = "countryCode") String code);

}
