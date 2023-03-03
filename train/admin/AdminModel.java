package com.train.admin;

import java.util.List;

import com.train.dto.Train;
import com.train.repo.TrainBookingDetailRepository;

public class AdminModel {

private AdminView admincontroller;
	
	public AdminModel(AdminView admincontroller) {
		this.admincontroller=admincontroller;
	}

	public void showAllTrains() {
		List<Train> allTrains = TrainBookingDetailRepository.getInstance().showAllTrains();
		admincontroller.allTrainsList(allTrains);
	}

	public void addTrain(int trainId, String source, String destination, String date, int numOfTickets, int amount,
			int thakkalamount) {
		TrainBookingDetailRepository.getInstance().addTrain(trainId,source,destination,date,numOfTickets,amount,thakkalamount);
		admincontroller.addTrainSuccess();
	}

	public void removeTrain(int trainId) {
		TrainBookingDetailRepository.getInstance().removeTrain(trainId);
		if(!TrainBookingDetailRepository.getInstance().flag) {
			admincontroller.removeTrainSuccess();

		}
		else {
			admincontroller.removeTrainFailure();
		}
	}
}
