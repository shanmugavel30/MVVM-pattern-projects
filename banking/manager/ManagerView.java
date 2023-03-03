package com.banking.manager;

import java.util.List;
import java.util.Scanner;

import com.banking.dto.AccountHolder;
import com.banking.login.LoginView;


public class ManagerView {

	private ManagerModel managermodel;
	private Scanner scan= new Scanner(System.in);
	
	public ManagerView() {
		managermodel=new ManagerModel(this);
	}

	public void viewPage() {
		System.out.println("\n1.Show all user accounts\n2.Remove User\n3.Exit");
		System.out.println("Enter your option:");
		int option=scan.nextInt();
		if(option==1) {
			managermodel.getAllUsers();
		}
		else if(option==2) {
			System.out.println("Enter user Account number:");
			int accNumber=scan.nextInt();
			managermodel.removeUser(accNumber);
		}
		else {
			System.out.println("Exitted  from the manager login");
			LoginView ref=new LoginView();
			ref.mainPage();
		}
	}

	public void foundAllUsers(List<AccountHolder> allUsers) {
		System.out.printf("%15s %10s %10s %30s %10s %7s %20s","Account Number","Name","IFSC ","Address","Branch","Balance","Phone Number");
		System.out.println();
		for(int i=0;i<allUsers.size();i++) {
			System.out.printf("\n%15s %10s %10s %30s %10s %7s %20s",allUsers.get(i).getAccountNumber(),allUsers.get(i).getName(),allUsers.get(i).getIFSCcode(),allUsers.get(i).getAddress(),allUsers.get(i).getBranch()
					,allUsers.get(i).getBalance(),allUsers.get(i).getPhoneNo());
		}
		allUsers.clear();
		viewPage();
	}

	public void removeUserSuccess() {
		System.out.println("User removed successfully...");
		viewPage();
	}

	public void removeUserFailure() {
		System.out.println("No account is found to this account number");
		System.out.println("Remove failed.");
		viewPage();
	}
}
