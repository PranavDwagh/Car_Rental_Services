package com.carrentalservice;

import java.util.List;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carrentalservice.entity.Vehicle;
@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	@Query(value= "SELECT COUNT(*) FROM vehicle", nativeQuery = true)
	public Integer getCarsCount();
	
	@Transactional
	@Modifying
	@Query(value= "UPDATE vehicle vehicle SET vehicle.vehicle_price_per_km=:updatedPrice WHERE vehicle.vehicle_id=:vehicleId")
	public int updatePrice(@Param("vehicleId") int vehicleId, @Param("updatedPrice") int updatedPrice);
	
	@Query(value = "select * from vehicle where vehicle_status =1", nativeQuery = true)
	public List<Vehicle> getAvaibleVehicle();
	
}
