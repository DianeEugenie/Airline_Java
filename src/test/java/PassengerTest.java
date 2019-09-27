import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Kev", 2);
    }

    @Test
    public void passengerHasName(){
        //Given we have a passenger
        assertNotNull(passenger);
        //When
        //Then the name of the passenger is Kev
        assertEquals("Kev", passenger.getName());
        //AND the total bags of the passenger are 2
        assertEquals(2, passenger.getNoOfBags());
    }

}
