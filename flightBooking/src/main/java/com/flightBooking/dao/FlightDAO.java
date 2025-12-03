package com.flightBooking.dao;

import java.time.LocalDate;
import java.util.List;

import com.flightBooking.model.Flight;

public interface FlightDAO {
	List<Flight> searchFlights(String source,String destination,LocalDate travelDate);
	Flight getFlightById(String flightId);
	void updateFlight(Flight flight);
}
