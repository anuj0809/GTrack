package com.gps.model;

public class CoordinatesDto {
	 private double latitude;
	    private double longitude;

	    public CoordinatesDto(double latitude, double longitude) {
	        this.latitude = latitude;
	        this.longitude = longitude;
	    }
public CoordinatesDto() {
	// TODO Auto-generated constructor stub
}
	    public double getLatitude() {
	        return latitude;
	    }

	    public double getLongitude() {
	        return longitude;
	    }
	    
}
