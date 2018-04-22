package com.agilemaple.repository;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agilemaple.model.FlightDetails;


public interface FlightDetailsRepository extends JpaRepository<FlightDetails, String> {
	
	@Query(name="FlightDetails.getFlightDetailsByDepartureTime")
	List<FlightDetails> getFlightDetailsByDepartureTime(String departureTime);
}
