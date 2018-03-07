package com.customers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customers.entity.Customer;

public class UpdateCustomer implements Cstmr {

	private int id;

	public UpdateCustomer(int id) {

		this.id = id;
	}

	@Override
	public void execute(SessionFactory factory) {

		Session s = factory.getCurrentSession();
		
		s.beginTransaction();

		Customer c = s.get(Customer.class, id);

		
		// If c is null (Customer doesn't exist) updating won't be execute - Avoid NullPointerException
		if (c != null) {

			System.out.println("Update Customer with ID: " + id + "\n Enter:  ");
			DataScanner ds = new DataScanner();
			ds.getData();

			
			c.setFirstName(ds.getFirstName());
			c.setLastName(ds.getLastName());
			c.setCompanyName(ds.getCompany());
			c.setEmail(ds.getEmail());
			c.setPhoneNumber(ds.getPhoneNumber());

			s.getTransaction().commit();
			System.out.println("\n\nCustomer with ID: " + id + " updated!");
		} else {

			System.out.println("\n\nCustomer with ID " + id + " doesn't exist!");
			s.getTransaction().commit(); // Must be here, otherwise if c==null Session is not closed, and next operation is not possible
		}

	}

}
