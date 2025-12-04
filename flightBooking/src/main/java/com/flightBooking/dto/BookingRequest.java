package com.flightBooking.dto;

import java.time.LocalDate;
import java.util.List;

import com.flightBooking.model.Passenger;

public class BookingRequest {
	private String flightId;
	private LocalDate travelDate;
	private int seatCount;
	private List<Passenger> passengers;
	
	public BookingRequest() {}

	public BookingRequest(String flightId, LocalDate travelDate, int seatCount, List<Passenger> passengers) {
		super();
		this.flightId = flightId;
		this.travelDate = travelDate;
		this.seatCount = seatCount;
		this.passengers = passengers;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
