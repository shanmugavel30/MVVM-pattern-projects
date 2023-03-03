package com.ipl.dto;

public class Points {

	private int position;
    private String team;
    private int points;
    private int noOfWonMatches;
    
    public Points(int position,String team,int points,int noOfWonMatches) {
   	 this.position=position;
   	 this.team=team;
   	 this.points=points;
   	 this.noOfWonMatches=noOfWonMatches;
    }

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNoOfWonMatches() {
		return noOfWonMatches;
	}

	public void setNoOfWonMatches(int noOfWonMatches) {
		this.noOfWonMatches = noOfWonMatches;
	}
}
