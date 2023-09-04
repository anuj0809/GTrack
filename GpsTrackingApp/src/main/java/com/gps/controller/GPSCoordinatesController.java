package com.gps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gps.exception.GpsException;
import com.gps.exception.VehicleException;
import com.gps.model.GPSCoordinates;
import com.gps.service.GpsCoordinatesService;

@RestController
@RequestMapping("/gps")
public class GPSCoordinatesController {

	@Autowired
	private GpsCoordinatesService gpsService;

	/**
	 * API to store the coordinates of vehicle by passing vehicleID and
	 * gpscoordinates
	 **/
	@PostMapping("/coordinates/{vehicleId}")
	public ResponseEntity<String> storeGpsCoordinates(@RequestBody GPSCoordinates coordinates,
			@PathVariable("vehicleId") Integer vehicleId) throws GpsException {

		String message = gpsService.storeCoordinates(coordinates, vehicleId);

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
	/**
	 * API to get coordinates of vehicle by passing vehicleID and ownerID
	 * 
	 * 
	 **/
	@GetMapping("/getcoordinates")
	public ResponseEntity<List<GPSCoordinates>> getCoordinates(@RequestParam("ownerId") Integer ownerId,
			@RequestParam("vehicleId") Integer vehicleId) throws VehicleException {

		List<GPSCoordinates> result = gpsService.getCordinates(ownerId, vehicleId);

		return new ResponseEntity<List<GPSCoordinates>>(result, HttpStatus.OK);
	}

	/**
	 * API to  get distance travelled calculated using gps locations stored in the table
	 * 
	 **/
	@GetMapping("/getDistanceTraveled")
	public ResponseEntity<Double> getDistanceTraveled(@RequestParam("vehicleId") Long vehicleId,
			@RequestParam("startDate") String start, @RequestParam("endDate") String end) throws VehicleException {

		System.out.println(vehicleId + " " + end + " " + start);
		Double result = gpsService.getDistanceTraveled(vehicleId, start, end);

		return new ResponseEntity<Double>(result, HttpStatus.OK);

	}
}
