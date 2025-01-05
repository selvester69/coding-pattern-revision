package com.design.structural.decoratorPattern.decorator;

import com.design.structural.decoratorPattern.BasePizza;

public class ExtraCheeseDecorator extends ToppingDecorator  {
	BasePizza bPizza;
	
	public ExtraCheeseDecorator(BasePizza bPizza) {
		this.bPizza = bPizza;
	}

	@Override
	public int cost() {
		return this.bPizza.cost()+10;
	}

}
