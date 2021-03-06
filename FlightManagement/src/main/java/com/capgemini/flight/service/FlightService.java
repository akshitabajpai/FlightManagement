package com.capgemini.flight.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flight.dao.Flightdao;
import com.capgemini.flight.entity.Flight;


@Service
@Transactional
public class FlightService {
	
	@Autowired
	private Flightdao flightDao;
	
	@Transactional
	public boolean addflight(Flight flight)
	{
		return flightDao.save(flight) !=null;
	}
	
	@Transactional
	public void deleteflight(Integer flightNumber)
	{
		flightDao.deleteById(flightNumber);
		
	}
	
	@Transactional
	public List<Flight> viewflights()
	{
		return flightDao.findAll();
	}

	@Transactional
    public boolean updateflight(Flight flight,Integer flightNumber)
	
	{
		flight.setFlightModel(flight.getFlightModel());
		return flightDao.save(flight) !=null;
	}

}
