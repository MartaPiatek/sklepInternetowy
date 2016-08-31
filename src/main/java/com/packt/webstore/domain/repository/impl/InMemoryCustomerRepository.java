package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;


@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

	
	private List <Customer> listOfCustomers=new ArrayList<Customer>();
	
	
	
	
	public InMemoryCustomerRepository() {
		
		Customer c1=new Customer("C1", "Adam Nowak", "Wroc³aw");
		c1.setNoOfOrdersMade(1);
				
		Customer c2=new Customer("C2", "Jan Kowalski", "Warszawa");
		c2.setNoOfOrdersMade(3);
		
		
		Customer c3=new Customer("C3", "Edward No¿ycorêki", "Bydgoszcz");
		c3.setNoOfOrdersMade(2);
		
		
		listOfCustomers.add(c1);
		listOfCustomers.add(c2);
		listOfCustomers.add(c3);
	}




	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return listOfCustomers;
	}

}
