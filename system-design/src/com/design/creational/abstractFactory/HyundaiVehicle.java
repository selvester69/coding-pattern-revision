package com.design.creational.abstractFactory;

public class HyundaiVehicle implements Vehicle {

	@Override
	public int average() {
		System.out.println("odinary vehicle Hyundai 60 km/h");
		return 60;
	}

}
