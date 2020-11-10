package com.ibm.currencyconvertservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.currencyconvertservices.converter.CurrencyConverter;
import com.ibm.currencyconvertservices.dto.CurrencyDTO;
import com.ibm.currencyconvertservices.entity.Currency;
import com.ibm.currencyconvertservices.repository.CurrencyRepository;

@Service
public class CurrencyConvertService {
	
	@Autowired
	CurrencyRepository currencyRepo;
	
public Currency createCurrency(CurrencyDTO dto) {
		
		CurrencyConverter converter = new CurrencyConverter();
		return currencyRepo.save(converter.convertToEntity(dto));
	}

public Currency updateCurrency(Long id,CurrencyDTO dto) throws Exception{
	
	CurrencyConverter converter = new CurrencyConverter();
	Optional<Currency> currency=currencyRepo.findById(id);
	if(currency.isPresent()) {
		if(currency.get().getCountryCode().equalsIgnoreCase(dto.getCountryCode())){
			
			return currencyRepo.save(converter.convertToEntityForUpdate(id, dto));
		} else {
			throw new Exception();
		}
	} else {
		throw new Exception();
	}
}

public Currency getCurrency(Long id, String code) throws Exception {
	Optional<Currency> currency=currencyRepo.findById(id);
	if(currency.isPresent()) {
		if(currency.get().getCountryCode().equalsIgnoreCase(code)){
			return currency.get();
		}else {
			throw new Exception();
		}
	} else {
		throw new Exception();
	}
}

}
