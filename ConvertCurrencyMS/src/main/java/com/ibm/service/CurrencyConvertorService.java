package com.ibm.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.client.ManageCurrencyConversionFactorClient;

@Service
public class CurrencyConvertorService {

	private final static Logger LOGGER = Logger.getLogger(CurrencyConvertorService.class.getName());
	
	@Autowired
	private ManageCurrencyConversionFactorClient client;
	
	public Double convertCurrency(String countryCode, double amount) {
		Double conversionFactor = client.get(countryCode);
		LOGGER.info("Converted Amount : " + conversionFactor);
		return amount * conversionFactor;
	}
}
