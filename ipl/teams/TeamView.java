package com.ipl.teams;

import java.util.List;
import java.util.Scanner;

import com.ipl.login.LoginView;

public class TeamView {

	private TeamModel teammodel;
	private Scanner scan = new Scanner(System.in);
	
	public TeamView() {
		teammodel=new TeamModel(this);
	}
	
	public void teamPage() {
		System.out.println("\n1.CSK\n2.RCB\n3.MI\n4.KKR\n5.SRH\n6.Punjab\n7.RR\n8.DC\n9.Exit");
		System.out.println("You can find the players of their respective teams.");
		System.out.println("Please select team to see players:");
		int opt=scan.nextInt();
		if(opt<9 && opt>0)
		   teammodel.getPlayers(opt);
		else if(opt==9) {
			System.out.println("You are exitted from the team page.");
			LoginView ref=new LoginView();
			ref.options();
		}
		else {
			System.out.println("Please Enter valid option");
			teamPage();
		}
	}

	public void foundPlayers(List<String> players) {
		for(int i=0;i<players.size();i++) {
			System.out.println((i+1)+"."+players.get(i));
		}
		System.out.println();
		System.out.println("Returning to the team page...!");
		teamPage();
	}
}
