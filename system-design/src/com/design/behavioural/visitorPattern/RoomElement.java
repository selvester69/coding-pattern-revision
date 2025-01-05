package com.design.behavioural.visitorPattern;

public interface RoomElement {
	public void accept(RoomVisitor visitor);
}
