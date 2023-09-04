package com.gps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gps.exception.VehicleException;
import com.gps.model.Vehicle;
import com.gps.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vService;

	/**
	 * API to create Vehicles
	 **/

	@PostMapping("/create")
	private ResponseEntity<String> addVehicleDetails(@RequestBody Vehicle vehicle) throws VehicleException {

		String message = vService.addVehicle(vehicle);

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	/**
	 * API to assign owner to Vehicles
	 **/
	@PutMapping("/assignOwner")
	private ResponseEntity<String> assignOwner(@RequestParam Integer vehicleId, @RequestParam Integer ownerId)
			throws VehicleException {

		String message = vService.assingOwner(vehicleId, ownerId);

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
