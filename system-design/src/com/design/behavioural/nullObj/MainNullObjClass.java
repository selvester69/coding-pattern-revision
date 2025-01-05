package com.design.behavioural.nullObj;

public class MainNullObjClass {
	public static void main(String[] args) {
		Vehicle vehicle = VehicleFactory.getVehicle("Car");
		printVehicleDetails(vehicle);
		vehicle = VehicleFactory.getVehicle("Bike");
		printVehicleDetailsWOPattern(vehicle);
	}

	private static void printVehicleDetails(Vehicle vehicle) {
		System.out.println(vehicle.getSeatingCapacity());
		System.out.println(vehicle.getTankCapacity());
		
	}
	private static void printVehicleDetailsWOPattern(Vehicle vehicle) {
		if(vehicle!=null) {
			System.out.println(vehicle.getSeatingCapacity());
			System.out.println(vehicle.getTankCapacity());			
		}
		
	}
}
