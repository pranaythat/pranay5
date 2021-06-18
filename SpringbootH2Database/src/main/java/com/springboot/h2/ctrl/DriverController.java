package com.springboot.h2.ctrl;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.model.Driver;
import com.springboot.h2.serv.DriverService;

@RestController		// Useful to create the RESTful webservices.
public class DriverController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	DriverService service;

	// Save driver entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value= "/driver/save")
	public int save(final @RequestBody @Valid Driver driver) {
		log.info("Saving driver details in the database.");
		service.save(driver);
		return driver.getId();
	}

	// Get all drivers from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/driver/getall", produces= "application/json")
	public List<Driver> getAll() {
		log.info("Getting driver details from the database.");
		return service.getAll();
	}

@GetMapping(value= "/driverCanArriveQuick", produces= "application/json")
	public Driver getDriverArrivesQuick() {

		Driver d =service.getAll().stream().min(Comparator.comparing(Driver::getDistance)).get();
		return d;
	}
}
