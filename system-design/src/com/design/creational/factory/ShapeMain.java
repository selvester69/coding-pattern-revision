package com.design.creational.factory;

public class ShapeMain {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape1 = factory.getShape("circle");
		shape1.draw();
		Shape shape2 = factory.getShape("square");
		shape2.draw();
	}
}
