package com.train.repo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.train.dto.Passenger;
import com.train.dto.Train;

public class TrainBookingDetailRepository {

	private static TrainBookingDetailRepository repInstance;
	public Map<Integer, Train> trainDetails = new HashMap<>();
	private Train train;
	public boolean flag=true;
	
	Queue<Integer> waitingList = new LinkedList<>();
    Queue<Integer> racList =  new LinkedList<>();
    List<Integer> bookedTicketList =  new ArrayList<>();

    Map<Integer, Passenger> passengers = new HashMap<>();
    
    private TrainBookingDetailRepository() {

	}

	public static TrainBookingDetailRepository getInstance() {
		if (repInstance == null) {
			repInstance = new TrainBookingDetailRepository();
			repInstance.trainDetails();
			
		}
		return repInstance;
	}
	
	public void trainDetails() {
		train=new Train(01,"tenkasi","chennai","28/02/23",45,250,320);
		trainDetails.put(01, train);
		train = new Train(02,"tenkasi","madurai","01/03/23",45,75,120);
		trainDetails.put(02, train);
		train=new Train(03,"tenkasi","tirunelveli","28/02/23",45,40,60);
		trainDetails.put(03, train);
		train=new Train(04,"tenkasi","chennai","03/03/23",45,260,340);
		trainDetails.put(04, train);
	}
	
	public List<Train> getTrains(String source, String destination, String date) {

		List<Train> trainsList = new ArrayList<>();
		for (Map.Entry<Integer, Train> entry : trainDetails.entrySet()) {

			if (entry.getValue().getSource().equalsIgnoreCase(source) && entry.getValue().getDestination().equalsIgnoreCase(destination)
					&& entry.getValue().getDate().equalsIgnoreCase(date)) {

				trainsList.add(entry.getValue());
			}
		}
		return trainsList;
	}
	
	
	public List<String> bookTickets(int trainId,Passenger passenger,int numOfTickets) {
		Map<Integer,Train>traintoBook=new HashMap<>();
		List<String> result=new ArrayList<>();
		int amount=trainDetails.get(trainId).getAmount()*numOfTickets;
		if(trainDetails.containsKey(trainId)) {
			Train train1=new Train(trainId);
			traintoBook.put(trainId, train1);
		}
		if(traintoBook.get(trainId).getWaitingList() == 0) {
			
            return result;
		}
		if((passenger.getBerthpreference().equalsIgnoreCase("U") && traintoBook.get(trainId).getUpperSeats()>0)||
			(passenger.getBerthpreference().equalsIgnoreCase("M") && traintoBook.get(trainId).getMiddleSeats()>0)||
			(passenger.getBerthpreference().equalsIgnoreCase("L") && traintoBook.get(trainId).getLowerSeats()>0)) {
			
			
			if(passenger.getBerthpreference().equalsIgnoreCase("L")) {
				
				ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getLowerBerthsPositions().get(0),"L");
				traintoBook.get(trainId).getLowerBerthsPositions().remove(0);
				traintoBook.get(trainId).setLowerSeats(traintoBook.get(trainId).getLowerSeats()-1);
				result.add("lower");
				return result;
			}
			
			else if(passenger.getBerthpreference().equalsIgnoreCase("M")) {
				
				ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getMiddleBerthsPositions().get(0),"M");
				traintoBook.get(trainId).getMiddleBerthsPositions().remove(0);
				traintoBook.get(trainId).setMiddleSeats(traintoBook.get(trainId).getMiddleSeats()-1);
				result.add("middle");
				return result;
			}
			
