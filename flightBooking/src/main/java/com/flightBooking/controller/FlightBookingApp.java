package com.flightBooking.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flightBooking.dto.BookingRequest;
import com.flightBooking.model.Booking;
import com.flightBooking.model.Flight;
import com.flightBooking.model.Passenger;
import com.flightBooking.service.BookingService;
import com.flightBooking.service.FlightService;

public class FlightBookingApp {
	private final FlightService flightService;
	private final BookingService bookingService;
	private final Scanner scanner=new Scanner(System.in);
	public FlightBookingApp(FlightService flightService, BookingService bookingService) {
		super();
		this.flightService = flightService;
		this.bookingService = bookingService;
	}
	private final DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static void main(String[] args) {
	ApplicationContext context= new ClassPathXmlApplicationContext("ApplicationContext.xml");
	FlightService flightService=context.getBean("flightService",FlightService.class);
	BookingService bookingService=context.getBean("bookingService",BookingService.class);
	FlightBookingApp app=new FlightBookingApp(flightService, bookingService);
	app.run();
}
	public void run() {
		while(true) {
			System.out.println("\n==== Flight Booking System ====");
			System.out.println("1. Search Flights");
			System.out.println("2. Book Flights");
			System.out.println("3. View Booking");
			System.out.println("4. Cancel Booking");
			System.out.println("5. Exit");
			System.out.print("Choose Option:");
			
			int choice=Integer.parseInt(scanner.nextLine().trim());
			try {
				switch(choice) {
				case 1:
					searchFlights();
					break;
				case 2:
					bookTicket();
					break;
				case 3:
					viewBooking();
					break;
				case 4:
					cancelBooking();
					break;
				case 5:
					System.out.println("Exiting ....Bye!");
					return;
				default:
					System.out.println("Invalid Choice.");
				}
			}
				catch(Exception e)
				{
					System.out.println("Error: "+e.getMessage());
				}
			}
		}
	

    private void searchFlights() {
        System.out.print("Source (e.g., HYD): ");
        String src = scanner.nextLine().trim();

        System.out.print("Destination (e.g., BLR): ");
        String dest = scanner.nextLine().trim();

        System.out.print("Travel Date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim(), dateFormatter);

        List<Flight> flights = flightService.searchFlights(src, dest, date);
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Available Flights:");
            for (Flight f : flights) {
                System.out.println(f);
            }
        }
    }

    private void bookTicket() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine().trim();

        System.out.print("Travel Date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim(), dateFormatter);

        System.out.print("Number of seats to book: ");
        int seatCount = Integer.parseInt(scanner.nextLine().trim());

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            System.out.println("Enter details for Passenger " + i);
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Gender: ");
            String gender = scanner.nextLine().trim();
            System.out.print("Contact Number: ");
            String contact = scanner.nextLine().trim();
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();

            passengers.add(new Passenger(name, age, gender, contact, email));
        }

        BookingRequest request = new BookingRequest(flightId, date, seatCount, passengers);
        Booking booking = bookingService.createBooking(request);

        System.out.println("Booking created successfully!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Total Amount: " + booking.getTotalAmount());
    }

    private void viewBooking() {
        System.out.print("Enter Booking ID: ");
        String bookingId = scanner.nextLine().trim();

        Booking booking = bookingService.getBooking(bookingId);
        System.out.println("Booking Details:");
        System.out.println(booking);
    }

    private void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = scanner.nextLine().trim();

        Booking booking = bookingService.cancelBooking(bookingId);
        System.out.println("Booking cancelled successfully.");
        System.out.println("Updated Booking: " + booking);
    }
}

