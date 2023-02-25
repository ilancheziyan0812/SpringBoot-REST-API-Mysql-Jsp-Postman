package com.vehicle.serviceimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vehicle.entity.Vehicle;
import com.vehicle.exception.VehicleNotFoundException;
import com.vehicle.repo.VehicleRepo;
import com.vehicle.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepo vehiclerepo;

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {

		return vehiclerepo.save(vehicle);

	}

	@Override
	public Vehicle getVehicleById(int vid) {

		return vehiclerepo.findById(vid).orElseThrow(()-> new VehicleNotFoundException("vehicle id not present"));
	}

	@Override
	public String deleteById(int vid) {

		Vehicle v = vehiclerepo.findById(vid).orElseThrow(()-> new VehicleNotFoundException("Invalid Id,Please Enter valid id"));

		if(v!=null)
		{
			vehiclerepo.delete(v);
			return "Vehicle delete Successfully";
		}
		return "Vehicle not Deleted";
	}

	@Override
	public List<Vehicle> getAll() {
		
		return vehiclerepo.findAll();
	}

public List<Vehicle> getByVColor(String vcolor)
{
	return vehiclerepo.findByVcolor(vcolor);
}

@Override
public Vehicle updateById(Vehicle vehicle) {
	Vehicle v1 = vehiclerepo.findById(vehicle.getVid()).orElseThrow(()-> new VehicleNotFoundException("This id Not Found,Please Enter Valid Id"));
	
	if(v1!=null)
	{
		v1.setVcolor(vehicle.getVcolor());
		v1.setVmodel(vehicle.getVmodel());
		v1.setVprice(vehicle.getVprice());
		v1.setVname(vehicle.getVname());
		 vehiclerepo.save(v1);
		 return vehicle;
	}
	return null;
}

@Override
public List<Vehicle> sortByPrice() {
	
	return vehiclerepo.findAll(Sort.by(Direction.ASC, "vprice"));
}

@Override
public List<Vehicle> getByVprice(Double vprice) {
	
	return vehiclerepo.findByVprice(vprice);
}

@Override
public List<Vehicle> getByVpriceAndVcolor() {
	
	List<Vehicle> vehi = getAll();
	
	Comparator<Vehicle> comparator = (v1,v2)->{
		if(v1.getVprice()>v2.getVprice())
			return +1;
		else if(v1.getVprice()>v2.getVprice())
			return -1;
		else
			return v1.getVcolor().compareTo(v1.getVcolor());
	};
	
	Collections.sort(vehi, comparator);
	return vehi;
}

}
