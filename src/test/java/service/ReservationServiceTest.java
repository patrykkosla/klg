package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pat.TestLibrary;
import com.pat.model.Reservation;
import com.pat.repository.ReservationRepository;
import com.pat.service.impl.ReservationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
	
	@Mock
	ReservationRepository reservationRepository;
		
	@InjectMocks
	ReservationServiceImpl reservationServiceImpl ;
	
	@Test
	public void getAllFacilityReservationsTest() {		
    	List<Reservation> reservationsList = TestLibrary.getReserwationLList();	  		
		when(reservationRepository.findByFacility_Id( (long) 22)).thenReturn(reservationsList);
		
		List<Reservation> resultList = reservationServiceImpl.getAllFacilityReservations((long) 22);
		System.out.println(resultList);
				
		assertEquals(reservationsList,resultList );
	}

}
