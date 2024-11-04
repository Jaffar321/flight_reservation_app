package com.flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight_reservation_app.dto.ReservationUpdateRequest;
import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.ReservationRepository;

@RestController // it converts the java object into JSON object and JSON object to java object,picking of data from restful url and putting it into	the object done by rest controller
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepo;

	@RequestMapping("/reservation/{id}") // always id in curly braces
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}

	
	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest req) {// it binds the java object
																						// body to json object body
		req.setCheckedIn(true);
		Optional<Reservation> findById = reservationRepo.findById(req.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(req.isCheckedIn());
		reservation.setNumberOfBags(req.getNumberOfBags());
		return reservationRepo.save(reservation);
	}
}
