package com.pat;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;

public  class TestLibrary {
	
	
	public static List<Reservation>  getReserwationLList() {
		List<Reservation> reservationsList = new ArrayList<Reservation>();
		Reservation testReservation = new Reservation();
		LocalDate localDate =  LocalDate.of(2022,03,23);
		ZoneId zoneId = ZoneId.of( "Europe/Warsaw" );
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		
		testReservation.setId((long) 224444);
		User u = new User();
		u.setUserId((long) 435345);
		u.setUserName("test user name");
		Facility f = new Facility();
		f.setId((long) 234);
		f.setDescryption("test desc");
		f.setFacilityName("test name");
		f.setOwner(u);
		f.setPricePerDay(333);
		f.setPropertyArea(222);
		testReservation.setFacility(f);
		testReservation.setReservedBy(u);
		testReservation.setReservedFrom(date); 
		testReservation.setReservedTo(date);
		reservationsList.add(testReservation);		
		return reservationsList;
	}

}
