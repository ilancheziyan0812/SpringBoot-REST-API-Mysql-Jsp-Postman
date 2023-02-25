package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vehicle.entity.Vehicle;
import com.vehicle.service.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	VehicleService vehicleservice;

	@RequestMapping("/")
	public String first()
	{
		return "Welcome To Vehicle Management System";
	}
	
	@PostMapping(path = "/save")
	public Vehicle saveVehicle(Vehicle vehicle)
	{
		return vehicleservice.saveVehicle(vehicle);
	}

	@GetMapping(path = "/vehicle/{vid}")
	public Vehicle getById(@PathVariable("vid") int vid)
	{
		return vehicleservice.getVehicleById(vid);
	}

	@DeleteMapping("/remove/{vid}")
	public String removeById(@PathVariable("vid") int vid)
	{
		return vehicleservice.deleteById(vid);
	}

	@GetMapping("/getall")
	public List<Vehicle> getAll()
	{
		return vehicleservice.getAll();
	}

	@GetMapping("/getcolor/{vcolor}")
	public List<Vehicle> getVehicleByColor(@PathVariable("vcolor") String vcolor)
	{
		return vehicleservice.getByVColor(vcolor);
	}
	
	@PutMapping("/update")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle)
	{
		return vehicleservice.updateById(vehicle);
	}
    @GetMapping("/getsortbyprice")
	public List<Vehicle> getVehicleByPriceInSort()
	{
		return vehicleservice.sortByPrice();
	}

    @GetMapping("/getbyvprice/{vprice}")
    public List<Vehicle> getByVprice(@PathVariable("vprice") Double vprice)
    {
    	return vehicleservice.getByVprice(vprice);
    	
    }
    @GetMapping("/getbysort")
    public List<Vehicle> getVehicleBySorting()
    {
    	return vehicleservice.getByVpriceAndVcolor();
    }

}
