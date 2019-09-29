import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightManagerTest {

    FlightManager flightManager;
    FlightManager flightManager2;
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Passenger passenger6;
    Plane plane;
    Plane plane2;
    Flight flight2;
    Date date;

    @Before
    public void before(){
        date = new Date(119 + 1900, 11, 27, 19, 00 );
        plane = new Plane(PlaneType.CODECLAN200);
        flight = new Flight(plane,
                "CC200",
                Airport.EDI,
                Airport.LAX,
                date
        );
        flightManager = new FlightManager("Pixel", flight);

        plane2 = new Plane(PlaneType.CODECLAN400);
        flight2 = new Flight(plane2,
                "CC400",
                Airport.LAX,
                Airport.AMS,
                date
        );

        flightManager2 = new FlightManager("Domino", flight2);

        passenger1 = new Passenger("Gillian", 2);
        passenger2 = new Passenger("Toby", 2);
        passenger3 = new Passenger("King Kong", 5);
        passenger4 = new Passenger("Luna", 3);
        passenger5 = new Passenger("Dobby", 2);
        passenger6 = new Passenger("Kitty", 4);

    }

    @Test
    public void canGetMaxBagWeightForBags(){
        //Given we have a flight
        assertNotNull(flight);
        //When we calculate the max bag weight
        int maxBagWeight = flightManager.maxBagWeight();
        //Then we should get 250 back
        assertEquals(250, maxBagWeight);

    }

    @Test
    public void canCalculateMaxBagWeightPerPassenger() {
        //Given we have a flight
        assertNotNull(flight);
        //When we calculate max bag weight per person
        int maxBagWeightPerPerson = flightManager.maxBagWeightPerPassenger();
        //Then we should get back 125
        assertEquals(125, maxBagWeightPerPerson);
    }

    @Test
    public void canCheckHowMuchBagWeightBookedByAllPassenger() {
        //Given we have a flight
        assertNotNull(flight);
        //AND there are two passengers booked into the flight
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        //AND each bag is 25 kgs
        //When we check total bags weight of all passengers
        int totalBagWeight = flightManager.totalBagWeight();
        //Then totalBagWeight should be 4 x 25 = 100
        assertEquals(100, totalBagWeight);
    }

    @Test
    public void canCheckBagWeightLeft(){
        //Given we have a flight
        assertNotNull(flight);
        //AND there are two passengers booked into the flight
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        //AND each bag is 25 kgs
        //When we check total bag allowance left
        int totalBagWeightLeft = flightManager.bagCapacityLeft();
        //Then totalBagWeight should be 4 x 25 = 100
        assertEquals(150, totalBagWeightLeft);
    }

    @Test
    public void canSortPassengersBySeatNumber(){
        //Given we have a flight
        assertNotNull(flight2);
        //AND there are five passengers booked into the flight
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        assertNotNull(passenger3);
        assertNotNull(passenger4);
        assertNotNull(passenger5);
        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flight2.addPassenger(passenger3);
        flight2.addPassenger(passenger4);
        flight2.addPassenger(passenger5);
        //When we sort passengers by seat numbers
        flightManager2.sortPassengers();
        //Then the array of passengers should increment per seat number
        //Grab all the seat numbers of all the passengers in order
        Integer seatNumberP1 = flight2.getPassengers().get(0).getSeatNumber();
        Integer seatNumberP2 = flight2.getPassengers().get(1).getSeatNumber();
        Integer seatNumberP3 = flight2.getPassengers().get(2).getSeatNumber();
        Integer seatNumberP4 = flight2.getPassengers().get(3).getSeatNumber();
        Integer seatNumberP5 = flight2.getPassengers().get(4).getSeatNumber();
        //Check if every number that follows is bigger than the one that came before
        Integer subtract1 = seatNumberP2 - seatNumberP1;
        Integer subtract2 = seatNumberP3 - seatNumberP2;
        Integer subtract3 = seatNumberP4 - seatNumberP3;
        Integer subtract4 = seatNumberP5 - seatNumberP4;
        assertTrue(subtract1 > 0);
        assertTrue(subtract2 > 0);
        assertTrue(subtract3 > 0);
        assertTrue(subtract4 > 0);
        //AND flight count remains 5
        assertEquals(5, flight2.passengerCount());
    }

    @Test
    public void canFindPassengerBySeatNumber(){
        //Given we have a flight
        assertNotNull(flight2);
        //AND add passengers to the flight
        assertNotNull(passenger1);
        assertNotNull(passenger2);
        assertNotNull(passenger3);
        assertNotNull(passenger4);
        assertNotNull(passenger5);
        flight2.addPassenger(passenger1);
        flight2.addPassenger(passenger2);
        flight2.addPassenger(passenger3);
        flight2.addPassenger(passenger4);
        flight2.addPassenger(passenger5);
        //AND we have a flight manager;
        assertNotNull(flightManager2);
        //AND as a test add seat number higher than 10
        //as no other passenger should have a number higher than 10
        assertTrue(flight2.maxCapacityForFlight() <= 10);
        Integer number = 15;
        //AND allocate that to a random passenger
        passenger1.allocateSeatNumber(number);
        //When we find passenger by seat number
        Passenger foundPassenger = flightManager2.findPassengerAtSeat(number);
        //Then we should find passenger1
        assertEquals(passenger1, foundPassenger);

    }

}
