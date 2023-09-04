package com.gps.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gps.model.GPSCoordinates;

@Repository
public interface GPSCoordinatesRepo extends JpaRepository<GPSCoordinates, Integer>{

//	@Query("SELECT g FROM GPSCoordinates g WHERE g.timestamp BETWEEN :n AND :b")
//    List<GPSCoordinates> findByStartAndEndDate(@Param("n") String start, @Param("b") String end);
	  @Query("SELECT g FROM GPSCoordinates g WHERE g.vehicle.vehicleID = :vehicleId AND g.timestamp >= :startDate AND g.timestamp <= :endDate")
	  List<GPSCoordinates> findByStartAndEndDate(@Param("vehicleId") Long vehicleId, @Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);

}
