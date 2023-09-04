package com.gps.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ownerID;
    private String name;
    @Column(unique = true)
    private String licenseNumber;
    private String address;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

	public Owner() {
		super();
	}

	public Owner(Integer ownerID, String name, String licenseNumber, String address, String phoneNumber, String email,
			List<Vehicle> vehicles) {
		super();
		this.ownerID = ownerID;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.vehicles = vehicles;
	}

	public Integer getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Integer ownerID) {
		this.ownerID = ownerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	@Override
	public String toString() {
		return "Owner [ownerID=" + ownerID + ", name=" + name + ", licenseNumber=" + licenseNumber + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", vehicles=" + vehicles + "]";
	}

}
