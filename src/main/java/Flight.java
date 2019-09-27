import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
   // private String departureTime;
    private Date departureTime;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> seatNumbers;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, Date departureTime){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
       // this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
        this.seatNumbers = new ArrayList<Integer>();
    }

    public int passengerCount() {
        return this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if (this.passengerCount() == 0) {
            this.generateSeatNumbers();
        }

        if (this.passengerCount() < plane.getTotalCapacity() && !this.passengers.contains(passenger)) {
            this.passengers.add(passenger);
            passenger.setFlightNumber(this.flightNumber);

            Collections.shuffle(this.seatNumbers);

            Integer seatNumber = this.removeSeatNumber();
            passenger.allocateSeatNumber(seatNumber);
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

    public int seatNumberCount(){
        return this.seatNumbers.size();
    }

    public void generateSeatNumbers() {
        Integer seatNumber = 1;

        for (int i = 0; i < this.maxCapacityForFlight() ; i++) {
            this.seatNumbers.add(seatNumber);
            seatNumber++;
        }

    }

    public Integer removeSeatNumber() {
        Integer seatNumber = 0;

        if (this.seatNumberCount() > 0) {
            seatNumber = this.seatNumbers.remove(0);
        }

        return seatNumber;
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


    public ArrayList<Integer> getSeatNumbers() {
        return seatNumbers;
    }



}
