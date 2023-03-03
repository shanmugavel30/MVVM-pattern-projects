package com.contact.delete;

import com.repository.ContactRep;

public class DeleteModel {

private DeleteView delview;
	
	public DeleteModel(DeleteView delview) {
		this.delview =  delview;
	}

	public void deleteContact(String name) {
		boolean flag=ContactRep.getInstance().deleteContact(name);
		if(!flag) {
			delview.deleteContactFailed();
		}
		else {
			delview.deleteContactSuccess();
		}
	}

	public void deleteAllContact() {
		ContactRep.getInstance().deleteAllContact();
		delview.deleteAllContactSuccess();
	}
}
