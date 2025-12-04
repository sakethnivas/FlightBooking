package com.flightBooking.util;

import com.flightBooking.model.Flight;

public interface FareCalculator {
	double calculateFare(Flight flight,int seatCount);
}
