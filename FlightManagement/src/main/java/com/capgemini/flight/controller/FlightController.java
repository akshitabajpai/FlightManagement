package com.capgemini.flight.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.exception.FlightException;
import com.capgemini.flight.service.FlightService;

import java.util.List;
import java.util.Optional;

@Controller

public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@CrossOrigin
	@PostMapping("/addflight")
	public ResponseEntity<String> addFlight(@Valid @RequestBody Flight flight, BindingResult br)
			throws FlightException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new FlightException(err);
		}
		try {
			flightservice.addflight(flight);
			return new ResponseEntity<String>("Flight added successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new FlightException("ID already exists");
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteflight/{flightNumber}")
	public ResponseEntity<String> deleteflight( @PathVariable Integer flightNumber) throws FlightException
	{
		try
		{
			flightservice.deleteflight( flightNumber);
			return new ResponseEntity<String>("flight is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new FlightException("flight number  doesnot exists");
		}
	}
	
	@GetMapping("/viewallflight")
	public ResponseEntity<List<Flight>> show() {
		List<Flight> flightList = flightservice.viewflights();
		return new ResponseEntity<List<Flight>>(flightList, HttpStatus.OK);
	}
	
	
	@PutMapping("/updateflight/{flightNumber}")
	public ResponseEntity<String> updateflight(@Valid @RequestBody Flight flight,@PathVariable Integer flightNumber,BindingResult br ) throws FlightException
	{
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new FlightException(err);
		}
		try {
			flightservice.updateflight(flight,flightNumber);
			return new ResponseEntity<String>("Flight updated successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new FlightException("flight number does not exists");
		}
	}

}
