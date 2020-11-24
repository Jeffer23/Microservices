package com.ibm.client;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class ManageCurrencyConversionFactorFallback implements ManageCurrencyConversionFactorClient{

	private final static Logger LOGGER = Logger.getLogger(ManageCurrencyConversionFactorFallback.class.getName());
			
	@Override
	public String add(String countryCode, double conversionFactor) {
		
		return "Unable to add " + countryCode;
	}

	@Override
	public String update(String countryCode, double conversionFactor) {
		return "Unable to update " + countryCode;
	}

	@Override
	public Double get(String countryCode) {
		LOGGER.info("Fallback Called");
		return 0.0;
	}

}
