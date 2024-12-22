package com.design.creational.abstractFactory.factory;

import com.design.creational.abstractFactory.SwiftVehicle;
import com.design.creational.abstractFactory.Vehicle;

public class OdinaryVehicleFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle() {
		return new SwiftVehicle();
//		return new HyundaiVehicle();
	}

}
