package com.design.behavioural.visitorPattern;

public class ClientMain {
	public static void main(String[] args) {
		RoomElement singleRoom = new SingleRoom();
		RoomElement doubleRoom = new DoubleRoom();
		RoomElement deluxRoom = new DeluxRoom();
		
		RoomVisitor visitor = new RoomPricingVisitor();
		singleRoom.accept(visitor);
		doubleRoom.accept(visitor);
		deluxRoom.accept(visitor);
		
		RoomVisitor maintenance = new RoomMaintenanceVisitor();
		singleRoom.accept(maintenance);
		doubleRoom.accept(maintenance);
		deluxRoom.accept(maintenance);
	}
}
