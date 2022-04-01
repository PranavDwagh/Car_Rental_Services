package com.carrentalservice;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carrentalservice.entity.Driver;
@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer>{
	@Query(value = "SELECT COUNT(*) FROM driver_details", nativeQuery = true)
	public Integer getDriverCount();
	
	@Query(value = "SELECT * FROM driver_details driver_details where driver_details.driver_id=:driverId", nativeQuery = true)
	public Driver getDriverById(@Param("driverId")int driverId);
	
	@Query(value ="select * from driver_details where driver_status=1 limit 1", nativeQuery = true)
	public Driver assignDriver();
	
}
