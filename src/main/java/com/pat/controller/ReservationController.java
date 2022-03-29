package com.pat.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pat.model.Reservation;
import com.pat.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@GetMapping
	public List<Reservation> getAllReservations(){
		return reservationService.getAllReservations();
	}

	@GetMapping("/tenant/{userName}")
	public List<Reservation> getReservationsByTenants(@PathVariable("userName") String userName){
		return reservationService.getAllUserReservations(userName);
	}

	@GetMapping("/facility/{id}")
	public List<Reservation> getAllFacilityReservations(@PathVariable("id") Long id){
		return reservationService.getAllFacilityReservations(id);
	}


	@PostMapping("/new/{facilityId}/{reservedFrom}/{reservedTo}/{userId}/{reservationCost}")
	public ResponseEntity<Reservation> createNewReservation(
			@PathVariable("facilityId" )Long facilityId,
			@PathVariable("reservedFrom" )String reservedFrom,
			@PathVariable("reservedTo" )String reservedTo,
			@PathVariable("userId" )Long  userId,
			@PathVariable("reservationCost")double reservationCost){

		 Date reservedFromDate = reservationService.stringToDate(reservedFrom);
		 Date reservedToDate = reservationService.stringToDate(reservedTo);
		 return new ResponseEntity<>(
			  reservationService.createNewReservation( facilityId,  reservedFromDate, reservedToDate, userId, reservationCost),
			  HttpStatus.CREATED);
	}

	@PutMapping("/edit")
	@ResponseBody 
	public ResponseEntity<Reservation> editReservation(@RequestBody Reservation reservation ) {	
		Reservation r = reservationService.editReservation(reservation);
		if( r == null) {
			return new ResponseEntity<>( r ,  HttpStatus.CONFLICT);
		}		 
		return new ResponseEntity<>( r ,  HttpStatus.OK);
	}
}
//1648591200