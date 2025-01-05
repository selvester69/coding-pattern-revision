package com.design.behavioural.nullObj;

public class Car implements Vehicle {

	@Override
	public int getTankCapacity() {
		return 40;
	}

	@Override
	public int getSeatingCapacity() {
		return 6;
	}

}
