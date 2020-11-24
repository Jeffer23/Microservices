package com.ibm.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dto.Orders;
import com.ibm.entities.Order;
import com.ibm.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public boolean saveOrder(Orders orders) {
		Set<Order> orderSet = new HashSet<Order>();
		orders.getProducts().stream().forEach(order->{
			Order orderObj = new Order();
			orderObj.setJwtToken(orders.getJwtToken());
			orderObj.setProductId(order.getProductId());
			orderObj.setQuantity(order.getQuantity());
			orderObj.setTransactionToken(orders.getTransactionToken());
			
			orderSet.add(orderObj);
		});
		
		this.repo.saveAll(orderSet);
		return true;
	}
	
}
