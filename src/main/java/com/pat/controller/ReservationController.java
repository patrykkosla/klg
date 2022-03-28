package com.pat.controller;

import java.util.Date;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/new/{facilityId}/{reservedFrom}/{reservedTo}/{userId}")
	public ResponseEntity<Reservation> createNewReservation(
			@PathVariable("facilityId" )Long facilityId,
			@PathVariable("reservedFrom" )String reservedFrom, 
			@PathVariable("reservedTo" )String reservedTo, 
			@PathVariable("userId" )Long  userId){			
			
	
		 Date reservedFromDate = reservationService.stringToDate(reservedFrom);
		 Date reservedToDate = reservationService.stringToDate(reservedTo);
		 return new ResponseEntity<Reservation>(
			  reservationService.createNewReservation( facilityId,  reservedFromDate, reservedToDate, userId),
			  HttpStatus.CREATED);
	} 
	
	@PostMapping("/edit/{reservation}")
	public ResponseEntity<Reservation> editReservation(Reservation reservation ) {
		 return new ResponseEntity<Reservation>(
			reservationService.editReservation(reservation),
			HttpStatus.OK );
	}
}
//1648591200