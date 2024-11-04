package com.flight_reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_reservation_app.dto.ReservationRequest;
import com.flight_reservation_app.entity.Flight;
import com.flight_reservation_app.entity.Passenger;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.FlightRepository;
import com.flight_reservation_app.repository.PassengerRepository;
import com.flight_reservation_app.repository.ReservationRepository;
import com.flight_reservation_app.utilities.EmailUtil;
import com.flight_reservation_app.utilities.PdfGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {

	
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository resereRepo;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		String filePath="E:\\tickets\\";
//		String firstName = request.getFirstName();
//		String lastName = request.getLastName();
//		String middleName = request.getMiddleName();
//		String email = request.getEmail();
//		String phone = request.getPhone();
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName( request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		 String name=request.getFirstName()+" "+request.getMiddleName()+" "+request.getLastName();
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation= new Reservation();
		reservation.setFlight(flight);//OnetoOne
		reservation.setPassenger(passenger);//OnetoOne
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		resereRepo.save(reservation);
		String filepath1=filePath+reservation.getId()+".pdf";
		PdfGenerator pdf=new PdfGenerator();
		pdf.generatePDF(filepath1, name,request.getEmail(), request.getPhone(), flight.getOperatingAirlines(),flight.getDateOfDeparture().toString(), flight.getDepartureCity(), flight.getArrivalCity());
		emailUtil.sendItinerary(passenger.getEmail(), filepath1);
		return reservation;
		
	}

}
