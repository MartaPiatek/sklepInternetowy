package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void processOrder(String productId, int count) {

		Product productById=productRepository.getProductById(productId);
		
		if(productById.getUnitsInStock()<count){
			
			throw new IllegalArgumentException("Za ma³o towaru. Obecna liczba sztuk w magazynie to: "+productById.getUnitsInStock());
			
		}
		
		productById.setUnitsInStock(productById.getUnitsInStock()-count);
		
	}// koniec processOrder

	

	
}// koniec OrderServiceImpl
