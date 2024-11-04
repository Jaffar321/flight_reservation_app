package com.flight_reservation_app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {
@Query("from Flight where departure_City=:departureCity and arrival_City=:arrivalCity and date_Of_Departure=:dateOfDeparture")
List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity")  String to,@Param("dateOfDeparture")  Date departureDate);
	

}
