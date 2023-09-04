package com.gps.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gps_coordinates")
public class GPSCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gpsID;
    private Double latitude;
    private Double longitude;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timestamp;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


	public GPSCoordinates(Integer gpsID, Double latitude, Double longitude, LocalDateTime timestamp) {
		super();
		this.gpsID = gpsID;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
	}

	public Integer getGpsID() {
		return gpsID;
	}

	public void setGpsID(Integer gpsID) {
		this.gpsID = gpsID;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public GPSCoordinates() {
		super();
	}

	@Override
	public String toString() {
		return "GPSCoordinates [gpsID=" + gpsID + ", latitude=" + latitude + ", longitude=" + longitude + ", timestamp="
				+ timestamp + ", vehicle=" + vehicle + "]";
	}
}
