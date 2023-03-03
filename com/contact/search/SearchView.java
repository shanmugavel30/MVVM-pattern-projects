package com.contact.search;

import java.util.List;
import java.util.Scanner;

import com.contact.dto.Contacts;
import com.contact.login.LoginView;

public class SearchView {

	private SearchModel searchmodel;
	private Scanner scan = new Scanner(System.in);

	public SearchView() {
		searchmodel = new SearchModel(this);
	}

	public void searchContact() {
		System.out.println("\n1.Name\n2.PhoneNo\n3.Exit");
		System.out.println();
		System.out.println("Enter the option:");
		int option = scan.nextInt();
		if (option == 1) {
			scan.nextLine();
			System.out.println("Enter  the Name of contact:");
			String name = scan.nextLine();
			searchmodel.searchContact(name);
		} else if (option == 2) {
			scan.nextLine();
			while (true) {
				System.out.println("Enter  the PhoneNumber of contact:");
				long phoneNo = scan.nextLong();
				if (String.valueOf(phoneNo).length() == 10) {
					searchmodel.searchContactByNum(phoneNo);
					break;
				}
			}
		} else {
			System.out.println("*** You are exitted from the search page ***");
			LoginView ref = new LoginView();
			ref.options();
		}

	}

	public void searchFailed() {
		System.out.println("No contacts available according to this name...!");
		System.out.println("Please search by another name...-->");
		searchContact();
	}

	public void searchSuccess(List<Contacts> searchcontact) {
		int i = 0;
		while (i < searchcontact.size()) {
			System.out.printf("\nName      :%-20s", searchcontact.get(i).getName());
			System.out.printf("\nPhone No  :%-20s", searchcontact.get(i).getPhoneNo());
			System.out.printf("\nAddress   :%-30s", searchcontact.get(i).getAddress());
			System.out.printf("\nFavourite :%-10s", searchcontact.get(i).getFavState());
			System.out.println();
			i++;
		}
		System.out.println("Returning to home page...!");
		System.out.println();

		LoginView ref = new LoginView();
		ref.options();
	}

}
