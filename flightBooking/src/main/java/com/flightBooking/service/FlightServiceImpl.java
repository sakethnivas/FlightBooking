package com.flightBooking.service;

import java.time.LocalDate;
import java.util.List;

import com.flightBooking.dao.FlightDAO;
import com.flightBooking.model.Flight;

public class FlightServiceImpl implements FlightService{
	private final FlightDAO flightDAO;

	public FlightServiceImpl(FlightDAO flightDAO) {
		super();
		this.flightDAO = flightDAO;
	}

	@Override
	public List<Flight> searchFlights(String source, String destination, LocalDate travelDate) {
		// TODO Auto-generated method stub
		return flightDAO.searchFlights(source, destination, travelDate);
	}

	@Override
	public Flight getFlightDetails(String flightId) {
		// TODO Auto-generated method stub
		return flightDAO.getFlightById(flightId);
	}
	
	
}
