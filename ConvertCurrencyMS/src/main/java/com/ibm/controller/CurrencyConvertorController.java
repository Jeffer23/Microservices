package com.ibm.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.service.CurrencyConvertorService;

@RestController
@RequestMapping("/currencyConvertor")
public class CurrencyConvertorController {

	private final static Logger LOGGER = Logger.getLogger(CurrencyConvertorController.class.getName());
	
	@Autowired
	private CurrencyConvertorService service;
	
	@GetMapping("/convert")
	public Double convertCurrency(@RequestParam("countryCode") String countryCode, @RequestParam("amount") double amount) {
		LOGGER.info("Country Code : " + countryCode);
		LOGGER.info("Amount : " + amount);
		return service.convertCurrency(countryCode, amount);
	}
	

	
}
