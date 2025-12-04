package com.flightBooking.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.flightBooking.model.Flight;
import com.flightBooking.model.FlightStatus;

public class FlightDAOImpl implements FlightDAO {
	private final List<Flight> flights = new ArrayList<>();

	public FlightDAOImpl() {
		flights.add(new Flight("F102", "AirIndia", "Hyd", "Blr", LocalDate.of(2025, 03, 12), LocalTime.of(12, 43),
				LocalTime.of(15, 43), 4000.0, 120, 120, FlightStatus.ACTIVE));
	}

	@Override
	public List<Flight> searchFlights(String source, String destination, LocalDate travelDate) {
		// TODO Auto-generated method stub
		return flights.stream().filter(f->f.getStatus()==FlightStatus.ACTIVE).filter(f->f.getSource().equalsIgnoreCase(source)).filter(f->f.getDestination().equalsIgnoreCase(destination)).filter(f->f.getTravelDate().equals(travelDate)).filter(f->f.getAvailableSeats()>0).collect(Collectors.toList());
	}

	@Override
	public Flight getFlightById(String flightId) {
		// TODO Auto-generated method stub
		return flights.stream().filter(f->f.getFlightId().equalsIgnoreCase(flightId)).findFirst().orElse(null);
	}

	@Override
	public void updateFlight(Flight flight) {
		// TODO Auto-generated method stub
	}
}
