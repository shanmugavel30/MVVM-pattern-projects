package com.banking.newuser;

import com.banking.repo.BankRep;

public class NewUserModel {

private  NewUserView userview;
	
	public NewUserModel(NewUserView usercontroller) {
		this.userview=usercontroller;
	}

	public void createAccount(String name, String num, String address, long phoneNo) {
		BankRep.getInstance().createAccount(name,num,address,phoneNo);
		userview.createAccountSuccess(BankRep.getInstance().accNo);
	}
}
