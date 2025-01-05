package com.lld.parkingLot;

public class ParkingSpot {

	public int id;
	public boolean isEmpty;
	public Vehicle vehicle;
	public int price;

	public void parkVehicle(Vehicle vehicle) {
		this.isEmpty = false;
		this.vehicle = vehicle;
	}

	public void removeVehicle() {
		this.vehicle = null;
		this.isEmpty = true;
	}

}
