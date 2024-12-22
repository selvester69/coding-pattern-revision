package com.design.behavioural.visitorPattern;

public class RoomPricingVisitor implements RoomVisitor {

	@Override
	public void visit(SingleRoom singleRoom) {
		System.out.println("pricing Single Room");
	}

	@Override
	public void visit(DoubleRoom doubleRoom) {
		System.out.println("pricing double room");

	}

	@Override
	public void visit(DeluxRoom deluxRoom) {
		System.out.println("pricing delux room");

	}

}
