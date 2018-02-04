package com.telran.cars.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.telran.cars.enums.State;
import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2024377798250988308L;
	@Id
	String regNumber;
	String name;
	LocalDate yearRelease;
	State state;
	@ManyToMany
	List<Owner> owners;
	@ManyToOne
	Model model;

	public Car() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getName() {
		return name;
	}

	public LocalDate getYearRelease() {
		return yearRelease;
	}

	public State getState() {
		return state;
	}

	public List<Owner> getOwners() {
		return owners;
	}

	public Model getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", name=" + name + ", yearRelease=" + yearRelease + ", state=" + state
				+ ", model=" + model + "]";
	}

}