package com.contact.insert;

import java.util.Scanner;

import com.contact.login.LoginView;


public class InsertView {
	private InsertModel insertmodel;
	private Scanner scan =new Scanner(System.in);
	
	public InsertView() {
		insertmodel=new InsertModel(this);
	}

	public void insertContacts() {
		System.out.println("#---Here you can add the contacts---#");
		System.out.println();
		long phoneNo;
		System.out.println("Enter the name: ");
		String name=scan.next();
		while(true) {
		     System.out.println("Enter  the PhoneNumber of contact:");
		     phoneNo=scan.nextLong();
		     if(String.valueOf(phoneNo).length()==10) {
		        break;
		     }
		}
		scan.nextLine();
		System.out.println("Enter the address:");
		String address=scan.nextLine();
		System.out.println("Enter the favourite state:");
		String fav=scan.nextLine();
		insertmodel.insertContact(name,phoneNo,address,fav);
	}

	public void insertSuccess() {
		System.out.println("Contact  inserted successfully---!");
		LoginView ref =new LoginView();
		ref.options();
	}
	
}
