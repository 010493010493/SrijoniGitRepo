package com.ibm.taxservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.taxservice.service.TaxService;

@RequestMapping("tax")
@RefreshScope
@RestController
public class TaxController {
	
	@Autowired
	TaxService taxService;
	
	@Value("${message}")
	private String message;
	
	@GetMapping("/{id}")
	public Double tax(@PathVariable(value="id") Long id) {
		
	return taxService.tax(id);
	}
	
	@GetMapping("/message")
	public String msg() {
		
		return this.message;
	}

}