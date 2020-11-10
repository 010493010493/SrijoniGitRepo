package com.ibm.currencyconvertservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.currencyconvertservices.dto.CurrencyDTO;
import com.ibm.currencyconvertservices.entity.Currency;
import com.ibm.currencyconvertservices.service.CurrencyConvertService;

@RequestMapping("currency")
@RestController
public class ConversionController {
	
	@Autowired
	CurrencyConvertService service;
	
	Logger logger = LoggerFactory.getLogger(ConversionController.class);
	
	@PostMapping("/create")
	public ResponseEntity<Currency> create(@RequestBody CurrencyDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createCurrency(dto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Currency> update(@PathVariable(value = "id") Long id, @RequestBody CurrencyDTO dto) {
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.updateCurrency(id, dto));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Currency> get(@PathVariable(value = "id") Long id, @RequestParam(value = "countryCode") String code){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.getCurrency(id, code));
			} catch(Exception e) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
	}
	
	@GetMapping("/{id}")
	public Double getConversionFactor(@PathVariable(value = "id") Long id, @RequestParam(value = "countryCode") String code){
		Currency currency = new Currency();
		try {
			return service.getCurrency(id, code).getConversionFactor();
			} catch(Exception e) {
				logger.error(e.getMessage());
			}
		
		return currency.getConversionFactor();
	}

}
