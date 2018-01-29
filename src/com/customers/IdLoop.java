package com.customers;

import java.util.InputMismatchException;
import java.util.Scanner;



public class IdLoop {
	
	
	
	public Integer getId() {
		
	
		Scanner sc = new Scanner(System.in);
		Integer rd=null;
		
		
		do{
			try {
			rd = sc.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("Invalid ID. Try again.");
				sc.next();
			}
			}while(rd == null);
		
		
		
		
		return rd;
	}
	

}
