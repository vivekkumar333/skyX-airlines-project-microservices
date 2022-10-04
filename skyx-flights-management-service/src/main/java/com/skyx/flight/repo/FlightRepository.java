package com.skyx.flight.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skyx.flight.entity.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	@Query("from Flight where departureCity=:fromCity and arrivalCity=:toCity "
			+ "and dateOfDeparture=:departureDate")
	List<Flight> searchFlights(@Param("fromCity") String from,@Param("toCity") String to,
			@Param("departureDate") LocalDate date);
	
	
	//Flight findFlightByFlightNumber(String flightNumber);
}
