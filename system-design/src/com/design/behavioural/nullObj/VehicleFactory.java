package com.design.behavioural.nullObj;

public class VehicleFactory {

	static Vehicle getVehicle(String type) {
		if("car".equalsIgnoreCase(type)) {
			return new Car();
		}
		return new NullVehicle();
		//instead of null now we are returning nullObj with default behavior
	}
}
