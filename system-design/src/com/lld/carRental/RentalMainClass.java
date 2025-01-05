package com.lld.carRental;

import java.util.ArrayList;
import java.util.List;

import com.lld.carRental.product.Car;
import com.lld.carRental.product.Vehicle;
import com.lld.carRental.product.VehicleType;

public class RentalMainClass {

	public static void main(String[] args) {
		List<User> users = addUsers();
		List<Vehicle> vehicles = addVehicles();
		List<Store> stores = addStores(vehicles);
		
		VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);
		
		User user = users.get(0);
		Location location = new Location(403012,"Bangalore","Karnataka","India");
		Store store = rentalSystem.getStore(location);
		
		List<Vehicle> storeVehicle = store.getVehicle(VehicleType.CAR);
		
		Reservation reservation = store.createReservation(storeVehicle.get(0), user);
		Bill bill =new Bill(reservation);
		Payment payment = new Payment();
		payment.payBill(bill);
		
		store.completeReservation(reservation.reservationId);
		
	}

	private static List<Vehicle> addVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();

		Vehicle vehicle1 = new Car();
		vehicle1.setVehicleId(1);
		vehicle1.setVehicleType(VehicleType.CAR);

		Vehicle vehicle2 = new Car();
		vehicle1.setVehicleId(2);
		vehicle1.setVehicleType(VehicleType.CAR);

		vehicles.add(vehicle1);
		vehicles.add(vehicle2);

		return vehicles;

	}

	public static List<Store> addStores(List<Vehicle> vehicles) {

		List<Store> stores = new ArrayList<>();
		Store store1 = new Store();
		store1.storeId = 1;
		store1.setVehicle(vehicles);

		stores.add(store1);
		return stores;
	}

	public static List<User> addUsers() {

		List<User> users = new ArrayList<>();
		User user1 = new User();
		user1.setUserId(1);

		users.add(user1);
		return users;
	}

}
