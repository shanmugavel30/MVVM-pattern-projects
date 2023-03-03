package com.contact.edit;

import com.repository.ContactRep;

public class EditModel {

	private EditView editview;

	public EditModel(EditView editview) {
		this.editview = editview;
	}

	public void editContactByName(String name, long phoneNo) {

		if (!ContactRep.getInstance().editContactByName(name, phoneNo)) {
			editview.editContactByNameFailed();
		} else {
			editview.editContactByNameSuccess();
		}
	}

	public void editContactByNum(long phoneNo, String name) {

		if (!ContactRep.getInstance().editContactByNum(phoneNo, name)) {
			editview.editContactByNumFailed();
		} else {
			editview.editContactByNumSuccess();
		}
	}
}
