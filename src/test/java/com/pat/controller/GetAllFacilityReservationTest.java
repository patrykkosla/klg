package com.pat.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pat.model.Facility;
import com.pat.model.Reservation;
import com.pat.model.User;
import com.pat.service.ReservationService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest
public class GetAllFacilityReservationTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean	
    private ReservationService reservationService;
    @MockBean	
    private FacilityController facilityController;  
  
 
    @Test
    void shouldGetListofReservations() throws Exception {
    	List<Reservation> reservationsList = new ArrayList<>();
    	Reservation testReservation = new Reservation();
    	testReservation.setId((long) 224444);
    	Facility f = new Facility();
    	f.setId((long) 234);
    	User u = new User();
    	u.setUserId((long) 435345);
    	u.setUserName("test user name");
    	testReservation.setFacility(f);
    	testReservation.setReservedBy(u);
    	reservationsList.add(testReservation);
    	
    	
//    	testReservation.setId(23);
//    	reservationsList.add(testReservation);
    	when(reservationService.getAllFacilityReservations((long) 3)).thenReturn(reservationsList);
    	mockMvc.perform(get("/api/reservations/facility/3"))
    		.andExpect(status().isOk())
   	        .andExpect(content().json("[{\"id\":224444,\"facility\":{\"id\":234,\"facilityName\":null,\"pricePerDay\":0.0,\"propertyArea\":0.0,\"descryption\":null,\"owner\":null},\"reservedBy\":{\"userId\":435345,\"userName\":\"test user name\"},\"reservedFrom\":null,\"reservedTo\":null,\"reservationCost\":0.0}]")
    				);
    }
    
}
