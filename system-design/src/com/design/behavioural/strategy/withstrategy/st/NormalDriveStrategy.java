package com.design.behavioural.strategy.withstrategy.st;

public class NormalDriveStrategy implements DriveStrategy {

	@Override
	public void drive() {
		System.out.println("Normal Drive  from strategy class");
		
	}
}
