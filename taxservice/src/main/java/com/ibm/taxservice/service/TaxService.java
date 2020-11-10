package com.ibm.taxservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.taxservice.entity.Tax;
import com.ibm.taxservice.repository.TaxRepository;

@Service
public class TaxService {
	
	@Autowired
	TaxRepository taxRepo;
	
	public Double tax(Long id) {
		
		Optional<Tax> taxes = taxRepo.findById(id);
		return taxes.get().getTax();
		
	}

}
