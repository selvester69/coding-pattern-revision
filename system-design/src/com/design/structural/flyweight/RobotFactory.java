package com.design.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
	private static Map<String,IRobot>roboCache = new HashMap<>();
	
	public static IRobot createRobot(String type) {
		if(roboCache.containsKey(type)) {
			return roboCache.get(type);
		}else {
			if(type=="HUMANOID") {
				Sprites humanSprite = new Sprites();
				IRobot human = new HumanRobot(type, humanSprite);
				roboCache.put(type, human);
				return human;
			}else if(type=="ROBODOG") {
				Sprites dogSprite = new Sprites();
				IRobot dog = new DogRobot(type, dogSprite);
				roboCache.put(type, dog);
				return dog;
			}
		}
		return null;//or throw exception 
	}

}
