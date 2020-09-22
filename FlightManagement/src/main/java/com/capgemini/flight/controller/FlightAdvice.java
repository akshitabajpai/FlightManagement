package com.capgemini.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flight.exception.ErrorInfo;
import com.capgemini.flight.exception.FlightException;

@RestController
public class FlightAdvice {
	@ExceptionHandler(value = {FlightException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException1(Exception ex) {
		
		return new ErrorInfo(ex.getMessage());
	}
	
}
