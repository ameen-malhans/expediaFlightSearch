package com.agilemaple.utils;

public class InputValidation {
	
	public static boolean inputValidation(String time) {
		Integer hour = -1;
		Integer min = -1;
	
		if ((time.contains("AM"))) {
			String input = time.split("AM")[0];
			String minutes="";
			String hours="";
			if(input.contains(":")) {
				hours = input.split(":")[0];
				minutes = input.split(":")[1];
			}
			
			if(!hours.isEmpty()) {
			   hour = Integer.valueOf(hours);
			   if (hour > 24 || hour < 0) {
					return Boolean.FALSE;
				}
			}
			if(!minutes.isEmpty()) {
				min = Integer.valueOf(minutes);
				if(min > 59 || min < 0) return Boolean.FALSE; 
			}
		} else if ((time.contains("PM"))) {
			String input = time.split("PM")[0];
			String minutes="";
			String hours="";
			if(input.contains(":")) {
				hours = input.split(":")[0];
				minutes = input.split(":")[1];
			}
			if(!hours.isEmpty()) {
			   hour = Integer.valueOf(hours);
			   if (hour > 24 || hour < 0) {
					return Boolean.FALSE;
				}
			}
			if(!minutes.isEmpty()) {
				min = Integer.valueOf(minutes);
				if(min > 59 || min < 0) return Boolean.FALSE; 
			}
		}	
		return Boolean.TRUE;

	}

}
