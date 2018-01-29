package com.customers;

import java.util.Scanner;

public class DataScanner {

	private String firstName;
	private String lastName;
	private String company;
	private String email;
	private String phoneNumber;

	public void getData() {

		Scanner input = new Scanner(System.in);

		System.out.println("First name: ");
		firstName = input.nextLine();

		System.out.println("Last name: ");
		lastName = input.nextLine();

		System.out.println("Company name: ");
		company = input.nextLine();

		System.out.println("e-mail: ");
		email = input.nextLine();

		System.out.println("Phone number: ");
		phoneNumber = input.nextLine();
		
		

	}
	
	
	///

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompany() {
		return company;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
