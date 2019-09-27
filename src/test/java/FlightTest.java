import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightTest {

    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Plane plane;
    Date departureTime;

    @Before
    public void before(){
        departureTime = new Date(2019, 11, 27, 19, 00 );
        //departureTime = new Date(2019, 11, 27);
        plane = new Plane(PlaneType.CODECLAN100);
        flight = new Flight(plane,
                "CC100",
                Airport.AMS,
                Airport.EDI,
                departureTime
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

    @Test
    public void canGetMaxCapacityForFlight(){
        //Given we have a flight
        assertNotNull(flight);
        //When we check max capacity
        int maxCapacityForFlight = flight.maxCapacityForFlight();
        //Then we get back 2
        assertEquals(2, maxCapacityForFlight);
    }

    @Test
    public void canGetNumberOfTotalBags(){
        //Given we have a flight
        assertNotNull(flight);
        //AND there are two passengers on the flight
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        //AND the passengers have a total of 4 bags
        //When we check total of bags
        int totalPassengerBags = flight.getTotalBagCount();
        //Then we get returned 4
        assertEquals(4, totalPassengerBags);

    }

    @Test
    public void canGetDateOfFlight(){
        //Given we have a flight
        assertNotNull(flight);
        //When we check the date
        Date depDate = flight.getDepartureTime();
        //Then it should return today
        assertEquals(departureTime, depDate);
        assertEquals(11, depDate.getMonth());
    }

    @Test
    public void canAddFlightNumberToPassenger(){
        //Given we have a flight
        assertNotNull(flight);
        //AND we have a passenger
        assertNotNull(passenger1);
        //When we add passenger to flight
        flight.addPassenger(passenger1);
        //Then the passenger should have flight Number CC100
        assertEquals("CC100", flight.getPassengers().get(0).getFlightNumber());
    }

}
