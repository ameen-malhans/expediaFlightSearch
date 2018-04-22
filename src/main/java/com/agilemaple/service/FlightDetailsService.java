package com.agilemaple.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilemaple.model.FlightDetails;

public interface FlightDetailsService {	
	public List<FlightDetails> searchFlightByTime(String time);
	
}
