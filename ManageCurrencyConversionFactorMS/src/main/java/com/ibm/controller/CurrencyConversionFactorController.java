package com.ibm.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.service.CurrencyConversionFactorService;

@RestController
@RequestMapping("/currencyConversionFactor")
public class CurrencyConversionFactorController {

	private final static Logger LOGGER = Logger.getLogger(CurrencyConversionFactorController.class.getName());
	@Autowired
	private CurrencyConversionFactorService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addConversionFactor(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor) {
		boolean isAdded = service.addConversionFactor(countryCode, conversionFactor);
		if(isAdded) {
			return new ResponseEntity<>("Conversion Factor added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("This Country code is already added", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateConversionFactor(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor) {
		boolean isUpdated = service.updateConversionFactor(countryCode, conversionFactor);
		if(isUpdated) {
			return new ResponseEntity<>("Conversion Factor updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Country code does not exist", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/get")
	public Double getConversionFactor(@RequestParam("countryCode") String countryCode) {
		LOGGER.info("Country Code : " + countryCode);
		return service.getConversionFactor(countryCode);
	}
	
	
}
