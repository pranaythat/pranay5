package com.springboot.h2.serv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.h2.model.Driver;
import com.springboot.h2.repo.DriverRepository;

@Service
public class DriverService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	DriverRepository repository;

	// Save Driver entity in the h2 database.
	public void save(final Driver driver) {
		repository.save(driver);
	}

	// Get all Drivers from the h2 database.
	public List<Driver> getAll() {
		final List<Driver> drivers = new ArrayList<>();
		repository.findAll().forEach(driver -> drivers.add(driver));
		return drivers;
	}
}
