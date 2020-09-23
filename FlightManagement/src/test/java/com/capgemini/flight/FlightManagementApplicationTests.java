package com.capgemini.flight;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.flight.dao.Flightdao;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.service.FlightService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@RunWith(SpringRunner.class)
@SpringBootTest
class FlightManagementApplicationTests {
	
	@Autowired
	private FlightService flightservice;
	
	@MockBean
	Flightdao flightDao;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void viewflightsTest() {
	List<Flight> fly=new ArrayList<Flight>();
	fly.add(new Flight(105,"BA19","Indigo",110));
	fly.add(new Flight(106,"CA03","Indigo",30));
	fly.add(new Flight(107,"IO11","Kingfisher",200));
	fly.add(new Flight(108,"IO22","Kingfisher",180));
	
	when(flightDao.findAll()).thenReturn(fly);
	List<Flight> result = flightservice.viewflights();
	assertEquals(4, result.size());
	}
	
	@Test
	public void updateflightTest() {
		Flight f = new Flight(105,"BA19","Indigo",110);
		f.setSeatCapacity(50);
		flightservice.updateflight(f,105);
		assertEquals(50,f.getSeatCapacity());
		
		
	}
	@Test
	public void deleteflightTest() {
		Flight f = new Flight(106,"CA03","Indigo",30);
		flightDao.delete(f);
		verify(flightDao, times(1)).delete(f);
		
		
	}

}
