package com.design.structural.flyweight;

public class FlyweightMain {

	public static void main(String[] args) {
		IRobot human1 = RobotFactory.createRobot("HUMANOID");
		human1.display(1, 2);
		IRobot human2 = RobotFactory.createRobot("HUMANOID");
		human2.display(10,30);
		System.out.println(human1==human2);
		
		IRobot dog1 = RobotFactory.createRobot("ROBODOG");
		dog1.display(2,9);
		
		IRobot dog2 = RobotFactory.createRobot("ROBODOG");
		dog2.display(11,19);
		System.out.println(dog1==dog2);
	}
}
