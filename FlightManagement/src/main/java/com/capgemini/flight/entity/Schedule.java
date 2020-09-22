package com.capgemini.flight.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

@Entity
@Table(name ="schedule")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Schedule {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="schedule_id")
	private int schedule_id;
	
	@ManyToOne
    @JoinColumn(name="airport_code",nullable=false)
    private Airport sourceAirport;
	
	@ManyToOne
    @JoinColumn(name="airport_name",nullable=false)
    private Airport destinationAirport;
	
	@JsonDeserialize(using = DateDeserializer .class)
	 private Date arrivalDate;
	
	@JsonDeserialize(using = DateDeserializer .class)
	 private Date departureDate;
	
 
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public Schedule(int schedule_id, Airport sourceAirport, Airport destinationAirport, Date arrivalTime,
			Date departureTime) {
		super();
		this.schedule_id = schedule_id;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalDate = arrivalTime;
		this.departureDate = departureTime;
	}
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Schedule [schedule_id=" + schedule_id + ", sourceAirport=" + sourceAirport + ", destinationAirport="
				+ destinationAirport + ", arrivalTime=" + arrivalDate + ", departureTime=" + departureDate + "]";
	}

}
