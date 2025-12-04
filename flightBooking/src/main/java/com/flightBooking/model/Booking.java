package com.flightBooking.model;

import java.time.LocalDate;
import java.util.List;

public class Booking {
	private String bookingId;
	private Flight flight;
	private List<Passenger> passengers;
	private LocalDate bookingDate;
	private LocalDate travelDate;
	private double totalAmount;
	private BookingStatus status;
	
	public Booking() {}

	public Booking(String bookingId, Flight flight, List<Passenger> passengers, LocalDate bookingDate,
			LocalDate travelDate, double totalAmount, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
		this.passengers = passengers;
		this.bookingDate = bookingDate;
		this.travelDate = travelDate;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", flight=" + flight + ", totalAmount=" + totalAmount + ", status="
				+ status + "]";
	}
	
	
}
