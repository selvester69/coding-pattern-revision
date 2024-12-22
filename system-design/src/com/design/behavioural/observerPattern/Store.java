package com.design.behavioural.observerPattern;

import com.design.behavioural.observerPattern.observable.IphoneObservableImpl;
import com.design.behavioural.observerPattern.observable.StockObservable;
import com.design.behavioural.observerPattern.observer.EmailAlertObserverImpl;
import com.design.behavioural.observerPattern.observer.MobileAlertObserver;
import com.design.behavioural.observerPattern.observer.NotificationAlertObserver;

public class Store {
	public static void main(String[] args) {
		StockObservable iphone = new IphoneObservableImpl();
		
		NotificationAlertObserver o1 = new EmailAlertObserverImpl("abc@xyz.com", iphone);
		NotificationAlertObserver o2 = new EmailAlertObserverImpl("google.com", iphone);
		NotificationAlertObserver o3= new MobileAlertObserver("userAbhi", iphone);
		
		iphone.add(o3);
		iphone.add(o2);
		iphone.add(o1);
		
		iphone.setStockCount(10);
	}

}
