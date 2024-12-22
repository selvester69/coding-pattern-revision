package com.design.behavioural.strategy.withstrategy;

import com.design.behavioural.strategy.withstrategy.st.NormalDriveStrategy;

public class NormalDriveVehicle extends Vehicle {

	public NormalDriveVehicle() {
		super(new NormalDriveStrategy());
	}

}
