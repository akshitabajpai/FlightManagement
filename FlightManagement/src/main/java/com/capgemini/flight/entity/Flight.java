package com.capgemini.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "flight")
@DynamicUpdate(true)
@DynamicInsert(true)

public class Flight {
	@Id
	@Column(name="flight_number")
	private Integer flightNumber;

	@NotEmpty(message="Flight Model is Mandatory")
	
	@Column(name="flight_model")
	private String flightModel;

	@NotEmpty(message="Carrier Name is Mandatory")
	@Column(name="carrier_name")
	private String carrierName;

	@NotNull(message="Seat Capacity Is Mandatory")
	@Min(value=0)
	@Max(value=500)
	@Column(name="seat_capacity")
	private Integer seatCapacity;

	public int getFlightNumber() {
	return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
	this.flightNumber = flightNumber;
	}


	public String getFlightModel() {
	return flightModel;
	}

	public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
	}

	public String getCarrierName() {
	return carrierName;
	}

	public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
	return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
	}
	public Flight(int flightNumber, String flightModel,String carrierName,int seatCapacity) {
	super();
	this.flightNumber = flightNumber;
	this.flightModel = flightModel;
	this.carrierName = carrierName;
	this.seatCapacity = seatCapacity;
	}
	public Flight() {
	super();
	}
	@Override
	public String toString() {
	return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
	+ ", seatCapacity=" + seatCapacity + "]";
	}

}
