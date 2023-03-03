package com.train.passenger;

import java.util.List;

import com.train.dto.Train;
import com.train.repo.TrainBookingDetailRepository;

public class PassengerModel {

    private PassengerView passview;
	
	public PassengerModel(PassengerView passcontroller) {
		this.passview=passcontroller;
	}

	public void searchForTrains(String source, String destination,String Date) {
		List<Train> trainsList = TrainBookingDetailRepository.getInstance().getTrains(source,destination,Date);
		if(trainsList.isEmpty()) {
			passview.trainNotFound();
		}
		else {
			passview.trainFound(trainsList);
		}
	}

	public void showTrains() {
		List<Train> allTrains = TrainBookingDetailRepository.getInstance().showAllTrains();
		passview.allTrainsList(allTrains);
	}
}
