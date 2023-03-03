package com.contact.delete;

import java.util.Scanner;

import com.contact.login.LoginView;

public class DeleteView {

	private  DeleteModel delmodel;
	private Scanner scan = new Scanner(System.in);
	
	public DeleteView() {
		this.delmodel= new DeleteModel(this);
	}
	public void deleteContact() {
		System.out.println("\n1.Delete By Name\n2.Delete All Contacts\n3.Back");
		System.out.println();
		System.out.println("Enter your option: ");
		int opt=scan.nextInt();
		if(opt==1) {
		    System.out.println("Enter the name to delete");
		    System.out.println("Enter the name: ");
		    String name=scan.next();
		    delmodel.deleteContact(name);
		}
		else if(opt==2) {
			delmodel.deleteAllContact();
		}
		else {
			System.out.println("Returning to the home page...!");
			LoginView ref =new LoginView();
			ref.options();
		}
	}
	public void deleteContactFailed() {
		System.out.println("No contact available here to delete...!");
		System.out.println("#Please enter valid contact name...");
		deleteContact();
	}
	public void deleteContactSuccess() {
		System.out.println("Contact deleted successfully...!");
		System.out.println();
		System.out.println("Returning to the home page...!");
		LoginView ref =new LoginView();
		ref.options();
	}
	public void deleteAllContactSuccess() {
		System.out.println("All contacts are deleted  successfully...!");
	}
}
