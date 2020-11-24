package com.ibm.dto;

import java.util.HashSet;
import java.util.Set;

public class Orders {

	private Set<Product> products = new HashSet<>();
	private String jwtToken;
	private String transactionToken;
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getTransactionToken() {
		return transactionToken;
	}
	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}
	
	
}
