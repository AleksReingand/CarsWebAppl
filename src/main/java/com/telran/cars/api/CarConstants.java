package com.telran.cars.api;

public interface CarConstants {
	// POST request
	String ADD_CAR = "/car";
	String ADD_MODEL = "/model";
	String ADD_OWNER = "/owner";
	// DELETE request
	String REMOVE_CAR = "/car";
	String REMOVE_MODEL = "/model";
	String REMOVE_OWNER = "/owner";
	// PUT request
	String UPDATE_CAR_OWNER = "/car/owner";
	// GET request
	String GET_CAR_OWNERS = "/car/owners";
	String GET_OWNER_CARS = "/owner/cars";
	// DATA
	String ID_OWNER = "id";
	String NAME_MODEL = "nameModel";
	String NUMBER_CAR = "regNumber";

}
