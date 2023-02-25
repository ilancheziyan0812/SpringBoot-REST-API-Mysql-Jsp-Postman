package com.vehicle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.entity.Vehicle;


public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

	List<Vehicle> findByVcolor(String vcolor);
	List<Vehicle> findByVprice(Double vprice);
	
}



