package com.design.structural.decoratorPattern;

import com.design.structural.decoratorPattern.decorator.ExtraCheeseDecorator;
import com.design.structural.decoratorPattern.decorator.Mushroom;

public class PizzaBakery {
	public static void main(String[] args) {
	BasePizza b = new ExtraCheeseDecorator( new Marghreta());
	System.out.println(b.cost());
	System.out.println(new Mushroom(new ExtraCheeseDecorator(new Marghreta())).cost());
	}
}
