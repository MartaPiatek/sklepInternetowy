package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	List<Customer> listOfCustomers =new ArrayList<Customer>();

		@Autowired
		private CustomerRepository customerRepository;
	
	
	
	@Override
	public List<Customer> getAllCustomers() {

		listOfCustomers=customerRepository.getAllCustomers();
		
		return listOfCustomers;
	}

	
	
}
