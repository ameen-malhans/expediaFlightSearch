package com.agilemaple.exception;

public class FlightSearchException extends Exception{
	  public FlightSearchException() { super(); }
	  public FlightSearchException(String message) { super(message); }
	  public FlightSearchException(String message, Throwable cause) { super(message, cause); }
	  public FlightSearchException(Throwable cause) { super(cause); }
}
