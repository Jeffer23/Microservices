package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.dao.impl.CurrencyConvertorRepository;

@Service
public class CurrencyConversionFactorService {

	@Autowired
	private CurrencyConvertorRepository repo;
	
	public boolean addConversionFactor(String countryCode, double conversionFactor) {
		return repo.addCurrencyConversionFactor(countryCode, conversionFactor);
	}
	
	public boolean updateConversionFactor(String countryCode, double conversionFactor) {
		return repo.updateCurrencyConversionFactor(countryCode, conversionFactor);
	}
	
	public Double getConversionFactor(@RequestParam("countryCode") String countryCode) {
		return repo.getCurrencyConversionFactor(countryCode);
	}
}
