package com.flight_reservation_app.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departure_date") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate , ModelMap model) {
		List<Flight> findFlights = flightRepo.findFlights(from,to,departureDate);
		model.addAttribute("findFlight", findFlights);
		return "Login/displayFlights";
	}
	@RequestMapping("/showCompleteReservation")
public String showCompleteReservation(@RequestParam("flightId") Long flightId ,ModelMap model) {
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		model.addAttribute("flight", flight);
		
		
//		System.out.println(flight.getId());
//		System.out.println(flight.getArrivalCity());
//		System.out.println(flight.getDepartureCity());
//		System.out.println(flight.getFlightNumber());
//		System.out.println(flight.getOperatingAirlines());
//		System.out.println(flight.getEstimatedDepartureTime());
//		System.out.println(flightId);
	return "Login/showReservation";
}
}
