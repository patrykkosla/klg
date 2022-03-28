package com.pat.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/new/{facilityId}/{reservedFrom}/{reservedTo}/{userId}")
	public Reservation createNewReservation(
			@PathVariable("facilityId" )Long facilityId,
			@PathVariable("reservedFrom" )String reservedFrom, 
			@PathVariable("reservedTo" )String reservedTo, 
			@PathVariable("userId" )Long  userId){			
			
	
		 Date reservedFromDate = reservationService.stringToDate(reservedFrom);
		 Date reservedToDate = reservationService.stringToDate(reservedTo);
		 
	 return reservationService.createNewReservation( facilityId,  reservedFromDate, reservedToDate, userId);
	} 
}
//1648591200