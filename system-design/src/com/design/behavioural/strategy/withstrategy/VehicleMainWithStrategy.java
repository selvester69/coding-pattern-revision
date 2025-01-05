package com.design.behavioural.strategy.withstrategy;

public class VehicleMainWithStrategy {

	public static void main(String[] args) {
		Vehicle vehicle = new SportsVehicle();
		vehicle.drive();
	}
}
