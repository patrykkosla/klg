package com.pat.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pat.model.Reservation;
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
    	testReservation.setId(22);
    	reservationsList.add(testReservation);
    	when(reservationService.getAllFacilityReservations((long) 3)).thenReturn(reservationsList);
    	mockMvc.perform(get("/api/reservations/facility/3"))
    		.andDo(print())
    		.andExpect(status().isOk())
    		.andExpect(content().contentType("List"))
    		.andExpect(content().json(reservationsList.toString()));
    }
    
}
