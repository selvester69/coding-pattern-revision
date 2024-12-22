package com.design.structural.composite.solution2;

public class Number implements ArithmeticExpression {
	int number;

	public Number(int number) {
		super();
		this.number = number;
	}

	@Override
	public int evaluate() {
		return this.number;
	}

}
