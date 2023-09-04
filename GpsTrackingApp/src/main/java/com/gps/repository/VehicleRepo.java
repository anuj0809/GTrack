package com.gps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gps.model.Vehicle;

@Repository
 public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

}
