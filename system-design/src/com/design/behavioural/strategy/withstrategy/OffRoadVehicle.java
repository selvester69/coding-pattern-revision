package com.design.behavioural.strategy.withstrategy;

import com.design.behavioural.strategy.withstrategy.st.XYZDriveStrategy;

public class OffRoadVehicle extends Vehicle {

	public OffRoadVehicle() {
		super(new XYZDriveStrategy());
	}
}
