package com.gps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.exception.GpsException;
import com.gps.exception.OwnerException;
import com.gps.exception.VehicleException;
import com.gps.model.Owner;
import com.gps.model.Vehicle;
import com.gps.repository.OwnerRepo;
import com.gps.repository.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleRepo vRepo;
	
	@Autowired
	private OwnerRepo oRepo;
	
	@Override
	public String addVehicle(Vehicle vehicle) throws VehicleException {
		
		if(vehicle.getRegistrationNumber() ==null) {
			throw new VehicleException("RegistrationNumber not found");
		}
		
		vRepo.save(vehicle);
		
		return "Vehicle Saved successfully";
	}

	@Override
	public String assingOwner(Integer vehicleId, Integer ownerId) throws VehicleException {
		Vehicle vehicle = vRepo.findById(vehicleId).orElseThrow(()-> new VehicleException("vehicle not found by given ID"));
		
		Owner owner = oRepo.findById(ownerId).orElseThrow(()-> new VehicleException("Owner not find by givn ID"));
		vehicle.setOwner(owner);
		
		vRepo.save(vehicle);
		return "owner assigned successfully ";
	}

	
	
	
	

}
