package com.design.creational.abstractFactory;

import com.design.creational.abstractFactory.factory.LuxuryVehicleFactory;
import com.design.creational.abstractFactory.factory.OdinaryVehicleFactory;
import com.design.creational.abstractFactory.factory.VehicleFactoryAbstract;

public class AbstractFactoryMain {
	public static void main(String[] args) {
		VehicleFactoryAbstract absFactory = new VehicleFactoryAbstract("luxury");
		LuxuryVehicleFactory luxury = (LuxuryVehicleFactory) absFactory.getVehicleFactory();
		System.out.println(luxury.getVehicle().average());
		
		VehicleFactoryAbstract absFactory2 = new VehicleFactoryAbstract("odinary");
		OdinaryVehicleFactory odinary = (OdinaryVehicleFactory) absFactory2.getVehicleFactory();
		System.out.println(odinary.getVehicle().average());
	}

}
