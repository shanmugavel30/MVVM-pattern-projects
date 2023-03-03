package com.train.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Train {

	private int trainId;
	private String Source;
	private String Destination;
	private String Date;
	private int noOfTicket;
	private int upperSeats;
	private int middleSeats;
	private int lowerSeats;
	private int rac;
	private int waitingList;
	private List<Integer> lowerBerthsPositions; 
    private List<Integer> middleBerthsPositions;
    private List<Integer> upperBerthsPositions; 
    private List<Integer> racPositions ;
    private List<Integer> waitingListPositions ;
    private List<Integer> thakkalSeats;
    private int thakkal;
    private int thakkalAmount;
    private int amount;

	
	public Train(int trainId,String Source,String Destination,String Date,int noOfTicket,int amount,int thakkalAmount) {
		this.setTrainId(trainId);
		this.setSource(Source);
		this.setDestination(Destination);
		this.setDate(Date); 
		this.noOfTicket=noOfTicket;
		this.amount=amount;
		this.thakkalAmount=thakkalAmount;
		upperSeats=15;
		middleSeats=15;
		lowerSeats=15;
		rac=10;
		waitingList=5;
		thakkal=15;
		lowerBerthsPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		middleBerthsPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		upperBerthsPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		racPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		thakkalSeats=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
			
	}

	public Train(int trainId) {
		this.setTrainId(trainId);
		this.setSource(Source);
		this.setDestination(Destination);
		this.setDate(Date); 
		upperSeats=15;
		middleSeats=15;
		lowerSeats=15;
		rac=10;
		waitingList=5;
		lowerBerthsPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		middleBerthsPositions= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		upperBerthsPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
		racPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		waitingListPositions = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}

	public int getUpperSeats() {
		return upperSeats;
	}

	public void setUpperSeats(int upperSeats) {
		this.upperSeats = upperSeats;
	}

	public int getMiddleSeats() {
		return middleSeats;
	}

	public void setMiddleSeats(int middleSeats) {
		this.middleSeats = middleSeats;
	}

	public int getLowerSeats() {
		return lowerSeats;
	}

	public void setLowerSeats(int lowerSeats) {
		this.lowerSeats = lowerSeats;
	}

	public int getRac() {
		return rac;
	}

	public void setRac(int rac) {
		this.rac = rac;
	}

	public int getWaitingList() {
		return waitingList;
	}

	public void setWaitingList(int waitingList) {
		this.waitingList = waitingList;
	}

	public List<Integer> getLowerBerthsPositions() {
		return lowerBerthsPositions;
	}

	public void setLowerBerthsPositions(List<Integer> lowerBerthsPositions) {
		this.lowerBerthsPositions = lowerBerthsPositions;
	}

	public List<Integer> getMiddleBerthsPositions() {
		return middleBerthsPositions;
	}

	public void setMiddleBerthsPositions(List<Integer> middleBerthsPositions) {
		this.middleBerthsPositions = middleBerthsPositions;
	}

	public List<Integer> getUpperBerthsPositions() {
		return upperBerthsPositions;
	}

	public void setUpperBerthsPositions(List<Integer> upperBerthsPositions) {
		this.upperBerthsPositions = upperBerthsPositions;
	}

	public List<Integer> getRacPositions() {
		return racPositions;
	}

	public void setRacPositions(List<Integer> racPositions) {
		this.racPositions = racPositions;
	}

	public List<Integer> getWaitingListPositions() {
		return waitingListPositions;
	}

	public void setWaitingListPositions(List<Integer> waitingListPositions) {
		this.waitingListPositions = waitingListPositions;
	}

	public int getThakkal() {
		return thakkal;
	}

	public void setThakkal(int thakkal) {
		this.thakkal = thakkal;
	}

	public List<Integer> getThakkalSeats() {
		return thakkalSeats;
	}

	public void setThakkalSeats(List<Integer> thakkalSeats) {
		this.thakkalSeats = thakkalSeats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getThakkalAmount() {
		return thakkalAmount;
	}

	public void setThakkalAmount(int thakkalAmount) {
		this.thakkalAmount = thakkalAmount;
	}
}
