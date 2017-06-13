package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.OrderRepository;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.CartService;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;
	
	
	
	@Override
	public void processOrder(String productId, int count) {

		Product productById=productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock()<count){
			
			throw new IllegalArgumentException("Za malo towaru. Obecna liczba sztuk w magazynie to: "+productById.getUnitsInStock());
			
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock()-count);
		
	}// koniec processOrder

	@Override
	public Long saveOrder(Order order) {
		// TODO Auto-generated method stub
		
		Long orderId=orderRepository.saveOrder(order);
		cartService.delete(order.getCart().getCartId());
		
		return orderId;
	}

	

	
}// koniec OrderServiceImpl
