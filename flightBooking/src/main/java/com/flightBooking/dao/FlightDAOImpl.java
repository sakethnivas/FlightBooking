package com.flightBooking.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.flightBooking.model.Flight;
import com.flightBooking.model.FlightStatus;

public class FlightDAOImpl implements FlightDAO{
	private final List<Flight> flights=new ArrayList<>();
	public FlightDAOImpl() {
	flights.add(new Flight("F102","AirIndia","Hyd","Blr",LocalDate.of(2025,03,12),LocalTime.of(12,43),LocalTime.of(15,43),4000.0,120,120,FlightStatus.ACTIVE));
	}
	@Override
	public List<Flight> searchFlights(String source, String destination, LocalDate travelDate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Flight getFlightById(String flightId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}
}
	
