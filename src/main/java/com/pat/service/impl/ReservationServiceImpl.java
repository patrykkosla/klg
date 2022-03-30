package com.pat.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;
import com.pat.repository.ReservationRepository;
import com.pat.service.FacilityService;
import com.pat.service.ReservationService;
import com.pat.service.UserService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	private final ReservationRepository reservationrepository;
	private final FacilityService facilityService;
	private final UserService userService;
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
	public Reservation editReservation(Reservation newR) {
		Reservation oldR ;
		try {
			oldR = reservationrepository.getById(newR.getId());	
		} catch (Exception e) {
			return null;	
		}		
		if ( this.checkIfDatesAreDiffrent(oldR, newR) ) {
			if(!this.checkIfFasilityIsAvailable(oldR.getFacility().getId(), newR.getReservedFrom(), newR.getReservedTo())) {
				 return null;	
			}
				oldR.setReservedFrom(newR.getReservedFrom());
				oldR.setReservedTo(newR.getReservedTo());
		}
		oldR.setReservationCost(newR.getReservationCost());

		User user;
		try {
			user = this.userService.getUserById(newR.getReservedBy().getUserId());
		} catch (Exception e) {
			return null; 
		}
		if( user != newR.getReservedBy()){
			oldR.setReservedBy(user);
		}
		
		this.saveEditedReservation(oldR);
		return oldR;
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
	public List<Reservation> getAllFacilityReservations(Long facilityId) {
		 return reservationrepository.findByFacility_Id(facilityId);
	}

	@Override
	public Boolean checkIfFasilityIsAvailable(Long facilityId, Date reservedFrom, Date reservedTo) {
		 return reservationrepository.findAllReservation(facilityId, reservedFrom, reservedTo).isEmpty();
	}

	@Override
	public Date stringToDate(String date) {
		return Date.from(LocalDate.parse(date).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}


	@Override
	public Reservation  createNewReservation( Long facilityId, Date reservedFrom, Date reservedTo, Long userId, double reservationCost   ) {
		if (! checkIfFasilityIsAvailable ( facilityId, reservedFrom, reservedTo) ) {
			return null;
		}
		Facility fasility = facilityService.gateFacilitybyId(facilityId);
		User user = userService.getUserById(userId);

		Reservation reservation = new Reservation();
		reservation.setFacility(fasility);
		reservation.setReservedBy(user);
		reservation.setReservedFrom(reservedFrom);
		reservation.setReservedTo(reservedTo);
		reservation.setReservationCost(reservationCost);
		this.createReservation(reservation);

		return reservation;
	}
	
	@Override
    @Transactional
    public Reservation createReservation (Reservation r){
        entityManager.persist(r);
        return r;
    }
	
	@Override
    @Transactional
    public Reservation saveEditedReservation (Reservation r){
    	entityManager.merge(r);
    	  return r;
    }

    public Boolean checkIfDatesAreDiffrent(Reservation oldR, Reservation newR) {
    	return (oldR.getReservedFrom()  != newR.getReservedFrom() ) ||	(oldR.getReservedTo()	!= newR.getReservedTo());  
    }
    
    

}
