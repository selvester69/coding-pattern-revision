package com.lld.parkingLot;

public class TwoWheelerParkingSpot extends ParkingSpot {

	public void parkVehicle(Vehicle vehicle) {
		this.isEmpty = false;
		this.vehicle = vehicle;
	}

	public int getPrice() {
		return 20;
	}
}
