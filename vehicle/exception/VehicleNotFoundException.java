package com.vehicle.exception;

public class VehicleNotFoundException extends RuntimeException {

	String message;
	public VehicleNotFoundException(String message)
	{
		super();
	}
	public String getMessage()
	{
		return message;
	}
}
