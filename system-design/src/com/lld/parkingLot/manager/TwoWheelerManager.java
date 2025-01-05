package com.lld.parkingLot.manager;

import java.util.ArrayList;
import java.util.List;

import com.lld.parkingLot.ParkingSpot;

public class TwoWheelerManager extends ParkingSpotManager{
	static List<ParkingSpot> list = new ArrayList<ParkingSpot>();

	
	public TwoWheelerManager(List<ParkingSpot> list) {
		super(list);
	}

}
