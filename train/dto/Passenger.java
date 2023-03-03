package com.train.dto;

public class Passenger {

	static int id=1;
	private String passengerName;
	private int age;
	private String berthpreference;
	private String allottedBerth;
	private int passId;
	private  int seatNumber;
	

	public Passenger(String passengerName, int age, String berthpreference) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		this.berthpreference = berthpreference;
		this.setPassId(id++);
		allottedBerth="";
		seatNumber=-1;
	}
	public Passenger(String passengerName, int age) {
		super();
		this.passengerName = passengerName;
		this.age = age;
		berthpreference = "thakkal";
		this.setPassId(id++);
		allottedBerth="";
		seatNumber=-1;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBerthpreference() {
		return berthpreference;
	}

	public void setBerthpreference(String berthpreference) {
		this.berthpreference = berthpreference;
	}

	public String getAllottedBerth() {
		return allottedBerth;
	}

	public void setAllottedBerth(String allottedBerth) {
		this.allottedBerth = allottedBerth;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}

}
