package com.pat.service.impl;

import java.util.List;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;
import com.pat.repository.ReservationRepository;
import com.pat.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	
	private ReservationRepository reservationrepository;	

	public ReservationServiceImpl(ReservationRepository reservationrepository) {
		super();
		this.reservationrepository = reservationrepository;
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation editReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Reservation> getAllReservations() {
		return reservationrepository.findAll();
	}	
	
	@Override
	public List<Reservation> getAllUserReservations(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllFacilityReservations(Facility facility) {
		// TODO Auto-generated method stub
		return null;
	}

}