			else if(passenger.getBerthpreference().equalsIgnoreCase("U")) {
				
				ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getMiddleBerthsPositions().get(0),"U");
				traintoBook.get(trainId).getUpperBerthsPositions().remove(0);
				traintoBook.get(trainId).setUpperSeats(traintoBook.get(trainId).getUpperSeats()-1);
				result.add("upper");
				return result;
				
			}
			
			else if(traintoBook.get(trainId).getLowerSeats() > 0)
	        {
	            
	            ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getLowerBerthsPositions().get(0),"L");
				traintoBook.get(trainId).getLowerBerthsPositions().remove(0);
				traintoBook.get(trainId).setLowerSeats(traintoBook.get(trainId).getLowerSeats()-1);
				result.add("lower");
				return result;
	        }
			else if(traintoBook.get(trainId).getMiddleSeats() > 0)
	        {
	            
	            ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getMiddleBerthsPositions().get(0),"L");
				traintoBook.get(trainId).getMiddleBerthsPositions().remove(0);
				traintoBook.get(trainId).setMiddleSeats(traintoBook.get(trainId).getMiddleSeats()-1);
				result.add("middle");
				return result;
	        }
			else if(traintoBook.get(trainId).getUpperSeats() > 0)
	        {
	            
	            ticketBookingatPreferredberth(passenger,traintoBook.get(trainId).getUpperBerthsPositions().get(0),"L");
				traintoBook.get(trainId).getUpperBerthsPositions().remove(0);
				traintoBook.get(trainId).setUpperSeats(traintoBook.get(trainId).getUpperSeats()-1);
				result.add("upper");
				return result;
	        }
			else if(traintoBook.get(trainId).getRac()>0) {
				
	            bookToRAC(passenger,(traintoBook.get(trainId).getRacPositions().get(0)),"RAC" );
	            traintoBook.get(trainId).getRacPositions().remove(0);
	            traintoBook.get(trainId).setRac(traintoBook.get(trainId).getRac()-1);
	            result.add("rac");
				return result;
			}
			else{
				
				bookToWaitingList(passenger,(traintoBook.get(trainId).getWaitingListPositions().get(0)),"WL");
				traintoBook.get(trainId).getWaitingListPositions().remove(0);
	            traintoBook.get(trainId).setWaitingList(traintoBook.get(trainId).getWaitingList());
	            result.add("waitingList");
				return result;
			}
			
		}
		return result;
		
	}

    private void bookToWaitingList(Passenger passenger, int waitList, String allotBerth) {
    	passenger.setSeatNumber(waitList);
        passenger.setAllottedBerth(allotBerth);
        
        passengers.put(passenger.getPassId(),passenger);
        
        bookedTicketList.add(passenger.getPassId());
        
}

	private void bookToRAC(Passenger passenger, int racPos, String allotBerth) {

    	passenger.setSeatNumber(racPos);
        passenger.setAllottedBerth(allotBerth);
        
        passengers.put(passenger.getPassId(),passenger);
        
        bookedTicketList.add(passenger.getPassId());
        
}

	private void ticketBookingatPreferredberth(Passenger passenger, int berthPos, String allotBerth) {
            
            passenger.setSeatNumber(berthPos);
            passenger.setAllottedBerth(allotBerth);
            
            passengers.put(passenger.getPassId(),passenger);
            
            bookedTicketList.add(passenger.getPassId());
            
        }
	public List<Integer> showticketsForTrain(int trainId){
		Map<Integer,Train>tickettoShow=new HashMap<>();
		List<Integer> result=new ArrayList<>();
		if(trainDetails.containsKey(trainId)) {
			Train trainticket=new Train(trainId);
			tickettoShow.put(trainId, trainticket);
		}
		
			result.add(tickettoShow.get(trainId).getLowerSeats());
			result.add(tickettoShow.get(trainId).getMiddleSeats());
			result.add(tickettoShow.get(trainId).getUpperSeats());
		return result;
	}

	public List<Train> showAllTrains() {
		List<Train> alltrainsList = new ArrayList<>();
		for (Map.Entry<Integer, Train> entry : trainDetails.entrySet()) {
				alltrainsList.add(entry.getValue());
			}
		return alltrainsList;
	}
	
	
	
	public void cancelTicket(int passengerId,int trainId)
    {
        
        Passenger p = passengers.get(passengerId);
        if(p!=null) {
        	passengers.remove(Integer.valueOf(passengerId));
            
            bookedTicketList.remove(Integer.valueOf(passengerId));

            int positionBooked = p.getSeatNumber();
            flag = false;

            if(p.getAllottedBerth().equals("L")) 
            { 
            	trainDetails.get(trainId).setLowerSeats(trainDetails.get(trainId).getLowerSeats()+1);
                trainDetails.get(trainId).getLowerBerthsPositions().add(positionBooked);
            }
            else if(p.getAllottedBerth().equals("M"))
            { 
            	trainDetails.get(trainId).setMiddleSeats(trainDetails.get(trainId).getMiddleSeats()+1);
                trainDetails.get(trainId).getMiddleBerthsPositions().add(positionBooked);
            }
            else if(p.getAllottedBerth().equals("U"))
            { 
            	trainDetails.get(trainId).setUpperSeats(trainDetails.get(trainId).getUpperSeats()+1);
                trainDetails.get(trainId).getUpperBerthsPositions().add(positionBooked);
            }

        }
    }
    
	public boolean bookThakkalTicket(int trainId,Passenger p,int numOfTickets) {
		int amount=trainDetails.get(trainId).getThakkalAmount()*numOfTickets;
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yy");
		String currentDate=LocalDateTime.now().format(formatter);
		char c=trainDetails.get(trainId).getDate().charAt(1);
		char s=trainDetails.get(trainId).getDate().charAt(4);
		
		if(Integer.valueOf(c)==(int)currentDate.charAt(1)+1  &&  Integer.valueOf(s)==(int)currentDate.charAt(4)) {
			trainDetails.get(trainId).getThakkalSeats().remove(0);
			trainDetails.get(trainId).setThakkal(trainDetails.get(trainId).getThakkal()+1);
			return true;
		}
		else {
			return false;
		}
		
	}

	public void addTrain(int trainId, String source, String destination, String date, int numOfTickets, int amount,
			int thakkalamount) {
		train=new Train(trainId,source,destination,date,numOfTickets,amount,thakkalamount);
		trainDetails.put(trainId, train);
	}

	public void removeTrain(int trainId) {
		if(trainDetails.containsKey(trainId)) {
			trainDetails.remove(trainId);
			flag=false;
		}
	}
}
