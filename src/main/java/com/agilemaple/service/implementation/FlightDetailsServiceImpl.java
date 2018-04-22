package com.agilemaple.service.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.model.FlightDetails;
import com.agilemaple.repository.FlightDetailsRepository;
import com.agilemaple.service.FlightDetailsService;

@Service
@Transactional
public class FlightDetailsServiceImpl implements FlightDetailsService{

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	
	@Override
	@Transactional
	public List<FlightDetails> searchFlightByTime(String time) {
		time = createCorrectFormat(time);
		Integer hours = 0;
		Integer minutes = 0;
		// Add logic to convert AM/PM to 24 hours format
		SimpleDateFormat hours24sdf = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
		Date date;
		try {
			date = sdf.parse(time);
			String hours24Format = hours24sdf.format(date);

			Calendar calendar = createCalendarFromMidnight();
			
			if (hours24Format.contains(":")) {
				String[] parts = hours24Format.split(":");
				hours = Integer.valueOf(parts[0]);
				minutes = Integer.valueOf(parts[1]);
			}else {
				hours = Integer.valueOf(hours24Format);
			}
			date = addMinuteHours(calendar, hours, minutes);
		    sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String timestamp = sdf.format(date);
			return this.flightDetailsRepository.getFlightDetailsByDepartureTime(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}

	
	private String createCorrectFormat(String time) {
		String overideTime;
		if(!time.contains(":")) {
			if((time.contains("AM"))){
				String[] parts = time.split("AM");	
				overideTime = parts[0] + ":00AM"; 
				return overideTime;
			}else if((time.contains("PM"))){
				String[] parts = time.split("PM");	
				overideTime = parts[0] + ":00PM";
				return overideTime;
			}
		} 
		// TODO Auto-generated method stub
		return time;
	}


	private Date addMinuteHours(Calendar c,int hours,int minutes) {
		c.add(Calendar.HOUR_OF_DAY, hours); 
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}


	private Calendar createCalendarFromMidnight() {
		 Calendar c = new GregorianCalendar();
		 c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
		 c.set(Calendar.MINUTE, 0);
		 c.set(Calendar.SECOND, 0);
		return c;
	}


	public static Date removeTime(Date date) {    
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime(); 
    }
}
