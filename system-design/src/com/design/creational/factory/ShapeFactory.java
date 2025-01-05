package com.design.creational.factory;

public class ShapeFactory {

	public Shape getShape(String type) {
		switch (type) {
		case "circle":
			return new Circle();
		case "square":
			return new Square();
		case "rectangle": 
			return new Rectangle();
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}

}
