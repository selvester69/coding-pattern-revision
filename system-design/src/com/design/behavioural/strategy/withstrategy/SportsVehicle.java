package com.design.behavioural.strategy.withstrategy;

import com.design.behavioural.strategy.withstrategy.st.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

	public SportsVehicle() {
		super(new SportsDriveStrategy());
	}

}
