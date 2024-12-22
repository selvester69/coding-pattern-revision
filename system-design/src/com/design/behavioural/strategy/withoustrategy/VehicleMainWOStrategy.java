package com.design.behavioural.strategy.withoustrategy;

public class VehicleMainWOStrategy {
	public static void main(String[] args) {
		Vehicle vehicle = new SportsVehicle();
		vehicle.drive();
		vehicle = new PassengerVehicle();
		vehicle.drive();
	}

}
