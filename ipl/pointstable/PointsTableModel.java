package com.ipl.pointstable;

import java.util.ArrayList;
import java.util.List;

import com.ipl.dto.Points;
import com.ipl.repo.IplRep;

public class PointsTableModel {

    private PointsTableView pointsview;
	
	public PointsTableModel(PointsTableView pointsview) {
		this.pointsview= pointsview;
	}

	public void getPointsTable() {
		List<Points> currentPointsTable= new ArrayList<>();
		currentPointsTable=IplRep.getInstance().getPointsTable();
		pointsview.foundPointsTable(currentPointsTable);
	}
}
