import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightTest {

    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Plane plane;
    PlaneType planeType;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CODECLAN100);
        flight = new Flight(plane,
                "CC100",
                Airport.AMS,
                Airport.EDI,
                "12:00"
        );
    }


    @Test
    public void planeStartsEmpty(){
        //Given we have a plane
        assertNotNull(plane);
        //When no seats have been booked
        //Then the capacity should be 2
        assertEquals(2, this.plane.getTotalCapacity());
        //AND there should be no passengers on the plane
        assertEquals(0, flight.passengerCount());
    }

}
