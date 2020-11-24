package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dto.Orders;
import com.ibm.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/save")
	public boolean saveOrder(@RequestBody Orders orders) {
		return this.service.saveOrder(orders);
	}
}
