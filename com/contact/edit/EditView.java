package com.contact.edit;

import java.util.Scanner;

import com.contact.login.LoginView;


public class EditView {
	private EditModel editmodel;
	private Scanner scan=new Scanner(System.in);
	
	public EditView() {
		editmodel = new EditModel(this);
	}

	public void editContact() {
		System.out.println("Here,you can edit your contacts---!");
		System.out.println("\n1.Edit by name\n2.Edit by number\n3.Back");
		System.out.println("Enter the option: ");
		int option=scan.nextInt();
		if(option==1) {
			long  phoneNo;
			System.out.println("Enter the name: ");
			String name=scan.next();
			while(true) {
			     System.out.println("Enter  the PhoneNumber to edit:");
			     phoneNo=scan.nextLong();
			     if(String.valueOf(phoneNo).length()==10) {
			        break;
			     }
			}
			editmodel.editContactByName(name, phoneNo);
		}
		else if(option==2) {
			long  phoneNo;
			while(true) {
			     System.out.println("Enter  the PhoneNumber of contact:");
			     phoneNo=scan.nextLong();
			     if(String.valueOf(phoneNo).length()==10) {
			        break;
			     }
			}
			System.out.println("Enter the name: ");
			String name=scan.next();
			editmodel.editContactByNum(phoneNo,name);
		}
		else {
			System.out.println("Returning to the  home page");
			LoginView ref =new LoginView();
			ref.options();
		}
		
	}

	public void editContactByNameFailed() {
		System.out.println("You are searched for invalid contact...!");
		System.out.println("Please search by valid contact name....!#");
		editContact();
	}

	public void editContactByNameSuccess() {
		System.out.println("Your contact edited successfully...!");
		System.out.println();
		LoginView ref =new LoginView();
		ref.options();
	}

	public void editContactByNumFailed() {
		System.out.println("You are searched for invalid contact...!");
		System.out.println("Please search by valid contact number....!#");
		editContact();
	}

	public void editContactByNumSuccess() {
		System.out.println("Your contact edited successfully...!");
		System.out.println();
		LoginView ref =new LoginView();
		ref.options();
	}
}
