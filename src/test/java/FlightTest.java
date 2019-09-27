import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightTest {

    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CODECLAN100);
        flight = new Flight(plane,
                "CC100",
                Airport.AMS,
                Airport.EDI,
                "12:00"
        );

        passenger1 = new Passenger("Gillian", 2);
        passenger2 = new Passenger("Toby", 2);
        passenger3 = new Passenger("King Kong", 5);
    }


    @Test
    public void startsEmpty(){
        //Given we have a plane
        assertNotNull(plane);
        //When no seats have been booked
        //Then the capacity should be 2
        assertEquals(2, this.plane.getTotalCapacity());
        //AND there should be no passengers on the plane
        assertEquals(0, flight.passengerCount());
    }

    @Test
    public void hasDestinationAndDeparture(){
        //Given we have a plane
        assertNotNull(plane);
        //AND a flight
        assertNotNull(flight);
        //When
        //Then the destination should return Edinburgh
        assertEquals("Edinburgh", flight.getDestination().getFullName());
        //AND the departure airport should return Amsterdam
        assertEquals("Amsterdam", flight.getDeparture().getFullName());
    }

    @Test
    public void canAddPassenger(){
        //Given we have a plane
        assertNotNull(plane);
        //AND a flight
        assertNotNull(flight);
        //AND we have a passenger
        assertNotNull(passenger1);
        //When we add the passenger to the flight
        flight.addPassenger(passenger1);
        //Then the passengerCount should be 1
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void cannotAddMorePassengersThanMaxCapacity(){
        //Given we have a plane
        assertNotNull(plane);
        //AND a flight
        assertNotNull(flight);
        //AND we have added two passengers
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        //When we add a third passenger to the flight
        flight.addPassenger(passenger3);
        //Then the passengerCount should still be 2;
        assertEquals(2, flight.passengerCount());
    }

    @Test
    public void canCheckSeatAvailability(){
        //Given we have a plane
        assertNotNull(plane);
        //AND a flight
        assertNotNull(flight);
        //AND we have a passenger
        assertNotNull(passenger1);
        //AND the passenger has been added to the flight
        flight.addPassenger(passenger1);
        //When we check the availability
        int seatsAvailable = flight.checkAvailableSeats();
        //Then the available seats should be 1
        assertEquals(1, seatsAvailable);
    }

    @Test
    public void canGetMaxBagAllowancePerPassenger(){
        //Given we have a flight
        assertNotNull(flight);
        //When we check max allowance
        int maxWeightAllowance = flight.maxWeightAllowance();
        //Then we get back is 50
        assertEquals(50, maxWeightAllowance);
    }

}
