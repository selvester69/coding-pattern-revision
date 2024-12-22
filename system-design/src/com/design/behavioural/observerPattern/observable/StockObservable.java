package com.design.behavioural.observerPattern.observable;

import com.design.behavioural.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
	public void add(NotificationAlertObserver ob);
	
	public void remove(NotificationAlertObserver ob);
	
	public void notifySubscriber();
	
	public void setStockCount(int newStock);
	public int getStockCount();
}
