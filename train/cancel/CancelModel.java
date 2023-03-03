package com.train.cancel;

import com.train.repo.TrainBookingDetailRepository;

public class CancelModel {

    private CancelView cancelcontroller;
	
	public CancelModel(CancelView cancelcontroller) {
		this.cancelcontroller=cancelcontroller;
	}

	public void cancelTicket(int passengerId, int trainId) {
		TrainBookingDetailRepository.getInstance().cancelTicket(passengerId, trainId);
		if(!TrainBookingDetailRepository.getInstance().flag) {
			cancelcontroller.cancelTicketSuccess();
		}
		else {
			cancelcontroller.cancelTicketfailure();
		}
	}

}
