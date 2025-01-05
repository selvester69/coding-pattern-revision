package com.design.creational.abstractFactory;

public class BMWVehicle implements Vehicle {

	@Override
	public int average() {
		System.out.println("luxury vehicle BMW 35km/h");
		return 35;
	}

}
