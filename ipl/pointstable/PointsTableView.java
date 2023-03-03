package com.ipl.pointstable;

import java.util.List;

import com.ipl.dto.Points;
import com.ipl.login.LoginView;

public class PointsTableView {

private PointsTableModel pointsmodel;
	
	public PointsTableView() {
		pointsmodel = new PointsTableModel(this);
	}
	
	public void points() {
		pointsmodel.getPointsTable();
	}

	public void foundPointsTable(List<Points> currentPointsTable) {
        System.out.printf("%10s %10s %10s %10s","Position","Teams","Points","NumberOfMatchesWon");
		
		for(int i=0;i<currentPointsTable.size();i++) {
			System.out.printf("\n%10s %10s %10s %10s",currentPointsTable.get(i).getPosition(),currentPointsTable.get(i).getTeam(),
					currentPointsTable.get(i).getPoints(),currentPointsTable.get(i).getNoOfWonMatches());
		}
		System.out.println("\n Returning to the home page...!");
		LoginView ref=new LoginView();
		ref.options();
	}
}
