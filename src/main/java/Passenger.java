public class Passenger {

    private String name;
    private int noOfBags;
    private String flightNumber;
    private Integer seatNumber;

    public Passenger(String name, int noOfBags){
       this.name = name;
       this.noOfBags = noOfBags;
       this.flightNumber = "";
       this.seatNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int getNoOfBags() {
        return noOfBags;
    }

    public void setFlightNumber(String flightNo) {
        this.flightNumber = flightNo;
    }

    public void allocateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }
}
