package com.telran.cars.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6041740287105365001L;
	@Id
	long id;
	String name;
	LocalDate birthday;
	@ManyToMany(mappedBy = "owners")
	List<Car> cars;

	public Owner() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
