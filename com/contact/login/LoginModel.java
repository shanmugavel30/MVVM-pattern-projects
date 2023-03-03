package com.contact.login;


public class LoginModel {
     private LoginView loginview;
	
	public LoginModel(LoginView loginview) {
		this.loginview= loginview;
	}

	public void checkUser(String name, String password) {
		if(name.equalsIgnoreCase("shanmugavel") && password.equalsIgnoreCase("selvam@20")) {
			loginview.loginSuccessful();
		}
		else {
			loginview.loginFailed();
		}
	}

}
