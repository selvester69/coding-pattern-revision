package com.design.behavioural.observerPattern.observer;

import com.design.behavioural.observerPattern.observable.StockObservable;

public class MobileAlertObserver implements NotificationAlertObserver{
	
	String userName;
	StockObservable observable;
	
	public MobileAlertObserver(String userName, StockObservable observable) {
		super();
		this.userName = userName;
		this.observable = observable;
	}


	@Override
	public void update() {
		sendMessageToMobile(userName,"product available in stock");
	}


	private void sendMessageToMobile(String user, String string) {
		System.out.println("message sent to: "+user);
	}

}
