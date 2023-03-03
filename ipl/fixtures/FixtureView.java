package com.ipl.fixtures;

import java.util.List;

import com.ipl.dto.Fixtures;
import com.ipl.login.LoginView;

public class FixtureView {

private FixtureModel fixturemodel;
	
	public FixtureView() {
		fixturemodel=new FixtureModel(this);
	}
	public void fixtures() {
		fixturemodel.getFixtures();
	}
	public void foundFixtures(List<Fixtures> allfixtures) {
		System.out.printf("%10s %10s %10s %10s %10s","Match Number","Team1","Team2","Date","Winning Team");
		
		for(int i=0;i<allfixtures.size();i++) {
			System.out.printf("\n%10s %10s %10s %10s %10s",allfixtures.get(i).getMatchNo(),allfixtures.get(i).getTeam1(),
					allfixtures.get(i).getTeam2(),allfixtures.get(i).getdate(),allfixtures.get(i).getWinningTeam());
		}
		System.out.println();
		System.out.println("\n Returning to the home page...!");
		LoginView ref=new LoginView();
		ref.options();
	}
}
