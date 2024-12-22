package com.design.creational.abstractFactory.factory;

import com.design.creational.abstractFactory.BMWVehicle;
import com.design.creational.abstractFactory.Vehicle;

public class LuxuryVehicleFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle() {
		return new BMWVehicle();
//		return new MercedesVehicle();
	}

}
