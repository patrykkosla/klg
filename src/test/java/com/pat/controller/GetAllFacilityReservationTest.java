package com.pat.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import com.pat.TestLibrary;
import com.pat.model.Reservation;
import com.pat.service.ReservationService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



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
    	List<Reservation> reservationsList = TestLibrary.getReserwationLList();	
    	
    	when(reservationService.getAllFacilityReservations((long) 3)).thenReturn(reservationsList);
    	mockMvc.perform(get("/api/reservations/facility/3"))
    		.andExpect(status().isOk())
   	        .andExpect(content().json(" [{\"id\":224444,\"facility\":{\"id\":234,\"facilityName\":\"test name\",\"pricePerDay\":333.0,\"propertyArea\":222.0,\"descryption\":\"test desc\",\"owner\":{\"userId\":435345,\"userName\":\"test user name\"}},\"reservedBy\":{\"userId\":435345,\"userName\":\"test user name\"},\"reservedFrom\":\"2022-03-22T23:00:00.000+00:00\",\"reservedTo\":\"2022-03-22T23:00:00.000+00:00\",\"reservationCost\":0.0}]") );
    }    
}
