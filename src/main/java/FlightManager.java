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

    

}
