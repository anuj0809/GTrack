package com.gps.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "vehicle")
public class Vehicle {


		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer vehicleID;
		@Column(unique = true)
	    private String registrationNumber;
	    private String bikeModel;
	    private String insuranceExpiryDate;
	    private String purchasedDate;

	    @ManyToOne
	    @JoinColumn(name = "owner_id")
	    private Owner owner;

	    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
	    
	    private List<GPSCoordinates> gpsCoordinatesList;

		public Integer getVehicleID() {
			return vehicleID;
		}

		public void setVehicleID(Integer vehicleID) {
			this.vehicleID = vehicleID;
		}

		public String getRegistrationNumber() {
			return registrationNumber;
		}

		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}

		public String getBikeModel() {
			return bikeModel;
		}

		public void setBikeModel(String bikeModel) {
			this.bikeModel = bikeModel;
		}

		public String getInsuranceExpiryDate() {
			return insuranceExpiryDate;
		}

		public void setInsuranceExpiryDate(String insuranceExpiryDate) {
			this.insuranceExpiryDate = insuranceExpiryDate;
		}

		public String getPurchasedDate() {
			return purchasedDate;
		}

		public void setPurchasedDate(String purchasedDate) {
			this.purchasedDate = purchasedDate;
		}

		public Owner getOwner() {
			return owner;
		}

		public void setOwner(Owner owner) {
			this.owner = owner;
		}

		public List<GPSCoordinates> getGpsCoordinatesList() {
			return gpsCoordinatesList;
		}

		public void setGpsCoordinatesList(List<GPSCoordinates> gpsCoordinatesList) {
			this.gpsCoordinatesList = gpsCoordinatesList;
		}

		public Vehicle() {
			// TODO Auto-generated constructor stub
		}
		public Vehicle(Integer vehicleID, String registrationNumber, String bikeModel, String insuranceExpiryDate,
				String purchasedDate, Owner owner, List<GPSCoordinates> gpsCoordinatesList) {
			super();
			this.vehicleID = vehicleID;
			this.registrationNumber = registrationNumber;
			this.bikeModel = bikeModel;
			this.insuranceExpiryDate = insuranceExpiryDate;
			this.purchasedDate = purchasedDate;
			this.owner = owner;
			this.gpsCoordinatesList = gpsCoordinatesList;
		}
	    @Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", registrationNumber=" + registrationNumber + ", bikeModel="
				+ bikeModel + ", insuranceExpiryDate=" + insuranceExpiryDate + ", purchasedDate=" + purchasedDate
				+ ", owner=" + owner + ", gpsCoordinatesList=" + gpsCoordinatesList + "]";
	}
	    
}
