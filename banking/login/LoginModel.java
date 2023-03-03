package com.banking.login;

import java.util.ArrayList;
import java.util.List;

import com.banking.dto.AccountHolder;
import com.banking.repo.BankRep;

public class LoginModel {

private LoginView loginmodel;
	
	public LoginModel(LoginView logincontroller) {
		this.loginmodel=logincontroller;
	}

	public void checkUserExist(int accNo, String name) {
		List<AccountHolder> currentAccount=new ArrayList<>();
		currentAccount=BankRep.getInstance().getAccount(accNo,name);
//		System.out.println(currentAccount);
		if(currentAccount==null) {
			loginmodel.userNotFound();
		}
		else {
			loginmodel.userFound(currentAccount);
		}
	}

	public void checkAdmin(String managerName, String password) {
		if(managerName.equalsIgnoreCase("shanmugavel") && password.equalsIgnoreCase("Selvam@20")) {
			loginmodel.adminSuccess();
		}
		else {
			loginmodel.adminFailure();
		}
	}
}
