package com.lld.parkingLot.manager;

import java.util.ArrayList;
import java.util.List;
import com.lld.parkingLot.ParkingSpot;

public class FourWheelerManager extends ParkingSpotManager {

	static List<ParkingSpot> list = new ArrayList<ParkingSpot>(400);

	public FourWheelerManager() {
		super(list);
	}
}
