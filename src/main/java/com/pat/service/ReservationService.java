package com.pat.service;

import java.util.List;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;

public interface ReservationService {
	
	Reservation saveReservation(Reservation reservation);
	Reservation editReservation(Reservation reservation);
	List<Reservation> getAllReservations();
	List<Reservation> getAllUserReservations(User user );
	List<Reservation> getAllFacilityReservations(Facility facility);

}
