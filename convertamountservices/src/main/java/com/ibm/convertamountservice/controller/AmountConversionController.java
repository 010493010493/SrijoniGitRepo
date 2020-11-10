package com.ibm.convertamountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertamountservice.dto.AmountDTO;
import com.ibm.convertamountservice.service.AmountConversionService;

@RequestMapping("amount")
@RestController
public class AmountConversionController {
	
	@Autowired
	AmountConversionService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<AmountDTO> getConvertedAmount(@PathVariable(value = "id") Long id, @RequestBody AmountDTO dto){
		return ResponseEntity.status(HttpStatus.OK).body(service.getConvertedAmount(id, dto)); 
	}
	

}
