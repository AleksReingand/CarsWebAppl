package com.telran.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telran.cars.api.*;
import com.telran.cars.entities.*;
import com.telran.cars.enums.CarReturnCode;
import com.telran.cars.interfaces.ICar;

@RestController
public class CarHandler {
	@Autowired
	ICar cars;

	@PostMapping(CarConstants.ADD_CAR)
	public CarReturnCode addCar(@RequestBody Car car) {
		return cars.addCar(car);
	}

	@PostMapping(CarConstants.ADD_MODEL)
	public CarReturnCode addModel(@RequestBody Model model) {
		return cars.addModel(model);
	}

	@PostMapping(CarConstants.ADD_OWNER)
	public CarReturnCode addOwner(@RequestBody Owner owner) {
		return cars.addOwner(owner);
	}

	@DeleteMapping(CarConstants.REMOVE_CAR)
	public CarReturnCode removeCar(@RequestParam(name = CarConstants.NUMBER_CAR) String regNumber) {
		return cars.removeCar(regNumber);
	}

	@DeleteMapping(CarConstants.REMOVE_MODEL)
	public CarReturnCode removeModel(@RequestParam(name = CarConstants.NAME_MODEL) String nameModel) {
		return cars.removeModel(nameModel);
	}

	@DeleteMapping(CarConstants.REMOVE_OWNER)
	public CarReturnCode removeOwner(@RequestParam(name = CarConstants.ID_OWNER) long id) {
		return cars.removeOwner(id);
	}

	@PutMapping(CarConstants.UPDATE_CAR_OWNER)
	public CarReturnCode updateCarOwner(@RequestParam(name = CarConstants.NUMBER_CAR) String regNumber,
			@RequestParam(name = CarConstants.ID_OWNER) long newId) {
		return cars.updateCarOwner(regNumber, newId);
	}

	@GetMapping(CarConstants.GET_CAR_OWNERS)
	public Iterable<Owner> getCarOwners(@RequestParam(name = CarConstants.NUMBER_CAR) String regNumber) {
		return cars.getCarOwners(regNumber);
	}

	@GetMapping(CarConstants.GET_OWNER_CARS)
	public Iterable<Car> getOwnerCars(@RequestParam(name = CarConstants.ID_OWNER) long id) {
		return cars.getOwnerCars(id);
	}

}
