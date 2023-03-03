package com.ipl.login;

import java.util.Scanner;

import com.ipl.fixtures.FixtureView;
import com.ipl.play.PlayView;
import com.ipl.pointstable.PointsTableView;
import com.ipl.teams.TeamView;

public class LoginView {

	private LoginModel loginmodel;
	private Scanner scan= new Scanner(System.in);
	
	public LoginView() {
		loginmodel=new LoginModel(this);
	}

	public static void main(String[] args) {
		LoginView reference=new LoginView();
		reference.mainPage();
	}

	public void mainPage() {
		System.out.println("\n!---Welcome to 2023--IPL Tournament Official Website---!");
		System.out.println("Enter your Name:");
		String name=scan.next();
		System.out.println("Enter your password:");
		String password=scan.next();
		
		if(password.length()>=8) {
			options();
		}
		else {
		   System.out.println("Please enter valid password...!");
		   mainPage();
		}
		
	}
	public void options() {
		System.out.println("\n1.Teams\n2.Fixtures\n3.Points Table\n4.Play and win Trophy\n5.Exit");
		System.out.println();
		System.out.println("Please enter option:");
		int opt=scan.nextInt();
		if(opt==1) {
			TeamView linktoTeam=new TeamView();
			linktoTeam.teamPage();
		}
		else if(opt==2) {
			FixtureView  linktofix = new FixtureView();
			linktofix.fixtures();
		}
		else  if(opt==3) {
			PointsTableView linktopoint =new PointsTableView();
			linktopoint.points();
		}
		else if(opt==4) {
			PlayView linktoPlay =new PlayView();
			linktoPlay.playGame();
		}
		else {
			System.out.println("---You are exitted from the website--->");
			System.out.println("Thank you<---Come again<---");
		}
	}
}
