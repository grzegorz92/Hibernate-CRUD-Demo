package com.customers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customers.entity.Customer;

public class CreateCustomer implements Cstmr{

	
	public void execute(SessionFactory factory) {

		
		DataScanner ds = new DataScanner();
		ds.getData();
		
		
		Customer customer = new Customer(ds.getFirstName(), ds.getLastName(), ds.getCompany(), ds.getEmail(),
				ds.getPhoneNumber());
		
		Session s = factory.getCurrentSession();
		s.beginTransaction();
		s.save(customer);

		s.getTransaction().commit();
		System.out.println("Customer created!");

	}

}
