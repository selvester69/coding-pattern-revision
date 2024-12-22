package com.design.behavioural.observerPattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.design.behavioural.observerPattern.observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StockObservable {
	
	public List<NotificationAlertObserver> list = new ArrayList<>();
	int stockCount =0;
	
	@Override
	public void add(NotificationAlertObserver ob) {
		// TODO Auto-generated method stub
		list.add(ob);
	}

	@Override
	public void remove(NotificationAlertObserver ob) {
		// TODO Auto-generated method stub
		list.remove(ob);
	}

	@Override
	public void notifySubscriber() {
		// TODO Auto-generated method stub
		list.forEach(o-> {
			o.update();
		});
	}

	@Override
	public void setStockCount(int newStock) {
		// TODO Auto-generated method stub
		if(stockCount==0) {
			notifySubscriber();
		}
		stockCount+=newStock;
	}

	@Override
	public int getStockCount() {
		// TODO Auto-generated method stub
		return this.stockCount;
	}

}
