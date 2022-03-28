package com.pat.service;

import java.util.List;
import java.util.Optional;

import com.pat.model.Facility;

public interface FacilityService {
	
	Facility saveFacility(Facility facility);
	
	List<Facility> getAllFacilities();
	
	Facility gateFacilitybyId(Long id);
}
