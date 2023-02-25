package com.vehicle.service;
import java.util.List;
import com.vehicle.entity.Vehicle;

public interface VehicleService {

	Vehicle saveVehicle(Vehicle vehicle);
	Vehicle getVehicleById(int vid);
	String deleteById(int vid);
	List<Vehicle> getAll();
	List<Vehicle> getByVColor(String vcolor);
	Vehicle updateById(Vehicle vehicle);
	List<Vehicle> sortByPrice();
	List<Vehicle> getByVprice(Double vprice);
	List<Vehicle> getByVpriceAndVcolor();

}
