package com.ipl.play;

import java.util.ArrayList;
import java.util.List;

import com.ipl.repo.IplRep;

public class PlayModel {
    private  PlayView playview;
	
	public PlayModel(PlayView playview) {
		this.playview= playview;
	}

	public void changePointsTable(String win1) {
		IplRep.getInstance().changePointsTable(win1);
	}
	public void changePosition() {
		IplRep.getInstance().changePosition();
	}

	public void getsemiTeams() {
		List<String> semiteams=new ArrayList<>();
		semiteams=IplRep.getInstance().getsemiTeams();
		playview.foundSemiteams(semiteams);
	}
}
