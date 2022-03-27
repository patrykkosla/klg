package com.pat.service;

import java.util.List;
import com.pat.model.Facility;

public interface FacilityService {
	
	Facility saveFacility(Facility facility);
	List<Facility> getAllFacilities();

}
