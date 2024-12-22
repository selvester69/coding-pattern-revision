package com.design.structural.adapterPattern;

import com.design.structural.adapterPattern.adaptee.WeightMachineForBabies;
import com.design.structural.adapterPattern.adapter.WeightMachineAdapter;
import com.design.structural.adapterPattern.adapter.WeightMachineAdapterImpl;

public class ClientMain {

	public static void main(String[] args) {
		
		WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
		 System.out.println(weightMachineAdapter.getWeightInKg());
	}
}
