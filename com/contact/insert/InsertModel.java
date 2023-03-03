package com.contact.insert;

import com.repository.ContactRep;

public class InsertModel {
   private InsertView insertview;
	
	public InsertModel(InsertView insertview) {
		this.insertview=insertview;
	}

	public void insertContact(String name, long phoneNo, String address, String fav) {
		ContactRep.getInstance().insertContact(name,phoneNo,address,fav);
		insertview.insertSuccess();
	}
}
