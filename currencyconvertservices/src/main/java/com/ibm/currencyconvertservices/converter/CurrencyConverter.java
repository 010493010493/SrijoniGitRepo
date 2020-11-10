package com.ibm.currencyconvertservices.converter;

import com.ibm.currencyconvertservices.dto.CurrencyDTO;
import com.ibm.currencyconvertservices.entity.Currency;

public class CurrencyConverter {
	
public Currency convertToEntity(CurrencyDTO dto) {
		
	Currency currency = new Currency();
	currency.setId(dto.getId());
	currency.setCountryCode(dto.getCountryCode());
	currency.setConversionFactor(dto.getConversionFactor());
		
		return currency;
	}

public Currency convertToEntityForUpdate(Long id,CurrencyDTO dto) {
	
	Currency currency = new Currency();
	currency.setId(id);
	currency.setCountryCode(dto.getCountryCode());
	currency.setConversionFactor(dto.getConversionFactor());
		
		return currency;
	}

}
