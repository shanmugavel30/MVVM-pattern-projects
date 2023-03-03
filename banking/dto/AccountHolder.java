package com.banking.dto;

public class AccountHolder {

	private int accountNumber;
	private String IFSCcode;
	private String name;
	private String address;
	private String branch;
	private int Balance;
	private String pin;
	private long phoneNo;
	
	public AccountHolder(int accountNumber, String iFSCcode, String name, String address, String branch,int balance,String pin,long phoneNo) {
		super();
		setAccountNumber(accountNumber);
		setIFSCcode(iFSCcode);
		this.setName(name);
		this.setAddress(address);
		this.setBranch(branch);
		this.Balance = balance;
		this.setPin(pin);
		this.phoneNo=phoneNo;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIFSCcode() {
		return IFSCcode;
	}

	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		Balance = balance;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
