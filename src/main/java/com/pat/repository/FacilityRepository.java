package com.pat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pat.model.Facility;

public interface FacilityRepository  extends JpaRepository<Facility, Long>{

}
