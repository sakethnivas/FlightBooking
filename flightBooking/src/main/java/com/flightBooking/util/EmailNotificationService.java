package com.flightBooking.util;

import com.flightBooking.model.Booking;

public class EmailNotificationService implements NotificationService{

	@Override
	public void sendBookingConfirmation(Booking booking) {
		// TODO Auto-generated method stub
		System.out.println("=== EMAIL CONFIRMATION ===");
		System.out.println("Booking CONFIRMED with ID:"+booking.getBookingId());
		System.out.println("Flight:"+booking.getFlight().getFlightId());
		System.out.println("Total Amount:"+booking.getTotalAmount());
		System.out.println("==========================");
	}

	@Override
	public void sendCancellationNotification(Booking booking) {
		// TODO Auto-generated method stub
		System.out.println("=== EMAIL CONFIRMATION ===");
		System.out.println("Booking CANCELLED with ID:"+booking.getBookingId());
		System.out.println("refund processed (80% of amount).");
		System.out.println("==========================");
	}

	
}
