package com.pat.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pat.model.Facility;
import com.pat.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	
	
	@Query("SELECT r FROM Reservation r WHERE r.facility.id = :id "
			+ " and ( r.reservedFrom >= :reservedFrom AND r.reservedFrom <= :reservedTo ) "
			+ " OR ( r.reservedFrom <= :reservedFrom AND r.reservedTo >=  :reservedFrom )")
  List<Reservation> findAllReservation(
  @Param("id") Long id,   
  @Param("reservedFrom") Date reservedFrom, 
  @Param("reservedTo") Date reservedTo);
	
	
	
//	@Query("SELECT Facility FROM Reservation r WHERE r.facility.id = :id ")
//	Facility findFacility (  @Param("id") Long id);
	
	@Query("SELECT r FROM Reservation r WHERE r.facility.id = :id ")
	 List<Reservation> findFacilityReservations (  @Param("id") Long id);
	
	
	@Query("SELECT r FROM Reservation r WHERE r.facility.id = :id ")
	 List<Reservation> findUserReservations (  @Param("id") Long id);

}
