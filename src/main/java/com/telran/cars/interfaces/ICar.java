package com.telran.cars.interfaces;

import com.telran.cars.entities.*;
import com.telran.cars.enums.CarReturnCode;

public interface ICar {
	
	CarReturnCode addCar(Car car);
	CarReturnCode addModel(Model model);
	CarReturnCode addOwner(Owner owner);
	CarReturnCode removeCar(String regNumber);
	CarReturnCode removeModel(String nameModel);
	CarReturnCode removeOwner(long id);
	CarReturnCode updateCarOwner(String regNumber, long newId);
	Iterable<Car> getOwnerCars(long id);
	Iterable<Owner> getCarOwners(String regNumber);

}
