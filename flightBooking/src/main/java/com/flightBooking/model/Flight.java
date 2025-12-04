package com.flightBooking.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	private String flightId;
	private String airlineName;
	private String source;
	private String destination;
	private LocalDate travelDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private double baseFare;
	private int totalSeats;
	private int availableSeats;
	private FlightStatus status;

	public Flight() {
	}

	public Flight(String flightId, String airlineName, String source, String destination, LocalDate travelDate,
			LocalTime departureTime, LocalTime arrivalTime, double baseFare, int totalSeats, int availableSeats,
			FlightStatus status) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.baseFare = baseFare;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.status = status;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", source=" + source + ", destination="
				+ destination + ", travelDate=" + travelDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", baseFare=" + baseFare + ", totalSeats=" + totalSeats + ", availableSeats="
				+ availableSeats + ", status=" + status + "]";
	}

}
