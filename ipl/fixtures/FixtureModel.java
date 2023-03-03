package com.ipl.fixtures;

import java.util.ArrayList;
import java.util.List;

import com.ipl.dto.Fixtures;
import com.ipl.repo.IplRep;

public class FixtureModel {

private FixtureView fixtureview;
	
	public FixtureModel(FixtureView fixtureview) {
		this.fixtureview =  fixtureview;
	}

	public void getFixtures() {
		List<Fixtures>allfixtures=new ArrayList<>();
		allfixtures=IplRep.getInstance().getFixtures();
		fixtureview.foundFixtures(allfixtures);
	}
}
