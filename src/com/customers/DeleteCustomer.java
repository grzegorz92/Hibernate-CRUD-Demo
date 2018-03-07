package com.customers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customers.entity.Customer;

public class DeleteCustomer implements Cstmr {

	private int id;

	public DeleteCustomer(int id) {
		this.id = id;
	}
	
	
	

	@Override
	public void execute(SessionFactory factory) {
		
		
		Session s = factory.getCurrentSession();
		
		s.beginTransaction();
		
		Customer c = s.get(Customer.class, id);
		
		
		// If c is null (Customer doesn't exist) deleting won't be execute - Avoid NullPointerException
		if(c!=null) {
			s.delete(c);
			s.getTransaction().commit();
			
			System.out.println("\n\nCustomer with ID: "+id+" deleted!");
		}else {
			System.out.println("\n\nCustomer with ID "+id+" doesn't exist!");
			s.getTransaction().commit(); // Must be here, otherwise if c==null Session is not closed, and next operation is not possible
		}
		
		
		
		
	}

}
