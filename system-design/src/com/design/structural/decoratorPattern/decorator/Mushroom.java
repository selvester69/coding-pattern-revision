package com.design.structural.decoratorPattern.decorator;

import com.design.structural.decoratorPattern.BasePizza;

public class Mushroom extends ToppingDecorator {
	BasePizza bPizza;
	
	public Mushroom(BasePizza bPizza) {
		this.bPizza = bPizza;
	}

	@Override
	public int cost() {
		return this.bPizza.cost()+50;
	}

}
