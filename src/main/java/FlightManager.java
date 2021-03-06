import java.util.ArrayList;

public class FlightManager {

    private String name;
    private Flight flight;

    public FlightManager(String name, Flight flight) {
        this.name = name;
        this.flight = flight;
    }

    public int maxBagWeight() {
        return this.flight.maxWeightAllowance();
    }

    public int maxBagWeightPerPassenger() {
        return this.maxBagWeight() / this.flight.maxCapacityForFlight();
    }

    public int totalBagWeight() {
        return this.flight.getTotalBagCount() * 25;
    }

    public int bagCapacityLeft() {
        return this.maxBagWeight() - this.totalBagWeight();
    }

    public void sortPassengers() {
        ArrayList<Passenger> passengers = this.flight.getPassengers();
        boolean sorted = false;
        Passenger temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < this.flight.passengerCount() - 1; i++) {

                if ((passengers.get(i).getSeatNumber().compareTo((passengers.get(i + 1).getSeatNumber()))) > 0) {
                    //if yes assign first seat number to temp variable
                    temp = passengers.get(i);
                    //swap the first number with the one that comes next
                    passengers.set(i, passengers.get(i + 1));
                    // seatNumbers.get(j-1) = seatNumbers.get(j);
                    // and the one that was next with the one that came before
                    passengers.set(i + 1, temp);
                    // seatNumbers.get(j) = temp;
                    sorted = false;
                }
            }
        }
    }

    public Passenger findPassengerAtSeat(Integer seatNumber) {

        this.sortPassengers();
        ArrayList<Passenger> sortedPassengers = this.flight.getPassengers();
        Passenger foundPassenger = null;

        while (foundPassenger == null) {
            int middle = 0;

            if (sortedPassengers.size() > 1) {
                middle = (int) Math.ceil((double) sortedPassengers.size() / 2);
            }

            Integer middleSeatNumber = sortedPassengers.get(middle).getSeatNumber();

            if (seatNumber.equals(middleSeatNumber)) {
                foundPassenger = sortedPassengers.get(middle);
            }


            if (seatNumber < middleSeatNumber) {
                sortedPassengers = new ArrayList<Passenger>(sortedPassengers.subList(0, middle));
            } else {
                sortedPassengers = new ArrayList<Passenger>(sortedPassengers.subList(middle + 1, sortedPassengers.size()));
            }

        }

        return foundPassenger;
    }


}






