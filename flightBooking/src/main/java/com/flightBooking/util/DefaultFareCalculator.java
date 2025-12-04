package com.flightBooking.util;

import com.flightBooking.model.Flight;

public class
DefaultFareCalculator implements FareCalculator{
	@Override
	public double calculateFare(Flight flight,int seatCount) {
		return flight.getBaseFare()*seatCount;
	}
}
