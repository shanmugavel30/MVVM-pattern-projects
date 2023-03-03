package com.train.admin;

import java.util.List;
import java.util.Scanner;

import com.train.dto.Train;
import com.train.login.LoginView;


public class AdminView {

	private  AdminModel adminmodel;
	private Scanner scan =new Scanner(System.in);
	
	public AdminView() {
		adminmodel=new AdminModel(this);
	}
	
	public void adminChoices() {
		System.out.println("\nWelcome to admin page...!");
		System.out.println("\n1.show all trains\n2.Add train\n3.Remove train\n4.Exit");
		System.out.println("Enter the option: ");
		int opt=scan.nextInt();
		
		if(opt==1) {
			adminmodel.showAllTrains();
		}
		else if(opt==2) {
			System.out.println("Enter the train Id: ");
			int trainId=scan.nextInt();
			System.out.println("Enter the  source: ");
			String source=scan.next();
			System.out.println("Enter the destination: ");
			String destination=scan.next();
			System.out.println("Enter the date:");
			String date=scan.next();
			System.out.println("Enter the number of tickets: ");
			int numOfTickets=scan.nextInt();
			System.out.println("Enter the amount to tickets: ");
			int amount=scan.nextInt();
			System.out.println("Enter the thakkal ticket amount :");
			int thakkalamount=scan.nextInt();
			adminmodel.addTrain(trainId,source,destination,date,numOfTickets,amount,thakkalamount);
		}
		else if(opt==3) {
			System.out.println("Enter the trainId to  remove: ");
			int trainId=scan.nextInt();
			adminmodel.removeTrain(trainId);
			
		}
		else {
			System.out.println("Returning to thr home page---#");
			LoginView ref=new LoginView();
			ref.loginWeb();
		}
	}

	public void allTrainsList(List<Train> allTrains) {
		System.out.printf("\n %10s %13s %13s %13s %13s %13s %13s %13s %13s %13s","TrainId","Source","Destination","Date","NoOfSheets","UpperSeats","MiddleSeats","LowerSeats","RAC","WaitingList");
		for(int i=0;i<allTrains.size();i++) {
			System.out.printf("\n %10s  %13s %13s %13s %13s %12s %12s %12s %13s %13s",allTrains.get(i).getTrainId(),allTrains.get(i).getSource(),allTrains.get(i).getDestination(),allTrains.get(i).getDate(),allTrains.get(i).getNoOfTicket(),
					allTrains.get(i).getUpperSeats(),allTrains.get(i).getMiddleSeats(),allTrains.get(i).getLowerSeats(),allTrains.get(i).getRac(),allTrains.get(i).getWaitingList());
		}
		adminChoices();
	}

	public void addTrainSuccess() {
		System.out.println("Train added successfully...!");
		adminChoices();
	}

	public void removeTrainSuccess() {
		System.out.println("Train removed successfully--->");
		adminChoices();
	}

	public void removeTrainFailure() {
		System.out.println("There are no trains to this trainId...!");
		System.out.println("Please enter valid trainId");
		adminChoices();
	}
}
