package com.banking.manager;

import com.banking.repo.BankRep;

public class ManagerModel {

    private ManagerView managerview;
	
	public ManagerModel(ManagerView managercontroller) {	
		this.managerview=managercontroller;
	}

	public void getAllUsers() {
		BankRep.getInstance().getAllUsers();
		managerview.foundAllUsers(BankRep.getInstance().allUsers);
	}

	public void removeUser(int accNumber) {
		BankRep.getInstance().removeUser(accNumber);
		if(BankRep.getInstance().remove) {
			managerview.removeUserSuccess();
		}
		else {
			managerview.removeUserFailure();
		}
	}
}
