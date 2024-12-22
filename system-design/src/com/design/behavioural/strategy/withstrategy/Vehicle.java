package com.design.behavioural.strategy.withstrategy;

import com.design.behavioural.strategy.withstrategy.st.DriveStrategy;

public class Vehicle {
	DriveStrategy obj;
	
	//constructor injection 
	public Vehicle(DriveStrategy obj) {
		this.obj = obj;
	}
	public void drive() {
		this.obj.drive();
	}

}
