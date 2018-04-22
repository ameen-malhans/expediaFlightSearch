package com.agilemaple.service.implementation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.agilemaple.model.FlightDetails;
import com.agilemaple.service.FlightDetailsService;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightDetailsServiceImplTest {
	
	@Autowired	
	private FlightDetailsService flightDetailsService;
	
	
	@Test
	public void testFlightDetailsList() {
		List<FlightDetails> flight = flightDetailsService.searchFlightByTime("3:30PM");
		Assert.assertEquals(3, flight.size());
		
		flight = flightDetailsService.searchFlightByTime("12PM");
		Assert.assertEquals(4, flight.size());
		
		
		flight = flightDetailsService.searchFlightByTime("6:00AM");
		Assert.assertEquals(2, flight.size());
		
		flight = flightDetailsService.searchFlightByTime("6:00PM");
		Assert.assertEquals(1, flight.size());
	}



}
