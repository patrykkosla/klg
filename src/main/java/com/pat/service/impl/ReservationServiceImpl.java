package com.pat.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;
import com.pat.repository.FacilityRepository;
import com.pat.repository.ReservationRepository;
import com.pat.service.FacilityService;
import com.pat.service.ReservationService;
import com.pat.service.UserService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	private ReservationRepository reservationrepository;	
	private FacilityService facilityService;	
	private UserService userService;
	EntityManager entityManager;
	
	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationrepository
			, FacilityService facilityService
			, UserService userService
			, EntityManager entityManager
			
			) {
		super();
		this.reservationrepository = reservationrepository;
		this.facilityService = facilityService;
		this.userService = userService;
		this.entityManager = entityManager;
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation editReservation(Reservation reservation) {
		//sprawdz czy istnieje
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Reservation> getAllReservations() {
		return reservationrepository.findAll();
	}	
	
	@Override
	public List<Reservation> getAllUserReservations(String userName) {		
		return reservationrepository.findByReservedBy_UserName( userName);
	}

	@Override
	public List<Reservation> getAllFacilityReservations(Facility facility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation saveReservation(Long facilityId, Long tenantsId, Date reservedFrom, Date reservedTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkIfFasilityIsAvailable(Long facilityId, Date reservedFrom, Date reservedTo) {
		 return reservationrepository.findAllReservation(facilityId, reservedFrom, reservedTo).isEmpty();
	}
	
	@Override
	public Date stringToDate(String date) {	
		return Date.from(LocalDate.parse(date).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	

	public Reservation  createNewReservation( Long facilityId, Date reservedFrom, Date reservedTo, Long userId   ) {
		if (! checkIfFasilityIsAvailable ( facilityId, reservedFrom, reservedTo) ) {
			return null;
		}	
		Facility faclity = facilityService.gateFacilitybyId(facilityId);	
		User user = userService.getUserById(userId);	
		
		Reservation reservation = new Reservation();	
		reservation.setFacility(faclity);
		reservation.setReservedBy(user);
		reservation.setReservedFrom(reservedFrom);
		reservation.setReservedTo(reservedTo);
		this.createReservation(reservation);
		
		return reservation;
	}
	 
    @Transactional
    public Reservation createReservation (Reservation r){
        entityManager.persist(r);
        return r;
    }
	
}
