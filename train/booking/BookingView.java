package com.train.booking;

import java.util.Scanner;

import com.train.dto.Passenger;
import com.train.passenger.PassengerView;

public class BookingView {

	private BookingModel bookmodel;
	private Scanner scan=new Scanner(System.in);
	
	public BookingView() {
		this.bookmodel=new BookingModel(this);
	}

	public void bookTicket(int trainId) {
		System.out.println("\n1.Tickets\n2.thakkal tickets\n3.Exit");
		System.out.println("Enter the option: ");
		int opt=scan.nextInt();
		if(opt==1) {
			System.out.println("Enter no of tickets: ");
			int numOfTickets=scan.nextInt();
			for(int i=1;i<=numOfTickets;i++) {
				System.out.println("Enter passenger Name:");
				String pName=scan.next();
				System.out.println("Enter the age:");
				int age=scan.nextInt();
				System.out.println("Enter the preferred berth<u/m/l>:");
				String berth=scan.next();
				Passenger passenger=new  Passenger(pName,age,berth);
				bookmodel.bookTicket(trainId,passenger,numOfTickets);
			}
			PassengerView ref=new PassengerView();
			ref.main();
		}
		else if(opt==2) {
			System.out.println("You are entered into the thakkal tickets...!");
			System.out.println("Enter no of tickets: ");
			int numOfTickets=scan.nextInt();
			for(int i=1;i<=numOfTickets;i++) {
				System.out.println("Enter passenger Name:");
				String pName=scan.next();
				System.out.println("Enter the age:");
				int age=scan.nextInt();
				Passenger passenger=new  Passenger(pName,age);
				bookmodel.bookThakkalTicket(trainId,passenger,numOfTickets);
			}
			PassengerView ref=new PassengerView();
			ref.main();
			
		}
		else {
			PassengerView ref=new PassengerView();
			ref.main();
		}
	}

	public void bookFailed() {
		System.out.println("---No Tickets Available---");
	}

	public void bookSuccess(String result) {
		if(result.equalsIgnoreCase("lower")) {
			System.out.println("Lower birth allocated ...!");
			System.out.println("<<---Booked successfully--->>");
		}
		else if(result.equalsIgnoreCase("middle")) {
			System.out.println("Middle birth allocated ...!");
			System.out.println("<<---Booked successfully--->>");
		}
		else if(result.equalsIgnoreCase("upper")) {
			System.out.println("upper birth allocated ...!");
			System.out.println("<<---Booked successfully--->>");
		}
		else if(result.equalsIgnoreCase("rac")) {
			System.out.println("rac birth allocated ...!");
			System.out.println("<<---Booked successfully--->>");
		}
		else if(result.equalsIgnoreCase("waitingList")) {
			System.out.println("Waiting list allocated ...!");
			System.out.println("<<---Booked successfully--->>");
		}
	}

	public void thakkalBookedSuccess() {
		System.out.println("Thakkal ticket booked successfully");
	}

	public void thakkalBookedFailure() {
		System.out.println("Thakkal tickets are not opened at this time...!");
		PassengerView ref=new PassengerView();
		ref.main();
	}
	
}
