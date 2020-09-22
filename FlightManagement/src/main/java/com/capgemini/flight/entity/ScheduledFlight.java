package com.capgemini.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name ="scheduledflight")
@DynamicUpdate(true)
@DynamicInsert(true)

public class ScheduledFlight {

	@Id
	@Column(name="availableSeats")
	private Integer availableSeats;

	@ManyToOne
	    @JoinColumn(name="flight_number", nullable=false)
	    private Flight flight;

	@ManyToOne
	@JoinColumn(name="schedule_id", nullable=false)
	private Schedule schedule;

	public Flight getFlight() {
	return flight;
	}
	
	public void setFlight(Flight flight) {
	this.flight = flight;
	}
	
	public int getAvailableSeats() {
	return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
	}
	
	public Schedule getSchedule() {
	return schedule;
	}
	
	public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
	}
	
	
	public ScheduledFlight(int availableSeats,Flight flight,Schedule schedule) {
	super();
	this.availableSeats = availableSeats;
	this.flight = flight;
	this.schedule = schedule;
	}
	
	
	public ScheduledFlight() {
	super();
	}
	
	
	
	@Override
	public String toString() {
	return "ScheduledFlight [availableSeats=" + availableSeats + ",flight=" + flight + ",schedule=" + schedule
	+ "]";
	}
}
