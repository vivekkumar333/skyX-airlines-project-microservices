package com.skyx.flight.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonIgnore
	private Long id;

	@Column(name="FLIGHT_NUMBER")
	private String flightNumber;
	
	@Column(name="OPERATING_AIRLINES")
	private String operatingAirlines;
	
	@Column(name="DEPARTURE_CITY")
	private String departureCity;
	
	@Column(name="ARRIVAL_CITY")
	private String arrivalCity;
	
	@Column(name="DATE_OF_DEPARTURE")
	//@JsonFormat(pattern = "DD-MM-YYYY")
	private LocalDate dateOfDeparture;
	
	@Column(name="ESTIMATED_DEPARTURE_TIME")
	//@JsonFormat(pattern = "DD-MM-YYYY HH:mm:ss")
	private LocalDateTime estimatedDepartureTime;
	
	@Column(name="GROSS_FARE_AMT")
	private Double grossFareAmt;
}
