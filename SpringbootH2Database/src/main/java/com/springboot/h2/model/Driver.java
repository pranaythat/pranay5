package com.springboot.h2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class Driver{

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the primary key values.
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private String emailAddress;

private int distance;

private int waitingTime;

	

	// Getters.
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmailAddress() {
		return emailAddress;
	}

public int getDistance() {
		return distance;
	}
public int getWaitingTime() {
		return waitingTime;
	}
}
