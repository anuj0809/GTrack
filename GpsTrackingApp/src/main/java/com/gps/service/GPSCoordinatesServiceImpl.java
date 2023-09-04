package com.gps.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.exception.GpsException;
import com.gps.exception.VehicleException;
import com.gps.model.CoordinatesDto;
import com.gps.model.GPSCoordinates;
import com.gps.model.Owner;
import com.gps.model.Vehicle;
import com.gps.repository.GPSCoordinatesRepo;
import com.gps.repository.OwnerRepo;
import com.gps.repository.VehicleRepo;

@Service
public class GPSCoordinatesServiceImpl implements GpsCoordinatesService{
	
	private static final double EARTH_RADIUS_KM = 6371.0;
	
	@Autowired
	private GPSCoordinatesRepo gpsRepo;
	
	@Autowired
	private VehicleRepo vRepo;
	
	@Autowired
	private OwnerRepo oRepo;
	
	
	@Override
	public  String storeCoordinates(GPSCoordinates coordinates,Integer vehicelId) throws GpsException {
	
		Vehicle vehicle = vRepo.findById(vehicelId).orElseThrow(()-> new GpsException("vehicle not found by given ID"));
		
    coordinates.setVehicle(vehicle);	
	gpsRepo.save(coordinates);
		return "GPS Co-ordinates saved Successfully";
		
	}


	@Override
	public List<GPSCoordinates> getCordinates(Integer ownerId ,Integer vehicleId) throws VehicleException{
Owner owner = oRepo.findById(ownerId).orElseThrow(()-> new VehicleException("Owner not find by givn ID"));
Vehicle vehicle = vRepo.findById(vehicleId).orElseThrow(()-> new VehicleException("Owner not find by givn ID"));
    if(vehicle.getOwner().getOwnerID()!=owner.getOwnerID()) {
    	throw new VehicleException("You can not see information of other vehicle");
    }
   
    List<GPSCoordinates> gpsCord = gpsRepo.findAll();
    List<GPSCoordinates> result = new ArrayList<>();
    for(GPSCoordinates gp:gpsCord) {
    	if(ownerId == gp.getVehicle().getOwner().getOwnerID())
    	result.add(new GPSCoordinates(gp.getGpsID(), gp.getLatitude(), gp.getLongitude(), gp.getTimestamp()));
    }
    if(result.size()==0) {
    	throw new VehicleException("No Gps Co-ordinates found !");
    }
     return result;
	}

// service for calculation of distance traveled
	@Override
	public double getDistanceTraveled(Long vehicleId, String start, String end) {

        List<GPSCoordinates> result = gpsRepo.findByStartAndEndDate(vehicleId,LocalDateTime.parse(start.trim()),LocalDateTime.parse(end.trim()));
		

          double totalDistance = 0.0;
          for (int i = 0; i < result.size() - 1; i++) {
        	  CoordinatesDto current = new CoordinatesDto(result.get(i).getLatitude(), result.get(i).getLongitude()) ;
        	  CoordinatesDto next =new CoordinatesDto(result.get(i+1).getLatitude(), result.get(i+1).getLongitude());
              totalDistance += calculateDistance(current.getLatitude(), current.getLongitude(),next.getLatitude(), next.getLongitude());
          }
          return totalDistance;
          
	}
	

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }


	
	 

}
