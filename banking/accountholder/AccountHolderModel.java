package com.banking.accountholder;

import java.util.List;

import com.banking.dto.AccountHolder;
import com.banking.repo.BankRep;

public class AccountHolderModel {

    private AccountHolderView  accview;
	
	public AccountHolderModel(AccountHolderView acccontroller) {
		this.accview=acccontroller;
	}

	public void creditAmount(List<AccountHolder> account,int creditAmount) {
		BankRep.getInstance().creditAmount(account, creditAmount);
		accview.creditSuccess(account,creditAmount);
	}

	public void debitAmount(List<AccountHolder> account, int debitAmount,String pin) {
		BankRep.getInstance().debitAmount(account, debitAmount,pin);
		if(BankRep.getInstance().pinstate) {
		  if(BankRep.getInstance().flag) {
			  accview.debitSuccess(account,debitAmount);
		  }
		  else {
			accview.debitFailure(account,BankRep.getInstance().pinstate);
		  }
		}
		else {
			accview.debitFailure(account,BankRep.getInstance().pinstate);
		}
	}

	public void getTransactions(List<AccountHolder> account) {
		if(BankRep.getInstance().transactionAmount.isEmpty()) {
			accview.transactionNotFound(account);
			return;
		}
		accview.foundTransaction(account,BankRep.getInstance().transactionType,BankRep.getInstance().transactionAmount,BankRep.getInstance().currentBal);
	}

}
