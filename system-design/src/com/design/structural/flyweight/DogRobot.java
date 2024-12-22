package com.design.structural.flyweight;

public class DogRobot implements IRobot {
	String type;
	Sprites body;
	

	public DogRobot(String type, Sprites body) {
		super();
		this.type = type;
		this.body = body;
	}


	@Override
	public void display(int x, int y) {
		// TODO Auto-generated method stub

	}

}
