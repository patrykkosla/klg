package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pat.model.Reservation;
import com.pat.repository.ReservationRepository;
import com.pat.service.impl.ReservationServiceImpl;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ReservationServiceTest {
	
	@MockBean
	private ReservationRepository reservationRepository;
		
	@InjectMocks
	private ReservationServiceImpl reservationServiceImpl ;
	
	@Test
	public void getAllFacilityReservationsTest() {		
		List<Reservation> reservationsList = new ArrayList<>();	
    	Reservation testReservation = new Reservation();
    	testReservation.setId(22);
    	reservationsList.add(testReservation);
    	
    	
		Mockito.when(reservationRepository.findByFacility_Id( (long) 22)).thenReturn(reservationsList);
		
		List<Reservation> resultList = reservationServiceImpl.getAllFacilityReservations((long) 22);
		
		assertEquals(reservationsList,resultList );
	}

}
