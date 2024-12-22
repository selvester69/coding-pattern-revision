package com.design.behavioural.statePattern;

public class ProductState1Impl implements ProductState {

	@Override
	public void state1(Product product) {
		System.out.println("valid impl");
		
	}

	@Override
	public void state2(Product product) {
		System.out.println("default impl");
		
	}

	@Override
	public void state3(Product product) {
		System.out.println("default impl");
		
	}

}
