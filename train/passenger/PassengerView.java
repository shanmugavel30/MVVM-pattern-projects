package com.train.passenger;

import java.util.List;
import java.util.Scanner;

import com.train.booking.BookingView;
import com.train.cancel.CancelView;
import com.train.dto.Train;

public class PassengerView {

	private PassengerModel passmodel;
	private Scanner scan=new Scanner(System.in);
	public PassengerView() {
		this.passmodel=new PassengerModel(this);
		
	}
	public void main() {
		System.out.println("1.Book\n2.showTrains\n3.Cancel\n4.Exit");
		System.out.println("Enter the option:");
		int opt=scan.nextInt();
		if(opt==1) {
			searchTrains();
		}
		else if(opt==2) {
			passmodel.showTrains();
		}
		else if(opt==3) {
			CancelView ref=new CancelView();
			ref.cancelTicket();
		}
		else {
			System.out.println("You are exitted...!");
			System.out.println("Don't forget to come again...<---Thank you");
		}
	}
	
	public void searchTrains() {
		System.out.println("Enter the Source:");
		String source=scan.next();
		System.out.println("Enter the Destination:");
		String destination=scan.next();
		System.out.println("Enter the Date:ex(Date/month/year)");
		String Date=scan.next();
		passmodel.searchForTrains(source,destination,Date);
	}

	public void trainNotFound() {
		System.out.println("No trains available at  the time...");
		main();
	}

	public void trainFound(List<Train> trainsList) {
		System.out.printf("\n %10s %13s %13s %13s %13s %13s %13s %13s %13s %13s","TrainId","Source","Destination","Date","NoOfSheets","UpperSeats","MiddleSeats","LowerSeats","RAC","WaitingList");
		for(int i=0;i<trainsList.size();i++) {
			System.out.printf("\n %10s  %13s %13s %13s %13s %12s %12s %12s %13s %13s",trainsList.get(i).getTrainId(),trainsList.get(i).getSource(),trainsList.get(i).getDestination(),trainsList.get(i).getDate(),trainsList.get(i).getNoOfTicket(),
					trainsList.get(i).getUpperSeats(),trainsList.get(i).getMiddleSeats(),trainsList.get(i).getLowerSeats(),trainsList.get(i).getRac(),trainsList.get(i).getWaitingList());
		}
		System.out.println();
		System.out.println("");
		System.out.println("Enter TrainId:");
		int trainId=scan.nextInt();
		BookingView obj=new BookingView();
		obj.bookTicket(trainId);
	}
	public void allTrainsList(List<Train> allTrains) {
		System.out.printf("\n %10s %13s %13s %13s %13s %13s %13s %13s %13s %13s","TrainId","Source","Destination","Date","NoOfSheets","UpperSeats","MiddleSeats","LowerSeats","RAC","WaitingList");
		for(int i=0;i<allTrains.size();i++) {
			System.out.printf("\n %10s  %13s %13s %13s %13s %12s %12s %12s %13s %13s",allTrains.get(i).getTrainId(),allTrains.get(i).getSource(),allTrains.get(i).getDestination(),allTrains.get(i).getDate(),allTrains.get(i).getNoOfTicket(),
					allTrains.get(i).getUpperSeats(),allTrains.get(i).getMiddleSeats(),allTrains.get(i).getLowerSeats(),allTrains.get(i).getRac(),allTrains.get(i).getWaitingList());
		}
		System.out.println();
		main();
	}
}
