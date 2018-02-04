package com.telran.cars.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5188940587188115348L;
	@Id
	String nameModel;
	String country;
	LocalDate yearCreate;
	@OneToMany(mappedBy = "model")
	List<Car> cars;

	public Model() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNameModel() {
		return nameModel;
	}

	public String getCountry() {
		return country;
	}

	public LocalDate getYearCreate() {
		return yearCreate;
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "Model [nameModel=" + nameModel + ", country=" + country + ", yearCreate=" + yearCreate + "]";
	}

}
