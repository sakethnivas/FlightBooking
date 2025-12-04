package com.flightBooking.service;

import com.flightBooking.dto.BookingRequest;
import com.flightBooking.model.Booking;

public interface BookingService {
	Booking createBooking(BookingRequest reqest);
	Booking getBooking(String bookingId);
	Booking cancelBooking(String bookingId);
}
