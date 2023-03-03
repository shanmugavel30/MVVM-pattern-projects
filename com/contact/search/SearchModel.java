package com.contact.search;

import java.util.ArrayList;
import java.util.List;

import com.contact.dto.Contacts;
import com.repository.ContactRep;

public class SearchModel {

private SearchView searchview;
	
	public SearchModel(SearchView searchview) {
		this.searchview=searchview;
	}

	public void searchContact(String name) {
		List<Contacts> searchcontact =new ArrayList<>();
		searchcontact=ContactRep.getInstance().searchContact(name);
		if(!ContactRep.getInstance().flag) {
			searchview.searchFailed();
		}
		else {
			searchview.searchSuccess(searchcontact);
		}
		
	}

	public void searchContactByNum(long phoneNo) {
		List<Contacts> searchcontact =new ArrayList<>();
		String phoneno1=String.valueOf(phoneNo);
		searchcontact=ContactRep.getInstance().searchContact(phoneno1);
		if(!ContactRep.getInstance().flag) {
			searchview.searchFailed();
		}
		else {
			searchview.searchSuccess(searchcontact);
		}
	}
}
