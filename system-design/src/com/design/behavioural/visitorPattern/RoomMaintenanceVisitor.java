package com.design.behavioural.visitorPattern;

public class RoomMaintenanceVisitor implements RoomVisitor {

	@Override
	public void visit(SingleRoom singleRoom) {
		System.out.println("maintaining Single Room");
	}

	@Override
	public void visit(DoubleRoom doubleRoom) {
		System.out.println("maintaining double room");

	}

	@Override
	public void visit(DeluxRoom deluxRoom) {
		System.out.println("maintaining delux room");

	}

}
