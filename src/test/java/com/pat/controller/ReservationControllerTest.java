package com.pat.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.pat.model.Reservation;
import com.pat.service.ReservationService;

public class ReservationControllerTest {

	@Test 
	void getAllReservations()  {
		List<Reservation> list = new ArrayList<>();
		ReservationService reservationService = Mockito.mock(ReservationService.class);
		when(reservationService.getAllFacilityReservations( (long)1 )).thenReturn(list);
		
		ReservationController reservationController = new ReservationController(reservationService);		
		assertEquals(list, reservationController.getAllFacilityReservations((long)1));
	}
}
