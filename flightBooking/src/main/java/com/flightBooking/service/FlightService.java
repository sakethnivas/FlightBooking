package com.flightBooking.service;

import java.time.LocalDate;
import java.util.List;

import com.flightBooking.model.Flight;

public interface FlightService {
	List<Flight> searchFlights(String source, String destination,LocalDate travelDate);
	Flight getFlightDetails(String flightId);
}
