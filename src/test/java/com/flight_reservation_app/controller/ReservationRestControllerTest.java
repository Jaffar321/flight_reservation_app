package com.flight_reservation_app.controller;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.flight_reservation_app.entity.Reservation;
import com.flight_reservation_app.repository.ReservationRepository;
@SpringBootTest
public class ReservationRestControllerTest {

	
	@InjectMocks
	public ReservationRestController controller;
	
	@Mock
	public ReservationRepository reservationRepo;
	
	@Before
	public void setUp()  {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		Reservation reservation = new Reservation();
		reservation.setId(1);
		reservation.setNumberOfBags(5);
		Optional<Reservation> find =Optional.of(reservation);
		Long id = 1L;
		Mockito.when(reservationRepo.findById(Mockito.any())).thenReturn(find);
		Reservation findReservation = controller.findReservation(id);
		Assert.assertEquals(findReservation.getNumberOfBags(), find.get().getNumberOfBags());
	}

}
