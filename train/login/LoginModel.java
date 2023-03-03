package com.train.login;

public class LoginModel {

private LoginView loginview;
	
	public LoginModel(LoginView logincontroller) {
		this.loginview=logincontroller;
	}
	public void checkIsAdmin(String adminName, String pass) {
		if(adminName.equals("shanmugavel") &&  pass.equals("selvam@20")) {
				loginview.adminSuccess(adminName);
			
		}
		else {
			loginview.adminLoginFailure();
		}
	}
	
	public void checkIsPassenger(String Name,String password) {
		if(Name.isEmpty()) {
			System.out.println("Please Enter the valid Passanger Name");
		}
		if(password.length()<8) {
			loginview.passengerFailure(Name,password);
		}
		
		loginview.passengerSuccess(Name,password);
	}
	
}
