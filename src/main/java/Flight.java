import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private Airport departure;
    private Airport destination;
    private Date departureTime;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> seatNumbers;

    public Flight(Plane plane, String flightNumber, Airport departure, Airport destination, Date departureTime){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
        this.seatNumbers = new ArrayList<Integer>();
    }

    public int passengerCount() {
        return this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        // if passengers are not booked get, generate the seat numbers
        if (this.passengerCount() == 0) {
            this.generateSeatNumbers();
        }

        int maxWeightAllowance = this.maxWeightAllowance();
        int totalBagsAtPresent = passenger.getNoOfBags();
        int totalBagCount = this.getTotalBagCount();

            // if the passenger count is smaller than total plane capacity
            //AND the passenger list does not contain this passenger
        if (this.passengerCount() < plane.getTotalCapacity() &&
                !this.passengers.contains(passenger) &&
                maxWeightAllowance >= ((totalBagCount + totalBagsAtPresent) * 25)) {

            //when passengerCount is 1 reset totalBagCount to the actual bag count
            if (this.passengerCount() == 1) {
                totalBagCount = this.passengers.get(0).getNoOfBags();
            }

            //add passenger
            this.passengers.add(passenger);

            //add number of bags to total bag count
            totalBagCount = this.getTotalBagCount();

            //set flight number to passenger
            passenger.setFlightNumber(this.flightNumber);

            //shuffle seat numbers
            Collections.shuffle(this.seatNumbers);

            //remove seat number from the array
            Integer seatNumber = this.removeSeatNumber();

            //allocate seat number to passenger
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
