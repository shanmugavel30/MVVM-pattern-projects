package com.banking.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.banking.dto.AccountHolder;


public class BankRep {

	private static BankRep repInstance;
	public Map<Integer,AccountHolder> accountdetails=new HashMap<>();
	public List<String> transactionType = new LinkedList<>();
	public List<Integer> transactionAmount =new LinkedList<>();
	public List<Integer> currentBal =new LinkedList<>();
	public List<AccountHolder> allUsers = new ArrayList<>();
	public boolean flag=true,pinstate=true,remove=false;
	public int accNo;
	private AccountHolder account;
	
	private BankRep() {

	}
	
	public static BankRep getInstance() {
		if (repInstance == null) {

			repInstance = new BankRep();
			repInstance.setAccount();
		}
		return repInstance;
	}


	private void setAccount() {
		account = new AccountHolder(29631312, "CNR2963", "selvam", "pudhumanai street,Tenkasi", "tenkasi", 1000,"3333", 8870837890L);
		accountdetails.put(29631312, account);
		account = new AccountHolder(29631417, "CNR2963", "sanjay", "kamarajar street,madurai", "tenkasi", 1000,"7777", 8220936451L);
		accountdetails.put(29631417, account);
		account = new AccountHolder(29632382, "CNR2963", "siva", "Anna nagar street,Tenkasi", "tenkasi", 1000,"8888",9790075692L);
		accountdetails.put(29632382, account);
		account = new AccountHolder(29638912, "CNR2963", "dani", "minnagar street,Tenkasi", "tenkasi", 1000,"2309",8990377323L);
		accountdetails.put(29638912, account);
	}

	public List<AccountHolder> getAccount(int accNo, String name) {
		List<AccountHolder> currentaccount=new ArrayList<>();
		for (Map.Entry<Integer, AccountHolder> entry : accountdetails.entrySet()) {

			if ( entry.getValue().getAccountNumber()==accNo) {

				currentaccount.add(entry.getValue());
				return currentaccount;
			}
		}
		return null;
	}
	public void creditAmount(List<AccountHolder> account,int creditAmount){
		int amount=account.get(0).getBalance()+creditAmount;
		account.get(0).setBalance(amount);
		transactionType.add("credit");
		transactionAmount.add(creditAmount);
		currentBal.add(amount);
	}

	public void debitAmount(List<AccountHolder> account2, int debitAmount,String pin) {
		if(pin.equals(account2.get(0).getPin())) {
		
		   int amount=account2.get(0).getBalance()-debitAmount;
		   if(amount<0) {
			  flag=false;
			  return;
		   }
		else {
			account2.get(0).setBalance(amount);
			transactionType.add("debit ");
			transactionAmount.add(debitAmount);
			currentBal.add(amount);
		   }
		}else {
			pinstate=false;
			return;
		}
	}

	public void createAccount(String name, String num, String address, long phoneNo) {
		
		int bankNum=2963;
		String randNum=String.valueOf(bankNum);
		String bankNum2=randNum+num;
		accNo=Integer.parseInt(bankNum2);
		account = new AccountHolder(accNo, "CNR2963", name, address, "tenkasi", 1000,"8903", phoneNo);
		accountdetails.put(accNo, account);
		
	}

	public void getAllUsers() {
		for (Map.Entry<Integer, AccountHolder> entry : accountdetails.entrySet()) {
				allUsers.add(entry.getValue());
		}	
	}

	public void removeUser(int accNumber) {
		if(accountdetails.containsKey(accNumber)) {
			accountdetails.remove(accNumber);
			remove=true;
		}
	}
}
