package com.train.cancel;

import java.util.Scanner;

import com.train.passenger.PassengerView;


public class CancelView {

	private CancelModel cancelmodel;
	private Scanner scan = new Scanner(System.in);
	
	public CancelView() {
		cancelmodel=new CancelModel(this);
	}
	
	public void cancelTicket() {
		System.out.println("Enter the trainId:");
		int trainId=scan.nextInt();
		System.out.println("Enter the PassengerId:");
		int passengerId=scan.nextInt();
		
		cancelmodel.cancelTicket(passengerId,trainId);
	}

	public void cancelTicketSuccess() {
		System.out.println("Your ticket cancelled successfully...!");
		PassengerView ref=new PassengerView();
		ref.main();
	}

	public void cancelTicketfailure() {
		System.out.println("Your ticket cancellation failed...!");
		PassengerView ref=new PassengerView();
		ref.main();
	}
}
