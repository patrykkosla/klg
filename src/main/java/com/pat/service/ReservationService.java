package com.pat.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pat.model.Reservation;

public interface ReservationService {
	Reservation createReservation (Reservation r);
	Reservation saveEditedReservation (Reservation r);
	Reservation editReservation(Reservation reservation);
	Reservation createNewReservation(Long facilityId, Date reservedFrom, Date reservedTo, Long userId, double reservationCost);

	List<Reservation> getAllReservations();
	List<Reservation> getAllUserReservations(String user );
	List<Reservation> getAllFacilityReservations(Long facilityId);
	Boolean checkIfFasilityIsAvailable(Long facilityId, Date reservedFrom, Date reservedTo);


	Date stringToDate(String date);
}