package com.flightBooking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.flightBooking.dao.BookingDAO;
import com.flightBooking.dao.FlightDAO;
import com.flightBooking.dto.BookingRequest;
import com.flightBooking.model.Booking;
import com.flightBooking.model.BookingStatus;
import com.flightBooking.model.Flight;
import com.flightBooking.model.Passenger;
import com.flightBooking.util.FareCalculator;
import com.flightBooking.util.NotificationService;

public class BookingServiceImpl implements BookingService{
	
	private final BookingDAO bookingDAO;
	private final FlightDAO flightDAO;
	private final FareCalculator fareCalculator;
	private NotificationService notificationService;
	
	
	public BookingServiceImpl(BookingDAO bookingDAO, FlightDAO flightDAO, FareCalculator fareCalculator) {
		this.bookingDAO = bookingDAO;
		this.flightDAO = flightDAO;
		this.fareCalculator = fareCalculator;
	}
	
	

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}



	@Override
	public Booking createBooking(BookingRequest request) {
		// TODO Auto-generated method stub
		Flight flight=flightDAO.getFlightById(request.getFlightId());
		if(flight==null) {
			throw new IllegalArgumentException("Invalid flight Id");
		}
		if (!flight.getTravelDate().equals(request.getTravelDate())) {
			throw new IllegalArgumentException("Flight not available on selected date");
		}
		int seatCount=request.getSeatCount();
		if(seatCount<=0) {
			throw new IllegalArgumentException("seat count must be > 0");
		}
		List<Passenger> passengers = request.getPassengers();
		if (passengers==null||passengers.isEmpty()) {
			throw new IllegalArgumentException("At least one passenger required.");
		}
		double totalFare=fareCalculator.calculateFare(flight, seatCount);
		String bookingId= "BKG-"+UUID.randomUUID().toString().substring(0,8).toUpperCase();
		LocalDate bookingDate=LocalDate.now();
		
		Booking booking=new Booking(bookingId,flight,passengers,bookingDate,request.getTravelDate(),totalFare,BookingStatus.CONFIRMED);
		
		flight.setAvailableSeats(flight.getAvailableSeats()-seatCount);
		flightDAO.updateFlight(flight);
		bookingDAO.saveBooking(booking);
		if(notificationService!=null) {
			notificationService.sendBookingConfirmation(booking);
		}
		return booking;
	}

	@Override
	public Booking getBooking(String bookingId) {
		// TODO Auto-generated method stub
		Booking booking=bookingDAO.getBookingById(bookingId);
		if(booking==null) {
			throw new IllegalArgumentException("Booking not found");
		}
		return booking;
				
	}

	@Override
	public Booking cancelBooking(String bookingId) {
		// TODO Auto-generated method stub
		Booking booking=bookingDAO.getBookingById(bookingId);
		if(booking==null) {
			throw new IllegalArgumentException("Booking not found");
	}
		if (booking.getStatus()!=BookingStatus.CONFIRMED) {
			throw new IllegalArgumentException("Only Confirmed bookings can be cancelled");
		}
booking.setStatus(BookingStatus.CANCELLED);
Flight flight=booking.getFlight();
int seatCount=booking.getPassengers().size();
flight.setAvailableSeats(flight.getAvailableSeats()+seatCount);
flightDAO.updateFlight(flight);
bookingDAO.updateBooking(booking);

double refundAmount=booking.getTotalAmount()*0.8;
System.out.println("Refund Amount (80%)"+ refundAmount);
if (notificationService!=null) {
	notificationService.sendCancellationNotification(booking);
}
return booking;
}
}