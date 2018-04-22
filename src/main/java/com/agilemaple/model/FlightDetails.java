package com.agilemaple.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@SqlResultSetMapping(
	    name="flightDetailsMapping",
	    classes={
	        @ConstructorResult(
	            targetClass=FlightDetails.class,
	            columns={
	            		 @ColumnResult(name="flightId"),
                         @ColumnResult(name="flightCode"),
                         @ColumnResult(name="flightOperator"),
                         @ColumnResult(name="flightFrom"),
                         @ColumnResult(name="flightTo"),
                         @ColumnResult(name="departureTime"),
                         @ColumnResult(name="arrivalTime"),
                         @ColumnResult(name="duration"),
                         @ColumnResult(name="totalSeats")
	            }
	        )
	    }
	)
@NamedNativeQuery(name = "FlightDetails.getFlightDetailsByDepartureTime", query = "SELECT f.flight_id AS flightId,f.flight_code AS flightCode,f.flight_operator AS flightOperator,f.flight_from AS flightFrom,f.flight_to AS flightTo,f.departure_time AS departureTime,f.arrival_time AS arrivalTime,f.duration AS duration,f.total_seats AS totalSeats FROM flight_details f"
		+ " where `departure_time` <= DATE_ADD(CONCAT(?1),INTERVAL 5 HOUR)  AND `departure_time` >= DATE_SUB(CONCAT(?1),INTERVAL 5 HOUR)", resultSetMapping="flightDetailsMapping")
@Table(name="flight_details")
public class FlightDetails implements Serializable{
	
	private static final long serialVersionUID = -1042700675059000637L;

	
	
	public FlightDetails(int flightId, String flightCode, String flightOperator, String flightFrom, String flightTo,
			Date departureTime, Date arrivalTime, int duration, int totalSeats) {
		this.flightId = flightId;
		this.flightCode = flightCode;
		this.flightOperator = flightOperator;
		this.flightFrom = flightFrom;
		this.flightTo = flightTo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.totalSeats = totalSeats;
	}

	@Id
	@Column(name="flight_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	
	@Column(name="flight_code")
	private  String flightCode;
	
	@Column(name="flight_operator")
	private String flightOperator;
	
	@Column(name="flight_from")
	private String flightFrom;
	
	@Column(name="flight_to")
	private String flightTo;
	
	@Column(name="departure_time")
	private Date departureTime;
	
	@Column(name="arrival_time")
	private Date arrivalTime;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="total_seats")
	private int totalSeats;
	
	
	public int getFlightId() {
		return flightId;
	}
	
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	
	public String getFlightOperator() {
		return flightOperator;
	}
	
	public void setFlightOperator(String flightOperator) {
		this.flightOperator = flightOperator;
	}
	
	public String getFlightFrom() {
		return flightFrom;
	}
	
	public void setFlightFrom(String flightFrom) {
		this.flightFrom = flightFrom;
	}
	
	public String getFlightTo() {
		return flightTo;
	}
	
	public void setFlightTo(String flightTo) {
		this.flightTo = flightTo;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
 }
