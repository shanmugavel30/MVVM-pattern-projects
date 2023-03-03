package com.train.booking;

import java.util.ArrayList;
import java.util.List;

import com.train.dto.Passenger;
import com.train.repo.TrainBookingDetailRepository;

public class BookingModel {

	private BookingView bookview;
	int count=0;
	
	public BookingModel(BookingView bookcontroller) {
		this.bookview=bookcontroller;
	}

	public void bookTicket(int trainId,Passenger passenger,int numOfTickets) {
		List<String> resultList=new ArrayList<>();
		resultList=TrainBookingDetailRepository.getInstance().bookTickets(trainId,passenger,numOfTickets);
		if(resultList.size()==0) {
			bookview.bookFailed();
		}
		else {
			bookview.bookSuccess(resultList.get(0));
		}
	}

	public void bookThakkalTicket(int trainId, Passenger passenger,int numOfTickets) {
		boolean result=TrainBookingDetailRepository.getInstance().bookThakkalTicket(trainId, passenger,numOfTickets);
		if(result) {
			bookview.thakkalBookedSuccess();
		}
		else {
			bookview.thakkalBookedFailure();
		}
	}
}
