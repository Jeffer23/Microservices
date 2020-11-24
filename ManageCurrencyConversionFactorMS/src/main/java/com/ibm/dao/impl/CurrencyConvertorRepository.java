package com.ibm.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ibm.dao.ObjectRepository;

@Repository
public class CurrencyConvertorRepository implements ObjectRepository<String, Double> {

	private static final Map<String, Double> DB = new HashMap<String, Double>();
	@Override
	public boolean addCurrencyConversionFactor(String countryCode, Double conversionFactor) {
		if(DB.get(countryCode) == null ) {
			DB.put(countryCode.toUpperCase(), conversionFactor);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateCurrencyConversionFactor(String countryCode, Double conversionFactor) {
		if(DB.get(countryCode) != null ) {
			DB.put(countryCode.toUpperCase(), conversionFactor);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Double getCurrencyConversionFactor(String countryCode) {
		return DB.get(countryCode.toUpperCase());
	}

}
