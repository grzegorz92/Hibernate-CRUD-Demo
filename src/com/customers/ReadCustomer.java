package com.customers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customers.entity.Customer;

public class ReadCustomer implements Cstmr {

	private Integer id;

	public ReadCustomer(Integer id) {
		this.id = id;
	}

	
	@Override
	public void execute(SessionFactory factory) {
		
		
		Session s = factory.getCurrentSession();
		s.beginTransaction();		
		Customer customer = s.get(Customer.class, id);
		
		
		// If customer is null (Customer doesn't exist) reading won't be execute - Avoid NullPointerException
		if(customer!=null) {
		
		System.out.println("Customer with ID "+id+" is: "+customer);
		s.getTransaction().commit();
		}else {
			System.out.println("\n\nCustomer with ID "+id+" doesn't exist!");
			s.getTransaction().commit(); // Must be here, otherwise if customer==null Session is not closed, and next operation is not possible
		}
			

	}

}
