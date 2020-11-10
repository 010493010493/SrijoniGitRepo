package com.ibm.convertamountservice.service;

import org.springframework.stereotype.Service;

import com.ibm.convertamountservice.dto.AmountDTO;
import com.ibm.convertamountservice.restclient.CurrencyClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AmountConversionService {
	
final CurrencyClient client;
	
	public AmountConversionService(CurrencyClient client) {
		this.client=client;
	}
	
	@HystrixCommand(fallbackMethod ="currencyServiceFallback")
	public AmountDTO getConvertedAmount(Long id,AmountDTO dto) {
		Double conversionFactor = client.getConversionFactor(id, dto.getCountryCode());
		Double convertedAmount = dto.getAmount()*conversionFactor;
		dto.setAmount(convertedAmount);
		dto.setId(id);
		return dto;
	}
	
	public AmountDTO currencyServiceFallback(Long id, AmountDTO dto) {
		Double conversionfactor = 1.0;
		Double convertedAmount = dto.getAmount()*conversionfactor;
		dto.setAmount(convertedAmount);
		dto.setId(id);
		return dto;
	}

}
