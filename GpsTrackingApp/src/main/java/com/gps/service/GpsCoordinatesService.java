package com.gps.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.gps.exception.GpsException;
import com.gps.exception.OwnerException;
import com.gps.exception.VehicleException;
import com.gps.model.GPSCoordinates;

public interface GpsCoordinatesService{

	String storeCoordinates(GPSCoordinates coordinates, Integer vehicleId) throws GpsException;

	List<GPSCoordinates> getCordinates(Integer vehicleId,Integer ownerId) throws VehicleException;

	double getDistanceTraveled(Long vehicleId, String start, String end);


}
