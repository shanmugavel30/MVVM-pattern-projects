package com.banking.login;

import java.util.List;
import java.util.Scanner;

import com.banking.accountholder.AccountHolderView;
import com.banking.dto.AccountHolder;
import com.banking.manager.ManagerView;
import com.banking.newuser.NewUserView;


public class LoginView {

	private LoginModel loginmodel;
	private Scanner scan= new Scanner(System.in);
	
	public LoginView() {
		loginmodel=new LoginModel(this);
	}

	public static void main(String[] args) {
		LoginView reference=new LoginView();
		reference.mainPage();
	}

	public void mainPage() {
		System.out.println("..-->Welcome to Banking management website..<--");
		System.out.println("---____There are Three Login____---");
		System.out.println("1.Manager Login \n2.Account Holder Login\n3.New User Login\n4.Exit");
		System.out.println();
		System.out.println("Please Enter your choice:");
		int choice=scan.nextInt();
		if(choice==1) {
			System.out.println("<---Welcome manager--->");
			System.out.println("Enter manager name:");
			String managerName=scan.next();
			System.out.println("Enter the password:");
			String password=scan.next();
			loginmodel.checkAdmin(managerName,password);
			
		}
		else if(choice==2) {
			System.out.println("_---Welcome user---_");
			System.out.println("Enter your account number:");
			int accNo=scan.nextInt();
			System.out.println("Enter your Name:");
			String name=scan.next();
			loginmodel.checkUserExist(accNo,name);
		}
		else if(choice==3) {
			System.out.println("Enter your name:");
			String name=scan.next();
			
			while(true) {
				System.out.println("Enter your password:");
				String password=scan.next();
				if(password.length()>=8) {
					break;
				}
				System.out.println("Please enter valid password");
				System.out.println("Password should contains 8 characters.");	
			}
			NewUserView linktonew = new  NewUserView();
			linktonew.pageForNewUser(name);
		}
		else {
			System.out.println("You are exitted from the website...!");
			System.out.println("<<----Don't forget to come again...!");
		}
		
	}

	public void userNotFound() {
		System.out.println("Invalid Account number.");
		System.out.println("Your account has not exist.");
		mainPage();
	}

	public void userFound(List<AccountHolder> currentAccount) {
		System.out.println("Your Account has been found.");
		AccountHolderView reference = new AccountHolderView();
		reference.choices(currentAccount);
	}

	public void adminSuccess() {
		System.out.println("Manager Logged in successfully...");
		ManagerView  linktomanager = new ManagerView();
		linktomanager.viewPage();
	}

	public void adminFailure() {
		System.out.println("Manager login have been failed...");
		mainPage();
	}

}
