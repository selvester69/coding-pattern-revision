package com.design.behavioural.visitorPattern;

public class SingleRoom implements RoomElement {

	@Override
	public void accept(RoomVisitor visitor) {
		visitor.visit(this);
		
	}

}
