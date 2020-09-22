package com.capgemini.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.flight.entity.Flight;

@Repository
public interface Flightdao extends JpaRepository<Flight,Integer> {
	
	
	

}
