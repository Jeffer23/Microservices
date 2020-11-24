package com.ibm.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(url = "http://localhost:8080/currencyConversionFactor", name = "ManageCurrencyConversionFactorClient")
@FeignClient(name="MS1", fallback = ManageCurrencyConversionFactorFallback.class)
@RibbonClient("MS1")
public interface ManageCurrencyConversionFactorClient {

	@PostMapping("/currencyConversionFactor/add")
	public String add(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor);
	
	@PostMapping("/currencyConversionFactor/update")
	public String update(@RequestParam("countryCode") String countryCode, @RequestParam("conversionFactor") double conversionFactor);
	
	@GetMapping("/currencyConversionFactor/get")
	public Double get(@RequestParam("countryCode") String countryCode);
}
