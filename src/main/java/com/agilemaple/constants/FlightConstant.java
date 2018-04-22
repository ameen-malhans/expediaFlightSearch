package com.agilemaple.constants;

import java.util.Comparator;

import com.agilemaple.dto.FlightViewObject;

public class FlightConstant {
	
	public static final Comparator<FlightViewObject> OPERATOR_COMPARATOR = new Comparator<FlightViewObject>() {
		@Override
		public int compare(FlightViewObject o1, FlightViewObject o2) {
			return o1.getFlightOperator().compareTo(o2.getFlightOperator());
		}
	};

}
