package com.ipl.teams;

import java.util.ArrayList;
import java.util.List;
import com.ipl.repo.IplRep;

public class TeamModel {

    private TeamView teamview;
	
	public TeamModel(TeamView teamcontroller) {
		this.teamview=teamcontroller;
	}

	public void getPlayers(int opt) {
		List<String> players=new ArrayList<>();
		players=IplRep.getInstance().getPlayers(opt);
		teamview.foundPlayers(players);
	}
}
