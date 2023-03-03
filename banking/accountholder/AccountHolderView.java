package com.banking.accountholder;

import java.util.List;
import java.util.Scanner;

import com.banking.dto.AccountHolder;
import com.banking.login.LoginView;

public class AccountHolderView {

	private AccountHolderModel accmodel;
	private Scanner scan=new Scanner(System.in);
	
	public AccountHolderView() {
		accmodel=new AccountHolderModel(this);
	}
	public void choices(List<AccountHolder> account) {
		System.out.println("\n\n1.CheckDetails\n2.CreditAmount\n3.DebitAmount\n4.checkBalance\n5.Transaction History\n6.Exit");
		System.out.println();
		System.out.println("Enter your choice:");
		int opt=scan.nextInt();
		if(opt==1) {
			System.out.printf("%15s %10s %10s %30s %10s %7s %20s","Account Number","Name","IFSC ","Address","Branch","Balance","Phone Number");
			System.out.println();
			for(int i=0;i<account.size();i++) {
				System.out.printf("\n%15s %10s %10s %30s %10s %7s %20s",account.get(i).getAccountNumber(),account.get(i).getName(),account.get(i).getIFSCcode(),account.get(i).getAddress(),account.get(i).getBranch(),account.get(i).getBalance(),account.get(i).getPhoneNo());
			}
			choices(account);
		}
		else if(opt==2) {
			System.out.println("Enter the amount to credit:");
			int creditAmount=scan.nextInt();
			accmodel.creditAmount(account,creditAmount);
		}
		else if(opt==3) {
			System.out.println("Enter the amount to debit:");
			int debitAmount=scan.nextInt();
			System.out.println("Enter the pin:");
			String pin=scan.next();
			accmodel.debitAmount(account,debitAmount,pin);
		}
		else if(opt==4) {
			System.out.println("Your account Balance:"+account.get(0).getBalance());
			choices(account);
		}
		else if(opt==5) {
			//System.out.println();
			accmodel.getTransactions(account);
		}
		else {
			System.out.println("Exitted  from the account");
			LoginView ref=new LoginView();
			ref.mainPage();
		}
	}
	public void creditSuccess(List<AccountHolder> account,int creditAmount) {
		System.out.println(creditAmount+" amount credited into your account successfully...!");
		choices(account);
	}
	public void debitSuccess(List<AccountHolder> account,int debitAmount) {
		System.out.println(debitAmount+" amount debited successfully from your account...!");
		choices(account);
	}
	public void debitFailure(List<AccountHolder> account,boolean pinstate) {
		if(!pinstate) {
			System.out.println("You entered the invalid pin.");
			System.out.println("You cannot Debit from your account.");
			choices(account);
		}
		System.out.println("---Your bank balance is low---");
		System.out.println("You cannot Debit from your account.");
		choices(account);
	}
	public void transactionNotFound(List<AccountHolder> account) {
		System.out.println("Any transactions didn't happen...");
		choices(account);
	}
	public void foundTransaction(List<AccountHolder> account, List<String> transactionType,
			List<Integer> transactionAmount,List<Integer> currentBal) {
		System.out.println("Your transactions are given below--->");
		for(int i=0;i<transactionType.size();i++) {
			System.out.println((i+1)+"-"+transactionType.get(i)+"--->"+transactionAmount.get(i)+"----->"+currentBal.get(i));
		}
		choices(account);
	}
}
