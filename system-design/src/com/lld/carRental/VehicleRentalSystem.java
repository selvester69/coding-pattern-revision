package com.lld.carRental;

import java.util.List;

public class VehicleRentalSystem {

	List<User> userList;
	List<Store> storeList;

	VehicleRentalSystem(List<Store> stores, List<User> users) {

		this.storeList = stores;
		this.userList = users;
	}
	
	public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }


	// crud operations on user and stores;
	//addUsers

    //remove users


    //add stores

    //remove stores

}
