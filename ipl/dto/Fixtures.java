package com.ipl.dto;

public class Fixtures {

	private int matchNo;
	private String team1;
	private String team2;
	private String date;
	private String winningTeam;
	
	public Fixtures(int matchNo,String team1,String team2,String date) {
		this.matchNo=matchNo;
		this.team1=team1;
		this.team2=team2;
		this.date=date;
		
	}
	public Fixtures(int matchNo,String team1,String team2,String date,String winningTeam) {
		this.matchNo=matchNo;
		this.team1=team1;
		this.team2=team2;
		this.date=date;
		this.setWinningTeam(winningTeam);
		
	}
	public int getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
}
