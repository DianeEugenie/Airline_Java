import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CODECLAN200);
        flight = new Flight(plane,
                "CC200",
                Airport.EDI,
                Airport.LAX,
                "19:00"
        );
        flightManager = new FlightManager("Pixel", flight);

        passenger1 = new Passenger("Gillian", 2);
        passenger2 = new Passenger("Toby", 2);
        passenger3 = new Passenger("King Kong", 5);
    }

    @Test
    public void canCalculateMaxBagWeightPerPassenger(){
        //Given we have a flight
        assertNotNull(flight);
        //When we calculate the max bag weight
        int maxBagWeight = flightManager.maxBagWeight();
        //Then we should get 250 back
        assertEquals(250, maxBagWeight);


    }

}
