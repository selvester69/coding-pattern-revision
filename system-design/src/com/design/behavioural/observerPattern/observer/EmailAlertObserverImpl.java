package com.design.behavioural.observerPattern.observer;

import com.design.behavioural.observerPattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
	String email;
	StockObservable observable;
	
	public EmailAlertObserverImpl(String email, StockObservable observable) {
		this.email = email;
		this.observable = observable;
	}

	@Override
	public void update() {
		sendMail(this.email,"product is available in the stock");
	}

	private void sendMail(String emailId, String string) {
		System.out.println("mail sent to:" + emailId);
		//send mail to actual server
	}

}
