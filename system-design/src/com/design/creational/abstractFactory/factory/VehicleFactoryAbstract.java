package com.design.creational.abstractFactory.factory;

public class VehicleFactoryAbstract {

	VehicleFactory factory;

	public VehicleFactoryAbstract(String factoryType) {
		switch (factoryType) {
		case "luxury": {
			this.factory = new LuxuryVehicleFactory();
			break;
		}
		case "odinary": {
			this.factory = new OdinaryVehicleFactory();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + factoryType);
		}
	}

	public VehicleFactory getVehicleFactory() {
		return this.factory;
	}

}
