package com.design.creational.abstractFactory;

public class MercedesVehicle implements Vehicle {

	@Override
	public int average() {
		System.out.println("Luxury vehicle Mercedes 30 km/h");
		return 30;
	}

}
