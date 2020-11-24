package com.ibm.dao;


public interface ObjectRepository<CC, CF> {
	
	public boolean addCurrencyConversionFactor(CC cc, CF cf);
	public boolean updateCurrencyConversionFactor(CC cc, CF cf);
	public CF getCurrencyConversionFactor(CC cc);
}
