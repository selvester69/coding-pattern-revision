package com.design.structural.adapterPattern.adapter;

import com.design.structural.adapterPattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
	WeightMachine weightMachine;

	public WeightMachineAdapterImpl(WeightMachine weightMachine) {
		this.weightMachine = weightMachine;
	}

	@Override
	public double getWeightInKg() {
		System.out.println("converting weight");
		double weightInPound = weightMachine.getWeightInPound();

		// Convert it to KGs
		double weightInKg = weightInPound * .45;
		return weightInKg;

	}

}
