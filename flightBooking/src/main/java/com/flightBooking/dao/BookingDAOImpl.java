package com.flightBooking.dao;

import java.util.ArrayList;
import java.util.List;

import com.flightBooking.model.Booking;

public class BookingDAOImpl implements BookingDAO{
	
	private final List<Booking> bookings=new ArrayList<>();

	@Override
	public void saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookings.add(booking);
	}

	@Override
	public Booking getBookingById(String bookingId) {
		// TODO Auto-generated method stub
		return bookings.stream().filter(b->b.getBookingId().equalsIgnoreCase(bookingId)).findFirst().orElse(null);
	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		
	}
	
	
}
