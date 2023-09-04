package com.gps.service;

import com.gps.exception.VehicleException;
import com.gps.model.Vehicle;

public interface VehicleService {

	String addVehicle(Vehicle vehicle) throws VehicleException;


	String assingOwner(Integer vehicleId, Integer ownerId)throws VehicleException;

}
