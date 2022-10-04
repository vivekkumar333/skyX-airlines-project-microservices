package com.skyx.flight.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyx.flight.entity.Flight;
import com.skyx.flight.repo.FlightRepository;


@RequestMapping("flight")
@RestController
public class FlightController {
	@Autowired
	FlightRepository flightRepo;
	
	@GetMapping("searchflight/{from}/{to}/{departureDate}")
	public List<Flight> searchFlight(@PathVariable String from, @PathVariable String to, 
			@PathVariable("departureDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
		
		return flightRepo.searchFlights(from,to,date); 
	}
	
	@GetMapping("/{flightId}")
	public Optional<Flight> getFlight(@PathVariable Long  flightId) {
		
		return flightRepo.findById(flightId);
	}
}

/* Insert Flights in DB
insert into skyx_airlines_flight_mgmt_db.tbl_flight(id,flight_number,operating_airlines,departure_city,arrival_city,date_of_departure,estimated_departure_time,gross_fare_amt) 
values (1,'AA1','SkyX Airlines','BLR','MUM',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 09:30:00','%d/%m/%Y %H:%i:%s'),7500.00),
(2,'AA2','SkyX Airlines','BLR','MUM',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 13:30:00','%d/%m/%Y %H:%i:%s'),7500.00),
(3,'AA3','SkyX Airlines','MUM','BLR',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 20:00:00','%d/%m/%Y %H:%i:%s'),8500.00),
(4,'AA4','SkyX Airlines','MUM','BLR',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 21:30:00','%d/%m/%Y %H:%i:%s'),9500.00),
(5,'AA5','SkyX Airlines','BLR','ATL',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 09:00:00','%d/%m/%Y %H:%i:%s'),75000.00),
(6,'AA6','SkyX Airlines','BLR','Chicago',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 10:30:00','%d/%m/%Y %H:%i:%s'),90000.00),
(7,'AA7','SkyX Airlines','BLR','Chicago',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 13:30:00','%d/%m/%Y %H:%i:%s'),950000.00),
(8,'AA8','SkyX Airlines','BLR','MUM',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 11:30:00','%d/%m/%Y %H:%i:%s'),8000.00),
(9,'AA9','SkyX Airlines','BLR','MUM',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 16:00:00','%d/%m/%Y %H:%i:%s'),10000.00),
(10,'AA10','SkyX Airlines','BLR','MUM',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 17:30:00','%d/%m/%Y %H:%i:%s'),75000.00),
(11,'AA11','SkyX Airlines','MUM','BLR',STR_TO_DATE('09/05/2021','%d/%m/%Y'),STR_TO_DATE('09/05/2021 17:00:00','%d/%m/%Y %H:%i:%s'),75000.00);
*/