package com.pat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.pat.repository.FacilityRepository;
import com.pat.model.Facility;
import com.pat.service.FacilityService;

@Service 
public class FacilityServiceImpl implements FacilityService {
	
	private FacilityRepository facilityRepository;
	
	public FacilityServiceImpl(FacilityRepository facilityRepository) {
		super();
		this.facilityRepository = facilityRepository;
	}
	
	@Override
	public Facility saveFacility(Facility facility) {		
		return facilityRepository.save(facility);
	}

	@Override
	public List<Facility> getAllFacilities() {
		return facilityRepository.findAll();
	}

	@Override
	public Facility gateFacilitybyId(Long id) {
		return facilityRepository.getById(id);
	}
}
