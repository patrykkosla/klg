package com.pat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pat.model.Facility;
import com.pat.service.FacilityService;

@RestController
@RequestMapping("api/facilities")
public class FacilityController {

	private FacilityService facilityService;
	
	public FacilityController(FacilityService facilityServie) {
		super();
		this.facilityService = facilityServie;
	}

	@GetMapping
	public String testController() {
		return "test jest oki";
	}
	
	@PostMapping()
	public ResponseEntity<Facility> saveFacility(@RequestBody Facility facility){
		return new ResponseEntity<Facility>(facilityService.saveFacility(facility), HttpStatus.CREATED);
	}
	
}