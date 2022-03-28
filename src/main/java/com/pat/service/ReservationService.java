package com.pat.service;

import java.util.Date;
import java.util.List;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;

public interface ReservationService {
	
	Reservation saveReservation(Reservation reservation);
	Reservation saveReservation(Long  facilityId, Long tenantsId, Date reservedFrom,  Date reservedTo);
	Reservation editReservation(Reservation reservation);
	Reservation createNewReservation(Long facilityId, Date reservedFrom, Date reservedTo, Long userId, double reservationCost);	
	
	List<Reservation> getAllReservations();
	List<Reservation> getAllUserReservations(String user );
	List<Reservation> getAllFacilityReservations(Long facilityId);
	Boolean checkIfFasilityIsAvailable(Long facilityId, Date reservedFrom, Date reservedTo);	
	
	
	Date stringToDate(String date);
}