import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
   // private String departureTime;
    private Date departureTime;
    private ArrayList<Passenger> passengers;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, Date departureTime){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
       // this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
    }

    public int passengerCount() {
        return this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (this.passengerCount() < plane.getTotalCapacity()) {
            this.passengers.add(passenger);
        }
    }

    public int checkAvailableSeats() {
        return this.plane.getTotalCapacity() - this.passengerCount();
    }

    public int maxWeightAllowance() {
        return this.plane.getPlaneWeight() / 2;
    }

    public int maxCapacityForFlight() {
        return this.plane.getTotalCapacity();
    }

    public int getTotalBagCount() {
        int totalBags = 0;

        for (Passenger passenger: this.passengers) {
            int noOfBags = passenger.getNoOfBags();
            totalBags += noOfBags;
        }

        return totalBags;

    }






    //GETTERS AND SETTERS
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }


    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }



}
