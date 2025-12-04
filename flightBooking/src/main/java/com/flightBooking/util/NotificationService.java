package com.flightBooking.util;

import com.flightBooking.model.Booking;

public interface NotificationService {
	void sendBookingConfirmation(Booking booking);
	void sendCancellationNotification(Booking booking);
}
