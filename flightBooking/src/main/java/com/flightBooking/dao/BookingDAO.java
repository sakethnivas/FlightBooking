package com.flightBooking.dao;

import com.flightBooking.model.Booking;

public interface BookingDAO {

	void saveBooking(Booking booking);
	Booking getBookingById(String bookingId);
	void updateBooking(Booking booking);
}
