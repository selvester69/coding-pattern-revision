package com.lld.carRental;

import java.util.ArrayList;
import java.util.List;

import com.lld.carRental.product.Vehicle;
import com.lld.carRental.product.VehicleType;

public class Store {
	int storeId;
	VehicleInventoryManagement inventoryManagement;
	Location location;
	List<Reservation> reservations = new ArrayList<Reservation>();
	
	public List<Vehicle> getVehicle(VehicleType vehicleType) {
		return inventoryManagement.getVehicles();
	}
	
	public void setVehicle( List<Vehicle> vehicles) {
		inventoryManagement = new VehicleInventoryManagement(vehicles);
	}
	
	public Reservation createReservation(Vehicle vehicle,User user) {
		Reservation res = new Reservation();
		res.createReserve(user,vehicle);
		reservations.add(res);
		return res;
	}
	public boolean completeReservation(int reservationId) {
		//remove from and return true
		
		return true;
	}

}
