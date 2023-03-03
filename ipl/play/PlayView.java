package com.ipl.play;

import java.util.List;
import java.util.Scanner;

import com.ipl.login.LoginView;

public class PlayView {

	private PlayModel playmodel;
	private Scanner scan=new Scanner(System.in);
	
	public PlayView() {
		playmodel = new PlayModel(this);
	}
	
	public void playGame() {
		System.out.println("Here we can see remaining non-playable matches...!");
		String[] team = {"CSKvsRR","RCBvsSRH","KKRvsPunjab","MIvsDC"};
		int i = 0;
		while(i<team.length) {
			System.out.println("<---"+team[i]+"--->");
			System.out.println("Enter the winner team:");
			String winningTeam = scan.next();
			String[] arr=team[i].split("vs");
			if(arr[0].equalsIgnoreCase(winningTeam) || arr[1].equalsIgnoreCase(winningTeam)) {
				playmodel.changePointsTable(winningTeam);
			    i++;
			}
			    
			else {
				System.out.println("Enter valid team please...!");
				
			}

		}
		playmodel.changePosition();
		playmodel.getsemiTeams();
		
		LoginView ref=new LoginView();
		ref.options();
	}

	public void foundSemiteams(List<String> semiteams) {
		System.out.println("League completed...!");
		System.out.println("Play semi final");
		int i=0;
		String[] finalist = new String[(semiteams.size()/2)];
		while(i<(semiteams.size()/2)) {
			System.out.println();
			System.out.println(semiteams.get(i)+"<---vs--->"+semiteams.get(i+2));
			System.out.println("Enter the winner teams: ");
			String win=scan.next();
			if(semiteams.get(i).equalsIgnoreCase(win) || semiteams.get(i+2).equalsIgnoreCase(win)) {
				finalist[i]=win;
				i++;
			}
			else {
				System.out.println("Please  enter valid team...!");
			}
			
		}
		playFinal(finalist);
	}

	private void playFinal(String[] finalist) {
		System.out.println("Play Final---->Trophy!!!");
		System.out.println();
		while(true) {
		   System.out.println(finalist[0]+"<----vs-->"+finalist[1]);
		
		   System.out.println("Enter the winner teams: ");
		   String finalwinner=scan.next();
		   if(finalist[0].equalsIgnoreCase(finalwinner) || finalist[1].equalsIgnoreCase(finalwinner)) {
			   System.out.println(finalwinner+" Won the IPL 2023 Trophy...!");
			   break;
		   }
		}
		
	}
}
