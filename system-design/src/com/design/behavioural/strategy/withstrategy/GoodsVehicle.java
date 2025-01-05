package com.design.behavioural.strategy.withstrategy;

import com.design.behavioural.strategy.withstrategy.st.XYZDriveStrategy;

public class GoodsVehicle extends Vehicle {

	public GoodsVehicle() {
		super(new XYZDriveStrategy());
	}
}
