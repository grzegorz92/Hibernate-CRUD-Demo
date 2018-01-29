package com.customers;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.customers.entity.Customer;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();

	

		Scanner sc = new Scanner(System.in);
		IdLoop idl = new IdLoop(); // Class with getId() method. When method is used, user is being asked to enter ID until it will be Integer
	
		try {
			
			
			//////////Start of the program ////////////////
			
			
			while(true) {
				
				
				
			//"What user want to do" loop			
			System.out.println(
					"\n\nChoose what do you want to do by pressing proper key: \n0 - Create new customer\n1 - Read customer by ID\n2 - Update customer by ID \n3 - Delete Customer by ID\n4 - End of program");

			Integer i = null;
			
			
			do {
			try{i = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Wrong command. You should use only numbers from 0 to 4. Try again: ");
				sc.next();
			}
			}while(i==null);			
			//
					
			
			
			
// CREATE new Customer using Scanner from DataScanner class
			if (i == 0) {				

				System.out.println("Create a new customer. Enter:  ");
				Cstmr create = new CreateCustomer();
				create.execute(factory);
				
				
// READ customer by entered ID
			} else if (i == 1) {

				System.out.println("Please enter ID of Customer that personal info you would like to read: ");
				ReadCustomer read = new ReadCustomer(idl.getId());
				read.execute(factory);

// UPDATE Customer using Scanner from DataScanner class
			} else if (i == 2) {

				System.out.println("Enter ID of Customer you want to update: ");
				Cstmr update = new UpdateCustomer(idl.getId());		
				update.execute(factory);

// DELETE Customer by entered ID
			} else if (i == 3) {
				
				System.out.println("Plese enter ID of customer that you want to delete: ");
				Cstmr delete = new DeleteCustomer(idl.getId());
				delete.execute(factory);				
			
			
			} else if(i == 4) {
				
				break;
				
			
			} else {
				System.out.println("Invalid Command. Try again.");

			}

			
			}
			/////////////////  END OF WHILE LOOP //////////////////////////////
			
			
			System.out.println("\nEND OF PROGRAM\n");
			
		} finally {

			factory.close();
		}

		sc.close();

	}

}
