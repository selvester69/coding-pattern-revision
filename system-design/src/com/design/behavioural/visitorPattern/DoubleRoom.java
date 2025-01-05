package com.design.behavioural.visitorPattern;

public class DoubleRoom implements RoomElement {

	@Override
	public void accept(RoomVisitor visitor) {
		visitor.visit(this);
	}

}
