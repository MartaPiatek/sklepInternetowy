package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository{

	private Map<Long, Order> listOfOrders;
	private long nextOrderId;
	
	
	
	public InMemoryOrderRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
		listOfOrders=new HashMap<Long, Order>();
		nextOrderId=1000;
		
	}



	@Override
	public Long saveOrder(Order order) {
		// TODO Auto-generated method stub
		order.setOrderId(getNextOrderId());
		listOfOrders.put(order.getOrderId(), order);
		
		return order.getOrderId();
	}



	private synchronized long getNextOrderId() {
		// TODO Auto-generated method stub
		return nextOrderId++;
	}

	
	
	
}
