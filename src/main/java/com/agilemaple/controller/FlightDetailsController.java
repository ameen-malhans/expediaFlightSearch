package com.agilemaple.controller;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agilemaple.constants.FlightConstant;
import com.agilemaple.dto.FlightViewObject;
import com.agilemaple.exception.FlightSearchException;
import com.agilemaple.model.FlightDetails;
import com.agilemaple.service.FlightDetailsService;
import com.agilemaple.utils.*;

@RestController
@RequestMapping("/api") //used to map web requests to Spring Controller methods
public class FlightDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(FlightDetailsController.class);
	

	@Autowired
	private FlightDetailsService flightDetailsService;
	
	@RequestMapping(value =  "/rest/flight/{time}" , method = RequestMethod.GET)
	public @ResponseBody List<FlightViewObject> flightDetailsList(@PathVariable("time") String time) {
		List<FlightViewObject> flightViewObjects = new ArrayList<FlightViewObject>();
		try {
			boolean valid = InputValidation.inputValidation(time);
			if (!valid) {
				throw new FlightSearchException("Please check you input");
			}
			
			
			logger.debug("Start getAllFlights");
			List<FlightDetails> flightDetails = flightDetailsService.searchFlightByTime(time);
			for (FlightDetails flDetails : flightDetails) {
              
				FlightViewObject flightViewObject = new FlightViewObject();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");
				flightViewObject.setDepartureTime(sdf.format(flDetails.getDepartureTime()));
				flightViewObject.setFlightCode(flDetails.getFlightCode());
				flightViewObject.setFlightOperator(flDetails.getFlightOperator());
				flightViewObjects.add(flightViewObject);
			}
		} catch (Exception e) {
			logger.error("FlightDetailsController::flightDetailsList", e);
			FlightViewObject flightViewObject = new FlightViewObject();
			flightViewObject.setErrorMessage(e.getMessage());
			flightViewObjects.add(flightViewObject);
		}
	
		
		Collections.sort(flightViewObjects, FlightConstant.OPERATOR_COMPARATOR);

		return flightViewObjects;
	}

	

}
