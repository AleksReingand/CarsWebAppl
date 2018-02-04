package com.telran.cars.modelOrm;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telran.cars.entities.Car;
import com.telran.cars.entities.Model;
import com.telran.cars.entities.Owner;
import com.telran.cars.enums.CarReturnCode;
import com.telran.cars.interfaces.ICar;

@Repository
public class CarOrm implements ICar {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public CarReturnCode addCar(Car car) {
		if (em.find(Car.class, car.getRegNumber()) != null) {
			return CarReturnCode.CAR_EXISTS;
		}
		Model model = car.getModel();
		if (em.find(Model.class, car.getModel()) == null) {
			em.persist(model);
		}
		List<Owner> owners = car.getOwners();
		for (Owner owner : owners) {
			if (em.find(Owner.class, owner.getId()) == null) {
				owners.add(owner);
			}
		}

		em.persist(car);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode addModel(Model model) {
		if (em.find(Model.class, model.getNameModel()) != null) {
			return CarReturnCode.MODEL_EXISTS;
		}

		em.persist(model);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode addOwner(Owner owner) {
		if (em.find(Owner.class, owner.getId()) != null) {
			return CarReturnCode.OWNER_EXISTS;
		}

		em.persist(owner);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode removeCar(String regNumber) {
		Car car = em.find(Car.class, regNumber);
		if (car == null) {
			return CarReturnCode.NO_CAR;
		}
		em.remove(car);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode removeModel(String nameModel) {
		Model model = em.find(Model.class, nameModel);
		if (model == null) {
			return CarReturnCode.NO_MODEL;
		}
		em.remove(model);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode removeOwner(long id) {
		Owner owner = em.find(Owner.class, id);
		if (owner == null) {
			return CarReturnCode.NO_OWNER;
		}
		List<Car> cars = owner.getCars();
		for (Car car : cars) {
			car.getOwners().remove(owner);
		}
		em.remove(owner);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public CarReturnCode updateCarOwner(String regNumber, long newId) {
		Car car = em.find(Car.class, regNumber);
		Owner owner = em.find(Owner.class, newId);
		List<Owner> owners = car.getOwners();
		owners.add(owner);
		return CarReturnCode.OK;
	}

	@Override
	@Transactional
	public Iterable<Car> getOwnerCars(long id) {
		Owner owner = em.find(Owner.class, id);
		List<Car> cars = owner.getCars();
		return cars;
	}

	@Override
	@Transactional
	public Iterable<Owner> getCarOwners(String regNumber) {
		Car car = em.find(Car.class, regNumber);
		List<Owner> owners = car.getOwners();
		return owners;
	}

}
